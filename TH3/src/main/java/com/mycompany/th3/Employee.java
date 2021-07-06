/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th3;

import java.util.Date;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Employee extends Person{
    private int id;
    private Date dateJoin;
    private String position;
    private Double salaryLevel;
    private Double salaryBasic;

    public Employee() {
    }

    public Employee(int id, Date dateJoin, String position, Double salaryLevel, Double salaryBasic, String name, int yearOfBirth, Gender gender) {
        super(name, yearOfBirth, gender);
        this.id = id;
        this.dateJoin = dateJoin;
        this.position = position;
        this.salaryLevel = salaryLevel;
        this.salaryBasic = salaryBasic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Date dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(Double salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public Double getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(Double salaryBasic) {
        this.salaryBasic = salaryBasic;
    }
    
    public Double getIncome(){
        return (this.getSalaryLevel() * this.getSalaryBasic());
    }

    @Override
    public String display() {
        return super.display() + " ,EmID: "+this.getId() + " ,DateJoin: "+ this.getDateJoin()+" ,Position: "+this.getPosition() +" ,Income: "+this.getIncome() +"\n";
    }
    
    
    
}
