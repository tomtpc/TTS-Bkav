/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th2_1;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Node {
    int item;
    Node next;

    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node() {
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
