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
public class ExpressionTree {
    Node root;
    private StackNode top;

    public ExpressionTree() {
        top = null;
    }
    
    public void push(Node node){
        if(top == null){
            top = new StackNode(node);
        }else{
            StackNode newNode = new StackNode(node);
            newNode.next = top ;
            top = newNode;
        }
    }
    
    private Node pop(){
        if(top == null){
            System.out.println("no expression tree");
        }else{
            Node node = top.node;
            top = top.next;
            return node; 
        }
        return null;
    }
    
    private Node peek(){
        return top.node;
    }
    
    private void insertChar(char val){
        if(isDigital(val)){
            Node node = new Node(val);
            push(node);
        }else if(isOperator(val)){
            Node node = new Node(val);
            node.left = pop();
            node.right = pop();
            push(node);
        }
    }
    
    private boolean isDigital(char val){
        return val >= '0' && val <= '9';
    }
    
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    private int toDigit(char ch)
    {
        return ch - '0';
    }
    
    public void buildTree(String eqn)
    {
        for (int i = eqn.length() - 1; i >= 0; i--)
            insertChar(eqn.charAt(i));
    }
    
    public double evaluate()
    {
        return evaluate(peek());
    }
    
    public double evaluate(Node node)
    {
        if (node.left == null && node.right == null)
            return toDigit(node.val);
        else
        {
            double result = 0.0;
            double left = evaluate(node.left);
            double right = evaluate(node.right);
            char operator = node.val;
 
            switch (operator){
                case '+' : 
                    result = left + right; 
                    break;
                case '-' : 
                    result = left - right; 
                    break;
                case '*' : 
                    result = left * right; 
                    break;
                case '/' : 
                    result = left / right; 
                    break;
                default  : 
                    result = left + right; 
                    break;
            }
            return result;
        }
    }
    
    public void prefix()
    {
        traversePreOrder(peek());
    }
    public void traversePreOrder(Node node){
        if (node != null) {
            System.out.print(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
   
}
