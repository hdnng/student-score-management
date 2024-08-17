/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=web_quan_ly_dh;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }   
    
//    
//   
//    public static void main(String[] args) {
//        try {
//            // Initialize the database
//            Connection con = DBConnection.getConnection();
//            
//            // Check if connection is successful
//            if (con != null) {
//                System.out.println("Database Connection Successful!");
//                con.close();
//            } else {
//                System.out.println("Failed to make connection!");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            System.out.println("Database Connection Failed!");
//        }
//    }

}
