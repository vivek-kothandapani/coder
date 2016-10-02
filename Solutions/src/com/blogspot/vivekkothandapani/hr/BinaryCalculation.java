package com.blogspot.vivekkothandapani.hr;

import java.io.*;
import java.util.*;

public class BinaryCalculation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int out = 0;
        int ones = 0;
        int temp_ones = 0;
        
        while(input > 0){
            int r = input%2;
            input = input/2;
            if(r == 1){
            	temp_ones++;
                if(temp_ones > ones){
                    ones = temp_ones;
                }
            }else{
            	temp_ones = 0;
            }
        }
        
        HashMap<String,ArrayList<String>> m = new HashMap<String,ArrayList<String>>(); 
        ArrayList<String> y = m.get(1);
        
        while(ones > 0){
            ones--;
            out = out + pow(2, ones);
        }
        System.out.println(out);
        
    }
    
    public static int pow(int n, int i){
        if (i > 0){
            return n * pow (n,i-1);
        }else{
            return 1;
        }
    }
}