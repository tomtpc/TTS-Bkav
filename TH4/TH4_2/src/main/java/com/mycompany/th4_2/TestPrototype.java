/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th4_2;

import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class TestPrototype {
    static Scanner sc = new Scanner(System.in);
    public static void menu(){
        System.out.println("\n\n1.Add Shade");
        System.out.println("2.Remove Shade");
        System.out.println("3.Get Child");
        System.out.println("4.List.");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    public static void switch_num(int num,Prototype test){
        switch(num){
            case 1 ->{
                Shade a = null;
                test.Add(a);
            }
            case 2 ->{
                String Shade = "";
                System.out.println("Which Shade wants to remove:");
                Shade = sc.nextLine();
                if(Shade.equalsIgnoreCase("point")) {
                    for(int i = 0 ; i < test.list.size(); i++){
                        if(test.list.get(i).getClass().getSimpleName().equalsIgnoreCase("Point")) test.Remove(test.list.get(i));
                    }
                }
                if(Shade.equalsIgnoreCase("line")){
                    for(int i = 0 ; i < test.list.size(); i++){
                        if(test.list.get(i).getClass().getSimpleName().equalsIgnoreCase("Line")) test.Remove(test.list.get(i));
                    }
                }
                if(Shade.equalsIgnoreCase("circle")){
                    for(int i = 0 ; i < test.list.size(); i++){
                        if(test.list.get(i).getClass().getSimpleName().equalsIgnoreCase("Circle")) test.Remove(test.list.get(i));
                    }
                }
                if(Shade.equalsIgnoreCase("retangular")){
                    for(int i = 0 ; i < test.list.size(); i++){
                        if(test.list.get(i).getClass().getSimpleName().equalsIgnoreCase("Retangular")) test.Remove(test.list.get(i));
                    }
                }
            }
            case 3 ->{
               System.out.println("Input index shade want to getChild:");
               int index = Integer.parseInt(sc.nextLine());
               test.GetChild(index);
            }
            case 4 ->{
                test.count();
            }
        }
    }
    public static void main(String[] args) {
        int num;
        Prototype test = new Prototype();
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num, test);
        }while(num != 0);
    }
}
