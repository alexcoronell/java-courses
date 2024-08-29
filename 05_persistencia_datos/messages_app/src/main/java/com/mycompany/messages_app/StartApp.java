/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messages_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author alexcoronell
 */
public class StartApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
                
        DBConnect connection = new DBConnect();
        
        int option = 0;
        
        do{
            System.out.println("---------------------------------------------------");
            System.out.println("--------------- Message Application ---------------");
            System.out.println("1. Create message");
            System.out.println("2. Show Messages");
            System.out.println("3. Update message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    MessagesService.create();
                    break;
                case 2:
                    MessagesService.getAll();
                    break;
                case 3:
                    MessagesService.update();
                    break;
                case 4:
                    MessagesService.delete();
                    break;
                default:
                    break;
            }
        } while(option != 5);
        
        try(Connection cnx = connection.getConnection()){
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    
}
