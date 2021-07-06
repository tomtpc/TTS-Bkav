/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th7_2;

import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class app {
    public static void main(String[] args) {
        ExpressionTree expTr = new ExpressionTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input prefix order of the tree:");
        expTr.buildTree(sc.nextLine());
        System.out.println("Pre-oder Traverse: "); expTr.prefix();
        System.out.println("\n\n\nEvaluted Result: "+ expTr.evaluate());
        
        //example input: +-+7*/935/82*/625
    }
}
