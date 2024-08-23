package org.example.platzi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String database = "java_sql_database";
    private  static String url = "jdbc:mysql://localhost:3306/" + database;
    private  static String user = "root";
    private static String pass = "root";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}
