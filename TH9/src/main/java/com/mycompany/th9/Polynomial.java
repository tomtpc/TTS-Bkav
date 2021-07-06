/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th9;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Polynomial {
    private int[] coef; // coefficients p(x) = sum { coef[i] * x^i }
    private int degree; // degree of polynomial (-1 for the zero polynomial)
    
    public Polynomial(int a, int b){
        if(b < 0 ) System.out.println("Exponent can't be nagative. You entered: "+b);
        coef = new int[b+1];
        coef[b] = a;
        reduce();
    }
    
    private void reduce(){
        degree = -1;
        for(int i = coef.length - 1; i >= 0 ; i-- ){
            if(coef[i] != 0){
                degree = i;
                return;
            }
        }
    }
    
    public int degree() {
        return degree;
    }
    
    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] += that.coef[i];
        poly.reduce();
        return poly;
    }
    
    public Polynomial minus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) poly.coef[i] -= that.coef[i];
        poly.reduce();
        return poly;
    }
    
    public Polynomial times(Polynomial that) {
        Polynomial poly = new Polynomial(0, this.degree + that.degree);
        for (int i = 0; i <= this.degree; i++)
            for (int j = 0; j <= that.degree; j++)
                poly.coef[i+j] += (this.coef[i] * that.coef[j]);
        poly.reduce();
        return poly;
    }
    
    @Override
    public String toString() {
        switch (degree) {
            case -1 -> {
                return "0";
            }
            case 0 -> {
                return "" + coef[0];
            }
            case 1 -> {
                return coef[1] + "x + " + coef[0];
            }
            default -> {
            }
        }
        String s = coef[degree] + "x^" + degree;
        for (int i = degree - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }
    
    
    public static void main(String[] args) {
        Polynomial p1   = new Polynomial(4, 3);
        Polynomial p2   = new Polynomial(3, 2);
        Polynomial p3   = new Polynomial(2, 1);
        Polynomial p4   = new Polynomial(1, 0);
        Polynomial p    = p1.plus(p2).plus(p3).plus(p4);
        Polynomial q1 = new Polynomial(5,5);
        Polynomial q2 = new Polynomial(-5,3);
        Polynomial q = q1.plus(q2);
        Polynomial ans = q.plus(p);
        System.out.println("p(x) =  " + p);
        System.out.println("q(x) =  " + q);
        System.out.println("p(x) + q(x) =  " + ans);
    }
    
    
}
