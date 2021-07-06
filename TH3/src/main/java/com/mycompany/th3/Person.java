/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th3;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Person implements Serializable{
    private static final AtomicInteger count = new AtomicInteger(0); 
    private int id;
    private String name;
    private int yearOfBirth;
    private Gender gender;
    
    enum Gender{
        MALE,
        FEMALE
    }

    public Person() {
    }

    public Person(String name, int yearOfBirth, Gender gender) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.compareToIgnoreCase("male") == 0 ){
            this.gender = Gender.MALE;
        }
        if(gender.compareToIgnoreCase("female") == 0){
            this.gender = Gender.FEMALE;
        }
    }

    public String display(){
        return "ID: "+this.id +" ,Name: "+this.name+" ,Gender: "+this.gender+" ,YearOfBirth: "+this.yearOfBirth ;
    }
}
