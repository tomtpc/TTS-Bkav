/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th4_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Graphic extends Shade{
    static public ArrayList<Shade> list = new ArrayList<>();
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
           }
           case 2->{
               a = new Line();
               a.Operation();
               list.add(a);
           }
           case 3->{
               a = new Circle();
               a.Operation();
               list.add(a);
           }
           case 4->{
               a = new Retangular();
               a.Operation();
               list.add(a);
           }
       }
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
