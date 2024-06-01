package Dao;

import Vo.BookmarkVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDao extends jdbcManager{
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

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
