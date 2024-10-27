package jdbc_maven_connection;

import java.sql.*;

public class JDBCMavenDemo {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "naol_kumela_password";

        Connection conn = null;

        try {
           
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Established Connection");
            System.out.println("Hello from Naol Kumela! We are connecting using Maven");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Make sure to include the driver in your project.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred while connecting to the database.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        } finally {
           
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.err.println("Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }
    }
}
