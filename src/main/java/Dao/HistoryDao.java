package Dao;

import Vo.HistoryVo;
import Vo.WifiVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao extends jdbcManager{
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void saveHistory(Double lat, Double lnt) throws SQLException {

        String sql = "INSERT INTO history (lat, lnt, date) " +
                    " VALUES(?, ?, DATETIME('now'));";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, lat);
            stmt.setDouble(2, lnt);
            conn.commit();

            int affectedRows = stmt.executeUpdate();

            if(affectedRows > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    public List<HistoryVo> historyselectAll() throws Exception {

        String sql = "SELECT * FROM history " +
                    " ORDER BY id DESC;";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<HistoryVo> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new HistoryVo(
                        rs.getString("id"),
                        rs.getDouble("lat"),
                        rs.getDouble("lnt"),
                        rs.getString("date")
                        )
                );
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return null;
    }

    public Double[] selectLast() throws Exception {

        String sql = "SELECT * FROM history " +
                " ORDER BY id DESC LIMIT 1;";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            Double[] arr = new Double[2];

            while (rs.next()) {
                arr[0] = rs.getDouble("lat");
                arr[1] = rs.getDouble("lnt");
            }
            return arr;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return null;
    }
}
