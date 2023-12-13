/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author habib
 */

public class DatabaseConfig {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/habibur_rahman";
    private static final String JDBC_USERNAME = "habib";
    private static final String JDBC_PASSWORD = "1qaz2wsx";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
  }
}
