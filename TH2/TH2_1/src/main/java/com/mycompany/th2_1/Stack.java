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
public class Stack {
    Node top;
    int size;

    Scanner sc = new Scanner(System.in);
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    
    
    public void push(){
        if(this.size == 0){
            System.out.println("Input item for the new node: "); int item_node = Integer.parseInt(sc.nextLine());
            Node temp = new Node(item_node, null);
            this.top = temp;
            this.size += 1;
        }else{
            System.out.println("Input item for the new node: "); int item_node = Integer.parseInt(sc.nextLine());
            Node temp = new Node(item_node, this.top);
            this.top = temp;
            this.size += 1;
        }
    }
    public void pop(){
        if(size != 0){
            System.out.println("Input value of the node to find: "); int item_node = Integer.parseInt(sc.nextLine());
            Node temp = this.top;
            Node temp_pre = null;
            if(temp != null && temp.item == item_node){
                this.top = temp.next;
                System.out.println(temp.item);
                size -= 1;
            }else{
                while(temp != null && temp.item != item_node){
                    temp_pre = temp;
                    temp = temp.next;
                }
                if(temp == null){
                    System.out.println("-1");
                }
                temp_pre.next = temp.next;
                System.out.println(temp.item);
                size -= 1;
            } 
        }else{
            System.out.println("-1");
        }
    }
    
    public boolean isEmpty(){
        if(this.size == 0) return true;
        return false;
    }
    
    public int numOfEmlement(){
        return this.size;
    }
    
    public String display(){
        String ans ="";
        Node temp = this.top;
        while(true){
            ans += temp.item+" -> ";
            temp = temp.next;
            if(temp == null ) {
                ans += "null";
                break;
            }
        }
        return ans;
    }
}
