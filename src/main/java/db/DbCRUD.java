package db;

import java.sql.*;

public class DbCRUD {
    public void dbSelect(History history) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        if(conn == null) {
            try {
                // 드라이버 로드
                Class.forName("org.sqlite.JDBC");

                // 커넥션 객체 생성
                conn = DriverManager.getConnection("jdbc:sqlite:" + "testdb.db");
                // 스테이트먼트 객체 생성

                String sql = "SELECT member_type, user_id, password, name " +
                        " FROM member " +
                        " where member_type = ? ";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, memberTypeValue);

                rs = stmt.executeQuery();

                while (rs.next()) {
                    history.getxPoint() = rs.getString("member_type");
                    String userId = rs.getString("user_id");
                    String password = rs.getString("password");
                    String name = rs.getString("name");

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(stmt != null && !stmt.isClosed()) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dbInsert() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "3333";
        String nameValue = "제로베이스";
        if(conn == null) {
            try {
                // 드라이버 로드
                Class.forName("org.sqlite.JDBC");

                // 커넥션 객체 생성
                conn = DriverManager.getConnection("jdbc:sqlite:" + "testdb.db");
                // 스테이트먼트 객체 생성

                String sql = "INSERT into member (member_type, user_id, password, name) " +
                        " VALUES (?, ?, ?, ?); ";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, memberTypeValue);
                stmt.setString(2, userIdValue);
                stmt.setString(3, passwordValue);
                stmt.setString(4, nameValue);

                int affectedRows = stmt.executeUpdate();

                if(affectedRows > 0) {
                    System.out.println("저장 성공");
                } else {
                    System.out.println("저장 실패");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(stmt != null && !stmt.isClosed()) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dbUpdate() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        if(conn == null) {
            try {
                // 드라이버 로드
                Class.forName("org.sqlite.JDBC");

                // 커넥션 객체 생성
                conn = DriverManager.getConnection("jdbc:sqlite:" + "testdb.db");
                // 스테이트먼트 객체 생성

                String sql = "UPDATE member SET " +
                        " password = ? " +
                        " where member_type = ? and user_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, passwordValue);
                stmt.setString(2, memberTypeValue);
                stmt.setString(3, userIdValue);

                int affectedRows = stmt.executeUpdate();

                if(affectedRows > 0) {
                    System.out.println("수정 성공");
                } else {
                    System.out.println("수정 실패");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(stmt != null && !stmt.isClosed()) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dbDelete() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";

        if(conn == null) {
            try {
                // 드라이버 로드
                Class.forName("org.sqlite.JDBC");

                // 커넥션 객체 생성
                conn = DriverManager.getConnection("jdbc:sqlite:" + "testdb.db");
                // 스테이트먼트 객체 생성

                String sql = "DELETE from member " +
                        " where member_type = ? and user_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, memberTypeValue);
                stmt.setString(2, userIdValue);

                int affectedRows = stmt.executeUpdate();

                if(affectedRows > 0) {
                    System.out.println("삭제 성공");
                } else {
                    System.out.println("삭제 실패");
                }
             } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null && !rs.isClosed()) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(stmt != null && !stmt.isClosed()) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
