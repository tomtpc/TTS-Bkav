/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th4_2;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Line extends Shade implements Cloneable{

    Line() {
    }
    @Override
    public void Operation(){
        System.out.println("Drawing a Line.");
    }
    public Line(Line li){
        System.out.println("CopyConstructor() is called.");
        li.Operation();
    }
    public Object clone() throws CloneNotSupportedException{
        System.out.println("Clone() is called");
        return super.clone();
    }

    @Override
    void Add(Shade a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void Remove(Shade a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void GetChild(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
