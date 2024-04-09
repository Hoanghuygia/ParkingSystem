package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

// //    SQL Server
//    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MovieSystem;encrypt=false";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "password";

//    MySQL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DB_URL = "root@127.0.0.1:3306";
    private static final String DB_URL = "jdbc:mysql://localhost:3307/ParkingSystem?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "huy1234";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
