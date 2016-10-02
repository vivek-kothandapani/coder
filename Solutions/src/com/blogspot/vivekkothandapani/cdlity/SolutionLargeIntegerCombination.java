package com.blogspot.vivekkothandapani.cdlity;

import java.util.Arrays;

class SolutionLargeIntegerCombination {
    public static int solution(int N) {
        // write your code in Java SE 8
        int ret = 0;
        String sa = Integer.toString(N);
        int l = sa.length();
        char ca[] = sa.toCharArray();
        Arrays.sort(ca); 
        String outStr = "";
        for(int i=l-1; i >= 0 ; i--){
        	outStr = outStr + ca[i];
        }
        return Integer.parseInt(outStr);
    }
    
    public static void main(String arg[]){
    	System.out.println(solution(515));
    }
    
    
    
}