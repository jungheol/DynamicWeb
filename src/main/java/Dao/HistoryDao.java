package Dao;

import Vo.HistoryVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao extends jdbcManager{
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<HistoryVo> HistoryselectAll() throws Exception {

        String sql = "SELECT * FROM history " +
                    "ORDER BY id DESC;";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<HistoryVo> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new HistoryVo(
                        rs.getString("id"),
                        rs.getString("lat"),
                        rs.getString("lnt"),
                        rs.getString("date")
                        )
                );
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return null;
    }
}
