/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th2_2;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class app {
    static ArrayList<Circle> cir = new ArrayList<>();
    static ArrayList<Ellipse> ell = new ArrayList<>();
    static ArrayList<Rectangle> rec = new ArrayList<>();
    static ArrayList<Square> sq = new ArrayList<>();
    static int cir_count = 0 ;
    static int ell_count = 0;
    static int rec_count = 0;
    static int sq_count = 0;
    
    static Scanner sc = new Scanner(System.in);
    
    public static void menu(){
        System.out.println("1.Input a Circle data");
        System.out.println("2.Input a Ellipse data");
        System.out.println("3.Input a Rectangle data");
        System.out.println("4.Input a Square data");
        System.out.println("5.Display all");
        System.out.println("6.Sum of area(s)");
        System.out.println("7.Count shape");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    
    public static void input_cir(){
        Circle temp = new Circle();
        System.out.println("Input Ox: "); temp.setX(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Oy: "); temp.setY(Integer.parseInt(sc.nextLine()));
        System.out.println("Input R:");temp.setR(Double.parseDouble(sc.nextLine()));
        cir.add(temp);
        cir_count += 1;
    }
    
    public static void input_ell(){
        Ellipse temp = new Ellipse();
        System.out.println("Input Ox: "); temp.setX(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Oy: "); temp.setY(Integer.parseInt(sc.nextLine()));    
        System.out.println("Input a: ");temp.setA(Double.parseDouble(sc.nextLine()));
        System.out.println("Input b: ");temp.setB(Double.parseDouble(sc.nextLine()));
        ell.add(temp);
        ell_count += 1;
    }
    
    public static void input_re(){
        Rectangle temp = new Rectangle();
        System.out.println("Input Ax: "); temp.setAx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Ay: "); temp.setAy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Bx: "); temp.setBx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input By: "); temp.setBy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Cx: "); temp.setCx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Cy: "); temp.setCy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Dx: "); temp.setDx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Dy: "); temp.setDy(Integer.parseInt(sc.nextLine())); 
        rec.add(temp);
        rec_count += 1;
    }
    
    public static void input_sq(){
        Square temp = new Square();
        System.out.println("Input Ax: "); temp.setAx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Ay: "); temp.setAy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Bx: "); temp.setBx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input By: "); temp.setBy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Cx: "); temp.setCx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Cy: "); temp.setCy(Integer.parseInt(sc.nextLine())); 
        System.out.println("Input Dx: "); temp.setDx(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Dy: "); temp.setDy(Integer.parseInt(sc.nextLine())); 
        if(Point2D.distance(temp.getAx(), temp.getAy(), temp.getBx(), temp.getBy()) == Point2D.distance(temp.getCx(), temp.getCy(), temp.getDx(), temp.getDy())){
            sq.add(temp);
            sq_count += 1;
        }else{
            System.out.println("What you enter is not a square data. Retry !");
            input_sq();
        }
    }
    
    public static void switch_num(int num){
        switch(num){
            case 1->{
                input_cir();
            }
            case 2->{
                input_ell();
            }
            case 3->{
                input_re();
            }
            case 4->{
                input_sq();
            }
            case 5->{
                for(Circle a: cir){
                    System.out.println(a.toString());
                }
                for(Ellipse a: ell){
                    System.out.println(a.toString());
                }
                for(Rectangle a: rec){
                    System.out.println(a.toString());
                }
                for(Square a: sq){
                    System.out.println(a.toString());
                }
            }
            case 6->{
                Double ans = 0.0;
                for(Circle a: cir){
                    ans += a.getAcreage();
                }
                for(Ellipse a: ell){
                    ans += a.getAcreage();
                }
                for(Rectangle a: rec){
                    ans += a.getAcreage();
                }
                for(Square a: sq){
                    ans += a.getAcreage();
                }
                System.out.println("Sum of Area: "+ans);
            }
            case 7->{
                System.out.println("Cir count: "+cir_count);
                System.out.println("Ell count: "+ell_count);
                System.out.println("Rec count: "+rec_count);
                System.out.println("Sq count: "+sq_count);
            }
        }
    }
    
    public static void main(String[] args) {
        int num = 0 ;
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num);
        }while(num != 0);
    }
}
