/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th2_2;

import java.io.Serializable;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Ellipse implements Serializable{
    private int x,y;
    private Double a,b;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Ellipse(int x, int y, Double a, Double b) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
    }

    public Ellipse() {
    }
    
    public Double getAcreage(){
        return Math.PI * this.a * this.b;
    }

    @Override
    public String toString() {
        return "Ellipse{" + "x=" + x + ", y=" + y + ", a=" + a + ", b=" + b + ", Acreage=" + getAcreage() + '}';
    }
    
    
}
