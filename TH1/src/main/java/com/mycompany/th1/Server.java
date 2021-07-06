/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Server extends UnicastRemoteObject implements ChatInterface{
    private static final long serialVersionUID = 1L;
    private String clientName [] = {"tom","thomas","thanh","hoang","wuyn"};
    private String clientPass [] = {"123","123","123","123","123"};
    private ArrayList<ChatInterface> clientList;
 
    protected Server() throws RemoteException {
        clientList = new ArrayList<ChatInterface>();
    }

    public synchronized boolean checkClientCredintials(ChatInterface chatinterface,String clientname,String password) throws RemoteException {
        boolean chkLog = false;  
        for(int i=0; i<clientName.length; i++) {
            if(clientName[i].equals(clientname) && clientPass[i].equals(password)) {
                chkLog = true;
                this.clientList.add(chatinterface);
            }
        }
        return chkLog;
    }
 
    public synchronized void broadcastMessage(String clientname , String message) throws RemoteException {
        for(int i=0; i<clientList.size(); i++) {
            clientList.get(i).sendMessageToClient(clientname.toUpperCase() + " : "+ message);
        }
    }
 
    public synchronized void sendMessageToClient(String message) throws RemoteException{}

    public static void main(String[] arg) throws RemoteException, MalformedURLException {
        Registry regis = LocateRegistry.createRegistry(1234);
        regis.rebind("local", new Server());
        System.out.println("Server is up and running....");
    }
}
