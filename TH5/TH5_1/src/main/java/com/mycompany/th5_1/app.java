/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th5_1;

import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class app {
    
    static Scanner sc = new Scanner(System.in);
    public static void menu(){
        System.out.println("1.Create News Com");
        System.out.println("2.Add An Employee");
        System.out.println("3.Move An Employee");
        System.out.println("4.Fire An Employee");
        System.out.println("5.Show all");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    public static void switch_num(int num , News_Company com){
        switch(num){
            case 1->{
                System.out.println("Com name: "); com.setCom_name(sc.nextLine());
                System.out.println("Create Com success");
            }
            case 2->{
                com.add_em();
            }
            case 3->{
                com.move_em();
            }
            case 4->{
                com.fire_em();
            }
            case 5->{
                com.display();
            }
        }
    }
    public static void main(String[] args) {
        int num = 0;
        News_Company com = new News_Company();
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num, com);
        }while(num != 0);
    }
}
