/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.th1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public interface ChatInterface extends Remote{
    boolean checkClientCredintials(ChatInterface ci,String name, String pass) throws RemoteException;
    void broadcastMessage(String name,String message) throws RemoteException;
    void sendMessageToClient(String message) throws RemoteException;

}
