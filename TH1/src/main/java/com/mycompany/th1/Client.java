/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Client extends UnicastRemoteObject implements ChatInterface , Runnable  {
    private static final long serialVersionUID = 1L;
    private ChatInterface server;
    private String ClientName;
    boolean chkExit = true;
    boolean chkLog = false;
 
    protected Client(ChatInterface chatinterface,String clientname,String password) throws RemoteException {
        this.server = chatinterface;
        this.ClientName = clientname;
        chkLog = server.checkClientCredintials(this,clientname,password);
    }

    public void sendMessageToClient(String message) throws RemoteException {
        System.out.println(message); 
    }
 
    public void broadcastMessage(String clientname,String message) throws RemoteException {}
 
    public boolean checkClientCredintials(ChatInterface chatinterface ,String clientname,String password) throws RemoteException {
        return true;
    }

    public void run() {
        if(chkLog) {
            System.out.println("Successfully Connected To Server");
            System.out.println("NOTE : Type LOGOUT to Exit From The Service");
            System.out.println("Now Your Online To Chat\n");
            Scanner scanner = new Scanner(System.in);
            String message;
            
            while(chkExit) {
                message = scanner.nextLine();
                if(message.equals("LOGOUT")) {
                    chkExit = false;
                }
                else {
                    try {
                        server.broadcastMessage(ClientName , message);
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }  
            } 
            System.out.println("\nSuccessfully Logout From The Chat Program\n");
        }
        else {
            System.out.println("\nClient Name or Password Incorrect...");
        }  
    }
    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException {
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("~~ Welcome To Chat Program ~~");  
        System.out.println("Enter The Name : ");
        String clientName = scanner.nextLine();
        System.out.println("Enter The Password : ");
        String clientPassword = scanner.nextLine();
        System.out.println("\nConnecting To Server...\n");
        var client = LocateRegistry.getRegistry("localhost",1234);
        ChatInterface chatinterface = (ChatInterface)client.lookup("local");
        new Thread(new Client(chatinterface , clientName , clientPassword)).start();
    }
}
