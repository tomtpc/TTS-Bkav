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
public class Circle implements Serializable{
    private int x,y;
    private double r;

    public Circle() {
    }

    public Circle(int x, int y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    public Double getAcreage(){
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public String toString() {
        return "Circle{" + "x=" + x + ", y=" + y + ", r=" + r + ", Acreage=" + getAcreage() +'}';
    }  
    
}
