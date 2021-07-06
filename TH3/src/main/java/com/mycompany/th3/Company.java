/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th3;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Company {
    private String name;
    private Date dateCreate;
    private ArrayList<Employee> employee = new ArrayList<>(10);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Company() {
    }

    public Company(String name, Date dateCreate) {
        this.name = name;
        this.dateCreate = dateCreate;
    }
    
    public void showListEmployees(){
        for(Employee a: employee){
            System.out.println(a.display());
        }
    }
    public boolean info(){
        if(employee.size() == 10) {
            System.out.println("Number of employee in "+this.getName() +" maxed out");
            return true;
        }else{
            return false;
        }
    }
    
    public void addNewEmployee(Employee e){
        employee.add(e);
    }
}
