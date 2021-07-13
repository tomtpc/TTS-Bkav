/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th1_3;

import java.io.Serializable;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class DataBase implements Serializable{
    String user_name;
    String pass;

    public DataBase() {
    }

    public DataBase(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "DataBase{" + "user_name=" + user_name + ", pass=" + pass + '}';
    }
    
}
