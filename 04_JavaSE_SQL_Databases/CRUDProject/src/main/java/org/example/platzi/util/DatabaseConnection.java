package org.example.platzi.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String database = "java_sql_database";
    private  static String url = "jdbc:mysql://localhost:3306/" + database;
    private  static String user = "root";
    private static String pass = "root";
    private static  BasicDataSource pool;
    //private static Connection connection;

    /*public static Connection getInstance() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }*/

    public static BasicDataSource getInstance() {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }
}
