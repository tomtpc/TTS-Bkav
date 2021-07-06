/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th5_1;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Employee {
    private String name, position, Faculty;
    private int number_post;

    public Employee() {
    }
    enum Fac{
        Staff,
        Journalist
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(int num) {
        if(num == 1 ) this.Faculty = Fac.Staff.toString();
        if(num == 2 ) this.Faculty = Fac.Journalist.toString();
        
    }

    public int getNumber_post() {
        return number_post;
    }

    public void setNumber_post(int number_post) {
        this.number_post = number_post;
    }

    public String display(){
        return "{Name:  "+this.name+"/ Faculty: "+this.getFaculty()+"/ Position: "+this.getPosition()+"/ Post(s): "+this.getNumber_post()+"}";
    }
    
}
