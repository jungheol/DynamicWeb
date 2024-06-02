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

    public void modifyBookmark(String name, int order_idx, int id) throws SQLException {

        String sql = "UPDATE bookmark_group " +
                " SET name = ?, order_idx = ?, modifyDate = DATETIME('now') " +
                " WHERE id = ?;";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, order_idx);
            stmt.setInt(3, id);

            int affectedRows = stmt.executeUpdate();
            if(affectedRows > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
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

    public void deleteBookmark(int id) throws SQLException {

        String sql = "DELETE FROM bookmark_group " +
                " WHERE id = ?;";

        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();
            if(affectedRows > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
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

    public List<BookmarkVo> selectBookmarkOnedata(int id) throws Exception {

        String sql = "SELECT * FROM bookmark_group " +
                " WHERE id = ?";

        try {
            conn = createConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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

    public List<BookmarkVo> selectbookmarkAll() throws Exception {

        String sql = "SELECT * FROM bookmark_group " +
                " ORDER BY order_idx;";

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
