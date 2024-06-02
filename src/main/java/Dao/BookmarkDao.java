package Dao;

import Vo.BookmarkVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDao extends jdbcManager{
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void saveBookmark(String name, int order_idx) throws SQLException {

        String sql = "INSERT INTO bookmark_group (name, order_idx, addDate) " +
                " VALUES(?, ?, DATETIME('now'));";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, order_idx);

            int affectedRows = stmt.executeUpdate();
            if(affectedRows > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    public List<BookmarkVo> selectbookmarkAll() throws Exception {

        String sql = "SELECT * FROM bookmark_group " +
                " ORDER BY order_idx DESC;";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<BookmarkVo> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new BookmarkVo(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("order_idx"),
                                rs.getString("addDate"),
                                rs.getString("modifyDate")
                        )
                );
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return null;
    }
}
