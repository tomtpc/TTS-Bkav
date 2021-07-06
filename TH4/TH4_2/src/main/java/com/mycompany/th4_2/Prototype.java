/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th4_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Prototype extends Shade {
    static ArrayList<Shade> list = new ArrayList<>();
    @Override
    void Operation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void menu_shade(){
        System.out.println("1.Point");
        System.out.println("2.Line");
        System.out.println("3.Circle");
        System.out.println("4.Retangular");
        System.out.println("Enter:");
    }
    public void copy_cons(){
        System.out.println("Want to copy constructor ? (1/0)");
        System.out.println("Enter:");
    }
    public void clone_option(){
        System.out.println("Want to copy constructor ? (1/0)");
        System.out.println("Enter:");
    }
    @Override
    void Add(Shade a) {
       int selection;
       Scanner sc = new Scanner(System.in);
       menu_shade();
       selection = Integer.parseInt(sc.nextLine());
       switch(selection){
           case 1->{
               a = new Point();
               a.Operation();
               list.add(a);
               copy_cons();
               int num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   Point b = new Point((Point) a);
                   list.add(b);
               }
               clone_option();
               num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   try {
                        Point b = (Point)((Point)a).clone();
                        list.add(b);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
           }
           case 2->{
               a = new Line();
               a.Operation();
               list.add(a);
               copy_cons();
               int num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   Line b = new Line((Line) a);
                   list.add(b);
               }clone_option();
               num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   try {
                        Line b = (Line)((Line)a).clone();
                        list.add(b);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
           }
           case 3->{
               a = new Circle();
               a.Operation();
               list.add(a);
               copy_cons();
               int num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   Circle b = new Circle((Circle) a);
                   list.add(b);
               }
               if(num == 1){
                   try {
                        Circle b = (Circle)((Circle)a).clone();
                        list.add(b);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
           }
           case 4->{
               a = new Retangular();
               a.Operation();
               list.add(a);
               copy_cons();
               int num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   Retangular b = new Retangular((Retangular) a);
                   list.add(b);
               }clone_option();
               num = Integer.parseInt(sc.nextLine());
               if(num == 1){
                   try {
                        Retangular b = (Retangular)((Retangular)a).clone();
                        list.add(b);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Prototype.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
           }
       }
    }
    
    public void count(){
        System.out.println("Count Shade: ");
            int po = 0,li = 0,cir = 0,re = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getClass().getSimpleName().equalsIgnoreCase("line")) li += 1;
                if(list.get(i).getClass().getSimpleName().equalsIgnoreCase("cirlce")) cir += 1;
                if(list.get(i).getClass().getSimpleName().equalsIgnoreCase("retangular")) re += 1;
                if(list.get(i).getClass().getSimpleName().equalsIgnoreCase("point")) po += 1;
            }
            System.out.println("Point(s): "+po);
            System.out.println("Line(s): "+li);
            System.out.println("Circle(s): "+cir);
            System.out.println("retangular: "+re);
    }

    @Override
    void Remove(Shade a) {
        list.remove(a);
        System.out.println("Removed Shade a:" + a );
    }

    @Override
    void GetChild(int a) {
        if(a > list.size()) System.out.println("Index a is not in Shade list's range.");
        for(int i = 0 ; i < list.size(); i++){
            if(i == a) System.out.println("Index "+a+" in Shade list is: "+list.get(i).getClass().getSimpleName());
        }
    }
}
