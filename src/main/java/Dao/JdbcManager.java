package Dao;

import java.sql.*;


public class JdbcManager {

    public void closeResultSet(ResultSet rs){
        try {
            if(rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(PreparedStatement stmt){
        try {
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection conn){
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String path = "/Users/jeong-haneol/JAVA_zerobase/DynamicWeb/src/main/resources/wifi.db";

        return DriverManager.getConnection("jdbc:sqlite:" + path);
    }
}



