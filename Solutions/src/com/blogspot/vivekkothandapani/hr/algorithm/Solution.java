package com.blogspot.vivekkothandapani.hr.algorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

/*	
    3
	bac
	bac
	abc
	def
	jdfh
	fds
	
	bacbac
	
	bacbac	
	  babac
	  bbac
	  acbac	
	  cbac	
	bacba
	bacb
	bacac
	bacc
	
	abcdef
	
	
	
	*/
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();scan.nextLine();
    	String s[][] = new String[N][2];
    	
    	for(int i=0;i<N;i++){
    		s[i][0] = scan.nextLine();
    		//System.out.println(isPalindrome(s[i][0]));
    		s[i][1] = scan.nextLine();
    		//System.out.println(isPalindrome(s[i][1]));
    		
    		String output = "";
    		
    		
    	}
    	
    	
    }
    //abc 3, 1
    //abcd 4, 2
    //abcde 5, 2
    
    public static boolean isPalindrome(String s){
    	boolean isPalindrome = false;
    	if(s != null && s.length() > 1){
    		int l = s.length() - 1 ;
    		int hl = s.length()/2;
    		isPalindrome = true;
    		for(int i=0;i<hl;i++){
    			if(!(s.charAt(i) == s.charAt(l-i))){
    				isPalindrome = false;
    			}
    		}
    	}
    	return isPalindrome;
    }
    
    
}