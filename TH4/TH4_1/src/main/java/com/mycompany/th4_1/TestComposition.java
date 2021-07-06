/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th4_1;

import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class TestComposition {
    static Scanner sc = new Scanner(System.in);
    public static void menu(){
        System.out.println("\n\n1.Add Shade");
        System.out.println("2.Remove Shade");
        System.out.println("3.Get Child");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    public static void switch_num(int num,Graphic test){
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
                    for(Shade a: test.list){
                        if(a.getClass().getSimpleName().equalsIgnoreCase("Point")) test.Remove(a);
                    }
                }
                if(Shade.equalsIgnoreCase("line")){
                    for(Shade a: test.list){
                        if(a.getClass().getSimpleName().equalsIgnoreCase("Line")) test.Remove(a);
                    }
                }
                if(Shade.equalsIgnoreCase("circle")){
                    for(Shade a: test.list){
                        if(a.getClass().getSimpleName().equalsIgnoreCase("Circle")) test.Remove(a);
                    }
                }
                if(Shade.equalsIgnoreCase("retangular")){
                    for(Shade a: test.list){
                        if(a.getClass().getSimpleName().equalsIgnoreCase("Retangular")) test.Remove(a);
                    }
                }
            }
            case 3 ->{
               System.out.println("Input index shade want to getChild:");
               int index = Integer.parseInt(sc.nextLine());
               test.GetChild(index);
            }
        }
    }
    public static void main(String[] args) {
        int num;
        Graphic test = new Graphic();
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num, test);
        }while(num != 0);
    }
}
