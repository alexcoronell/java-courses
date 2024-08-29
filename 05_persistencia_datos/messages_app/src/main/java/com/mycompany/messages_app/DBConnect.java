/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexcoronell
 */
public class DBConnect {

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app", "messages_app", "messages_app");
            if (connection != null) {
                System.out.println("Connection completed");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return connection;
    }
}
