/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th2_1;

import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class TestStack {
    public static void menu(){
        System.out.println("1.Push Node");
        System.out.println("2.Pop Node");
        System.out.println("3.Check Empty");
        System.out.println("4.Size of Stack");
        System.out.println("5.Display Stack");
        System.out.println("0.Exit");
        System.out.println("Enter:");
    }
    
    public static void switch_num(int num,Stack stack){
        switch(num){
            case 1->{
                stack.push();
            }
            case 2->{
                stack.pop();
            }
            case 3->{
                System.out.println("Stack is empty: "+stack.isEmpty());
            }
            case 4->{
                System.out.println("Size of Stack: "+stack.numOfEmlement());
            }
            case 5->{
                System.out.println(stack.display());
            }
        }
    }
    public static void main(String[] args) {
        Stack test = new Stack();
        int num = 0;
        Scanner sc = new Scanner(System.in);
        do{
            menu();
            num = Integer.parseInt(sc.nextLine());
            switch_num(num, test);
        }while(num != 0);
    }
}
