/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messages_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author alexcoronell
 */
public class MessagesDAO {
    
    public static void getAll(){
        DBConnect connect = new DBConnect();
        try(Connection connection = connect.getConnection()){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                String sql = "SELECT * FROM messages";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.print("ID: " + resultSet.getInt("id") + " |");
                    System.out.print("Message: " + resultSet.getString("message") + " - ");
                    System.out.print("Author: " + resultSet.getString("author") + "\n");
                }
                System.out.println("---------------");
                System.out.println("End of messages");
                
            } catch(SQLException e) {
                System.err.println("There is a problem showing messages");
                System.out.println("Error: " + e);
            }
        } catch(SQLException e){
            System.err.println("There is a problem showing messages");
            System.out.println("Error: " + e);
        }
    }
    
    public static void get(int id){}
    
    public static void create(Message message){
        DBConnect connect = new DBConnect();
        try(Connection connection = connect.getConnection()){
            PreparedStatement preparedStatement = null;
            try{
                String sql = "INSERT INTO messages (message, author) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, message.message);
                preparedStatement.setString(2, message.author);
                preparedStatement.executeUpdate();
                System.out.println("Message created");
            } catch(SQLException e) {
                System.out.println("Message could not be saved");
                System.out.println("Error: " + e);
            }
        } catch(SQLException e){
            System.out.println("Message could not be saved");
            System.out.println("Error: " + e);
        }
    }
    
                
    public static void update(Message message){
        DBConnect connect = new DBConnect();
        try(Connection connection = connect.getConnection()){
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE messages SET message = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, message.getMessage());
                preparedStatement.setInt(2, message.getId());
                preparedStatement.executeUpdate();
                System.out.println("Message updated");
            } catch(SQLException e) {
                System.out.println("Message could not be updated");
                System.out.println("Error: " + e);
            }
        } catch(SQLException e){
            System.out.println("Message could not be updated");
            System.out.println("Error: " + e);
        }
    }
    
    public static void delete(int id){
        DBConnect connect = new DBConnect();
        try(Connection connection = connect.getConnection()){
            PreparedStatement preparedStatement = null;
            try{
                String sql = "DELETE FROM messages WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("Message deleted");
            } catch(SQLException e) {
                System.out.println("Message could not be deleted");
                System.out.println("Error: " + e);
            }
        } catch(SQLException e){
            System.out.println("Message could not be deleted");
            System.out.println("Error: " + e);
        }
    }
}
