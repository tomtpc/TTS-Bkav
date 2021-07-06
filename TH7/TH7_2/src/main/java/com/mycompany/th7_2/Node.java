/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th7_2;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Node {
    char val;
    Node right;
    Node left;
    
    
    public Node(char val) {
        this.val = val;
        this.left = null;
        this.right = null;  
    }
}
