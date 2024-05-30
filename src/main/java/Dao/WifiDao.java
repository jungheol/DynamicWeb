package Dao;

import Dto.RowInfoDto;
import java.sql.*;

import java.util.List;

public class WifiDao extends jdbcManager {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public void saveAllWifiDetailList(List<RowInfoDto> list) throws Exception {

        String sql = "INSERT INTO Wifi_info(x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm, " +
                " x_swifi_adres1, x_swifi_adres2, x_swifi_instl_floor, " +
                " x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se, " +
                " x_swifi_cmcwr, x_swifi_cnstc_year, x_swifi_inout_door, " +
                " x_swifi_remars3, lat, lnt, work_dttm) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);

            int batchSize = 1000;
            int count = 0;

            for (int i = 0; i < list.size(); i++) {
                RowInfoDto infoDto = list.get(i);
                stmt.setString(1, infoDto.getMgrNo());
                stmt.setString(2, infoDto.getWrdofc());
                stmt.setString(3, infoDto.getMainNm());
                stmt.setString(4, infoDto.getAdres1());
                stmt.setString(5, infoDto.getAdres2());
                stmt.setString(6, infoDto.getFloor());
                stmt.setString(7, infoDto.getTy());
                stmt.setString(8, infoDto.getMby());
                stmt.setString(9, infoDto.getSvcSe());
                stmt.setString(10, infoDto.getCmcwr());
                stmt.setString(11, infoDto.getYear());
                stmt.setString(12, infoDto.getDoor());
                stmt.setString(13, infoDto.getRemars3());
                stmt.setString(14, infoDto.getLat());
                stmt.setString(15, infoDto.getLnt());
                stmt.setString(16, infoDto.getDttm());

                stmt.addBatch();
                count++;

                if (batchSize == count) {
                    stmt.executeBatch();
                    stmt.clearBatch();
                    count = 0;
                }
            }

            stmt.executeBatch();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }
}
