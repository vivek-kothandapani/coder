package com.blogspot.vivekkothandapani.citi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatingFirstChar {

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		
		//"abaccbdc"
		// " b ccbdce"
		// "   cc dc"
		// "      d "
		
		char c[] = in.toCharArray();
		
		// N * N = n^2
		
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		
		//System.so	
		for(int i=0; i < in.length() ; i++){
			for(int j=i+1; j < in.length(); j++){
				if(in.charAt(i) == in.charAt(j)){
					in = in.replace(in.charAt(i), ' ');
				}
			}
			//in = in.trim();
		}
		in = in.trim();
		System.out.println(in.charAt(0));
		
	}
	
}
