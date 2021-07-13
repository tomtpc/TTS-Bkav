/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class CreateDB {
   static ArrayList<DataBase> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void show(){
        for(DataBase a: list){
            System.out.println(a.toString());
        }
    }
    public static void switch_num(int num) throws FileNotFoundException, IOException, ClassNotFoundException{
        switch(num){
            
            case 2->{
                FileOutputStream fos = new FileOutputStream("data.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
            }
            case 1->{
                DataBase temp = new DataBase();
                System.out.println("User name"); temp.setUser_name(sc.nextLine());
                System.out.println("Pass"); temp.setPass(sc.nextLine());
                list.add(temp);
            }
            case 3->{
                
                FileInputStream fis = new FileInputStream("data.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<DataBase>)ois.readObject();
                show();
            }
        }
    }
    public static void menu(){
        System.out.println("1.Add");
        System.out.println("2.Save");
        System.out.println("3.Read");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        int num = 0;
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num);
        }while(num != 0);
    }
}
