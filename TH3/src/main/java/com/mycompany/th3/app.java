/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th3;

import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class app {
    public static Employee createE(){
        Employee temp = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID Employee: ");temp.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Name: ");temp.setName(sc.nextLine());
        System.out.println("Year Of Birth: ");temp.setYearOfBirth(Integer.parseInt(sc.nextLine()));
        System.out.println("Gender: ");temp.setGender(sc.nextLine());
        System.out.println("Join Date: ");
        String date_temp = sc.nextLine();
        String[] date_convert = date_temp.split("/");
        Date date = new Date(Integer.parseInt(date_convert[2]),Integer.parseInt(date_convert[1]) ,Integer.parseInt(date_convert[0]));
        temp.setDateJoin(date);
        System.out.println("Position: ");temp.setPosition(sc.nextLine());
        System.out.println("Salary Level: ");temp.setSalaryLevel(Double.parseDouble(sc.nextLine()));
        System.out.println("Salary Basic: ");temp.setSalaryBasic(Double.parseDouble(sc.nextLine()));
        return temp;
    }
    
    public static void menu(){
        System.out.println("\n\n1. Add new Employee");
        System.out.println("2. Is Company maxed number of Employees ?");
        System.out.println("3. Show all Employee");
        System.out.println("0. Exit");
        System.out.println("Enter:");
    }
    public static void switch_num(int num, Company com){
        switch(num){
            case 1->{
                Employee temp = createE();
                if(!com.info()) com.addNewEmployee(temp);
            }
            case 2->{
                System.out.println(com.info());
            }
            case 3->{
                com.showListEmployees();
            }
        }
    }
    public static void main(String[] args) {
        Company test = new Company();
        Scanner sc = new Scanner(System.in);
        System.out.println("Company Name: ");test.setName(sc.nextLine());
        System.out.println("Create Date: ");
        String date_temp = sc.nextLine();
        String[] date_convert = date_temp.split("/");
        Date date = new Date(Integer.parseInt(date_convert[2]),Integer.parseInt(date_convert[1]) ,Integer.parseInt(date_convert[0]));
        test.setDateCreate(date);
        int num_pick = 0 ;
        do{
            menu();
            num_pick = Integer.parseInt(sc.nextLine());
            switch_num(num_pick, test);
        }while(num_pick != 0 || test.info());
        test.showListEmployees();
    }
}
