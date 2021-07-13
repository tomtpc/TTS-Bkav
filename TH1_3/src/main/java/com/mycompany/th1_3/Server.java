/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1_3;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Server {
    static Vector<ClientHandler> ClientH = new  Vector<>();
    static ArrayList<DataBase> db = new ArrayList<>();
    static String log = "";
    public static boolean check_vaild(String name, String pass){
        if(db.isEmpty()) return false;
        if (db.stream().anyMatch(a -> (name.equals(a.getUser_name()) && pass.equals(a.getPass())))) {
            return true;
        }
        return false;
    }
    public static void read_db(){
        try{
            FileInputStream fis = new FileInputStream("data.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            db = (ArrayList<DataBase>)ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void write_log() throws FileNotFoundException, IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
        writer.write(log);
        writer.close();
    }
    public static String active_users(){
        String ans = "Active List: \n";
        for(ClientHandler a: ClientH){
            ans += ClientH.indexOf(a)+". "+a.getName()+"\n";
        }
        if(ClientH.isEmpty()){
            ans = "No one is online now";
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        Socket socket;
        read_db();
        while(true){
            socket = server.accept();
            System.out.println("New connection from: "+socket.getInetAddress()+":"+socket.getPort());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Trying to auth user");
            String[] first_mess = dis.readUTF().split("@");
            String user = first_mess[0];
            String pass = first_mess[1];
            if(check_vaild(user, pass)){
                dos.writeUTF("OK");
                dos.writeUTF(active_users());
                System.out.println("Re-directing client to a handler.");
                ClientHandler client = new ClientHandler(socket,user,dis,dos);
                Thread t = new Thread(client);
                System.out.println("Adding "+user+" to active usesr list.");
                ClientH.add(client);
                t.start();
            }
            if(ClientH.isEmpty()) break;
        }
        
    }

    private static class ClientHandler implements Runnable{
        Scanner sc = new Scanner(System.in);
        private String name;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket socket;
        boolean isLogined;

        public String getName() {
            return name;
        }

        public ClientHandler(Socket socket, String name,DataInputStream dis,DataOutputStream dos) {
            this.socket = socket;
            this.name = name;
            this.dis = dis;
            this.dos = dos;
            this.isLogined = true;
        }

        @Override
        public void run() {
            String received_str;
            while(true){
                try{
                    int is_user_logined = 0;
                    received_str = dis.readUTF();
                    System.out.println(received_str);
                    
                    if(received_str.equalsIgnoreCase("logout")){
                        this.isLogined = false;
                        this.socket.close();
                        this.dis.close();
                        this.dos.close(); 
                        break;
                    }
                    String[] converted_str = received_str.split("#");
                    String mess = converted_str[1];
                    String to_user =  converted_str[0];
                    for(ClientHandler ch: Server.ClientH){
                        if(ch.name.equals(to_user) && ch.isLogined == true){
                            ch.dos.writeUTF(this.name+": "+mess);
                            is_user_logined = 1;
                            log += this.name +" -> "+received_str+"\n";
                            write_log();
                        }
                    }
                    if(is_user_logined == 0){
                        this.dos.writeUTF("Server: "+to_user+" hasn't logined.");
                    }
                } catch (IOException ex) {
                } 
            }
        }
    }
}
