/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messages_app;

import java.util.Scanner;

/**
 *
 * @author alexcoronell
 */
public class MessagesService {
    
    public static void getAll(){
        MessagesDAO.getAll();
    }
    
    public static void get(){}
    
    public static void create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write a message: ");
        String message = sc.nextLine();
        System.out.println();
        System.out.print("Write your name: ");
        String name = sc.nextLine();
        
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setAuthor(name);
        MessagesDAO.create(newMessage);
    }
    
    public static void update(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write the new message: ");
        String message = sc.nextLine();
        System.out.println("Write the message ID you want to update: ");
        int id =  sc.nextInt();
        Message messageToUpdate = new Message();
        messageToUpdate.setId(id);
        messageToUpdate.setMessage(message);
        MessagesDAO.update(messageToUpdate);
    }
    
    public static void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write the message ID you want to delete: ");
        int id =  sc.nextInt();
        MessagesDAO.delete(id);
    }
}
