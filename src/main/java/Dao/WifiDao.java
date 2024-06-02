package Dao;

import Dto.RowInfoDto;
import Vo.WifiVo;

import java.sql.*;

import java.util.ArrayList;
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

    public List<WifiVo> searchNearWifi(Double lat, Double lnt) {

        String sql = "SELECT * " +
                ", round((6371 *  acos(cos(radians(" + lat + ")) * cos(radians(lat)) * cos(radians(lnt) - radians(" + lnt + ")) " +
                "+ sin(radians(" + lat + ")) * sin(radians(lat)))), 4) as distance " +
                " FROM Wifi_info " +
                " ORDER BY distance, X_SWIFI_MGR_NO" +
                " LIMIT 20";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();


            List<WifiVo> list = new ArrayList<>();


            while (rs.next()) {
                WifiVo wifiVo = new WifiVo(
                        rs.getString("distance"),
                        rs.getString("X_SWIFI_MGR_NO"),
                        rs.getString("X_SWIFI_WRDOFC"),
                        rs.getString("X_SWIFI_MAIN_NM"),
                        rs.getString("X_SWIFI_ADRES1"),
                        rs.getString("X_SWIFI_ADRES2"),
                        rs.getString("X_SWIFI_INSTL_FLOOR"),
                        rs.getString("X_SWIFI_INSTL_TY"),
                        rs.getString("X_SWIFI_INSTL_MBY"),
                        rs.getString("X_SWIFI_SVC_SE"),
                        rs.getString("X_SWIFI_CMCWR"),
                        rs.getString("X_SWIFI_CNSTC_YEAR"),
                        rs.getString("X_SWIFI_INOUT_DOOR"),
                        rs.getString("X_SWIFI_REMARS3"),
                        rs.getString("LAT"),
                        rs.getString("LNT"),
                        rs.getString("WORK_DTTM")

                );
                list.add(wifiVo);
            }
            return list;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    public void removeAllWifi() {
        int result = 0;
        String sql = "DELETE FROM Wifi_info; ";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            conn.commit();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    public List<WifiVo> detailWifi(String mainNm) {

        String sql = "SELECT *, 0 as distance FROM Wifi_info WHERE x_swifi_mgr_no = ?;";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mainNm);
            rs = stmt.executeQuery();

            List<WifiVo> list = new ArrayList<>();

            while (rs.next()) {
                WifiVo wifiVo = new WifiVo(
                        rs.getString("distance"),
                        rs.getString("X_SWIFI_MGR_NO"),
                        rs.getString("X_SWIFI_WRDOFC"),
                        rs.getString("X_SWIFI_MAIN_NM"),
                        rs.getString("X_SWIFI_ADRES1"),
                        rs.getString("X_SWIFI_ADRES2"),
                        rs.getString("X_SWIFI_INSTL_FLOOR"),
                        rs.getString("X_SWIFI_INSTL_TY"),
                        rs.getString("X_SWIFI_INSTL_MBY"),
                        rs.getString("X_SWIFI_SVC_SE"),
                        rs.getString("X_SWIFI_CMCWR"),
                        rs.getString("X_SWIFI_CNSTC_YEAR"),
                        rs.getString("X_SWIFI_INOUT_DOOR"),
                        rs.getString("X_SWIFI_REMARS3"),
                        rs.getString("LAT"),
                        rs.getString("LNT"),
                        rs.getString("WORK_DTTM")

                );
                list.add(wifiVo);
            }
            return list;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }
}
