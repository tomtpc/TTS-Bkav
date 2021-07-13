/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Client {
    final static int ServerPort = 1234;
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        Scanner sc = new Scanner(System.in);
        InetAddress serverIP = InetAddress.getByName("localhost");
        
        Socket s = new Socket(serverIP,ServerPort);
        
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Login Form");
        String first_send = "";
        System.out.println("User:"); first_send = sc.nextLine();
        System.out.println("Pass:"); first_send += ("@"+ sc.nextLine());
        dos.writeUTF(first_send);
        Thread send_mess = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    System.out.println("Type (recipient#mess):");
                    String mess = sc.nextLine();
                    try {
                        dos.writeUTF(mess);
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        Thread read_mess = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try {
                        String msg = dis.readUTF();
                        System.out.println(msg);       
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        String first_recieved="";
        String secound_received="";
        try{
            first_recieved = dis.readUTF();
            if(first_recieved.equalsIgnoreCase("OK")){
                System.out.println("Server accept?: "+first_recieved);
                secound_received = dis.readUTF();
                System.out.println(secound_received);
                System.out.println("\n\n\n");
                send_mess.start();
                read_mess.start();
            }else{
                System.out.println("Incorrect User/Pass !!!");
            } 
        }catch (IOException ex) {
            
        }
        
    }
}
