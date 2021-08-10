/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author abdal
 */
public class GeneUtilities {
    
    public static int numValidator(Scanner sc, int min, int max){
        int num = 0;
        String strNum;
        boolean notApproved = true;
        do {
              
            strNum = sc.next();
            if (isCharOrFloat(strNum)){
                System.out.println("Choice can not be letters or float, please try again with numbers between " + min + " to " + max);
            } else if (isntInRange(num=Integer.parseInt(strNum), min, max)){
                   System.out.println("Choice must be in the range of " + min + " to " + max + " , please try again");
            } else {
                return num;
            }
                 
        }while(notApproved);
        
        return 0;

    }
    
    public static boolean isCharOrFloat(String strNum){                  
       return !strNum.matches("-?\\d+");
         
    }
    
    public static boolean isntInRange(int num, int min, int max){
       return !(num >=min && num <=max);

    }
}

