/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th7_1;

import java.util.Scanner;


/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class BinaryTree {
    Node root;
    
    private Node addRecursive(Node current, int key){
        if(current == null){
            return new Node(key);
        }
        if(key < current.key){
            current.left = addRecursive(current.left, key);
        }
        if(key > current.key){
            current.right = addRecursive(current.right, key);
        }else{
            return current;
        }
        return current;
    }
    
    public void addNode(int key){
        root = addRecursive(root, key);
    }
    
    public void traversePreOrder(Node node) {
    if (node != null) {
        System.out.print(" " + node.key);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }
}
}
