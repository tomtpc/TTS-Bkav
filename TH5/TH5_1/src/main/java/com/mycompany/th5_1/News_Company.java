/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th5_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class News_Company {
    private String Com_name;

    public String getCom_name() {
        return Com_name;
    }

    public void setCom_name(String Com_name) {
        this.Com_name = Com_name;
    }

    public News_Company() {
    }
    
    ArrayList<Employee> em_list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void add_em(){
        Employee temp = new Employee();
        System.out.println("Name: "); temp.setName(sc.nextLine());
        System.out.println("Faculty: (1. Staff / 2.Journalist)"); temp.setFaculty(Integer.parseInt(sc.nextLine()));
        System.out.println("Position: "); temp.setPosition(sc.nextLine());
        System.out.println("Post(s): "); temp.setNumber_post(Integer.parseInt(sc.nextLine()));
        em_list.add(temp);
    }
    
    public void move_em(){
        String name;
        System.out.println("Input employee to find: "); name = sc.nextLine();
        int flag_find = 0;
        for(Employee e: em_list){
            if(e.getName().equalsIgnoreCase(name)){
                flag_find = 1;
                System.out.println("Moving employee to the other faculty...");
                if(e.getFaculty().equals(Employee.Fac.Staff.toString()))
                    e.setFaculty(2);
                else{
                    e.setFaculty(1);
                }
            }
        }
        if(flag_find == 0){
            System.out.println("No employee name: "+name +"\nRe-try...");
            move_em();
        }
    }
    
    public void fire_em(){
        String name;
        System.out.println("Input employee to find: "); name = sc.nextLine();
        int flag_find = 0;
        Employee temp = new Employee();
        for(Employee e: em_list){
            if(e.getName().equalsIgnoreCase(name)){
                flag_find = 1;
                System.out.println("Firing employee name: "+name);
                temp = e;
            }
        }
        if(flag_find == 0 ){
            System.out.println("No employee name: "+name+"\n Re-try...");
            fire_em();
        }else{
            if(em_list.indexOf(name) == (-1)){
                int index = em_list.indexOf(temp);
                em_list.remove(index);
                System.out.println("Fired");
            }
        }
    }
    
    public void display(){
        System.out.println("Show all employee(s) of" +this.Com_name+" in each faculty:");
        String str_staff = "", str_journalist ="";
        for(Employee e: em_list){
            if(e.getFaculty().equals(Employee.Fac.Staff.toString())) str_staff += e.display()+"\n";
            if(e.getFaculty().equals(Employee.Fac.Journalist.toString())) str_journalist += e.display()+"\n";
        }
        System.out.println("Staff(s): \n"+str_staff);
        System.out.println("Jounalist(s): \n"+str_journalist);
    }
    
    
    
}
