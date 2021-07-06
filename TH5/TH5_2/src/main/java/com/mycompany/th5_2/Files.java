/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.th5_2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author TomTPC < vanthanh7452 at Gmail.com >
 */
public class Files {
    static Scanner sc = new Scanner(System.in);
    public void go_through_all(final File openPath){
        if(openPath.isDirectory()){
            System.out.println(openPath.getAbsolutePath());
            
            final File[] child = openPath.listFiles();
            if(child == null) return;
            for(final File f: child){
                go_through_all(f);
            }
        }else{
            System.out.println(openPath.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println("Input path: "); String path = sc.nextLine();
        File openPath = new File(path);
        Files myFiles = new Files();
        int num = 0;
        do {    
            System.out.println("\n\n");
            myFiles.go_through_all(openPath);
            System.out.println("\n1.Open file");
            System.out.println("0.Exit");
            System.out.println("Enter:");
            num = Integer.parseInt(sc.nextLine());
            if(num == 1){
                    System.out.println("File path: ");
                    String path_file = sc.nextLine();
                    File file = new File(path);
                    Runtime.getRuntime().exec("notepad "+file.getAbsolutePath());
                    if(file.exists()) Desktop.getDesktop().open(file);
                    else System.out.println("File path doesn't exist.");
            }
        } while(num != 0);
    }

}
