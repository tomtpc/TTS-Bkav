/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th2_2;

import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Rectangle implements Serializable{
    private int Ax, Ay;
    private int Bx, By;
    private int Cx, Cy;
    private int Dx, Dy;

    public Rectangle() {
    }

    public Rectangle(int Ax, int Ay, int Bx, int By, int Cx, int Cy, int Dx, int Dy) {
        this.Ax = Ax;
        this.Ay = Ay;
        this.Bx = Bx;
        this.By = By;
        this.Cx = Cx;
        this.Cy = Cy;
        this.Dx = Dx;
        this.Dy = Dy;
    }


    public int getAx() {
        return Ax;
    }

    public void setAx(int Ax) {
        this.Ax = Ax;
    }

    public int getAy() {
        return Ay;
    }

    public void setAy(int Ay) {
        this.Ay = Ay;
    }

    public int getBx() {
        return Bx;
    }

    public void setBx(int Bx) {
        this.Bx = Bx;
    }

    public int getBy() {
        return By;
    }

    public void setBy(int By) {
        this.By = By;
    }

    public int getCx() {
        return Cx;
    }

    public void setCx(int Cx) {
        this.Cx = Cx;
    }

    public int getCy() {
        return Cy;
    }

    public void setCy(int Cy) {
        this.Cy = Cy;
    }

    public int getDx() {
        return Dx;
    }

    public void setDx(int Dx) {
        this.Dx = Dx;
    }

    public int getDy() {
        return Dy;
    }

    public void setDy(int Dy) {
        this.Dy = Dy;
    }
    
    public Double getAcreage(){
        return Point2D.distance(Ax, Ay, Bx, By) * Point2D.distance(Cx, Cy, Dx, Dy);
    }

    @Override
    public String toString() {
        return "Reetangle {"+"A("+this.Ax+","+this.Ay+") "+"B("+this.Bx+","+this.By+") "+"A("+this.Cx+","+this.Cy+") "+"A("+this.Dx+","+this.Dy+") Acreage: "+this.getAcreage()+"}";
    }
}
