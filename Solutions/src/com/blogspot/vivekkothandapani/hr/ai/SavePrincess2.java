package com.blogspot.vivekkothandapani.hr.ai;

import java.util.*;
import java.io.*;

public class SavePrincess2 {
    
    public static void displayPathtoPrincess(int M,String[] grid){
    	//int[][] A = new int[M][M];
    	int rStart = 0;
    	int cStart = 0;
    	int rDest = 0;
    	int cDest = 0;
    	
    	for(int i = 0; i < M; i++){
    		char[] 	cs = grid[i].toCharArray();
    		for(int j=0;j< M; j++){
    			//if(cs[j] == '-')
    			//{
    				//A[i][j] = 0;
    			//} else 
    			if(cs[j] == 'm'){
    				//A[i][j] = 1;
    				rStart = i;
    				cStart = j;
    			}
    			else if(cs[j] == 'p'){
    				//A[i][j] = 2;
    				rDest = i;
    				cDest = j;
    			}
    		}
    	}
    	if(rStart - rDest >= 0 ){
    		for(int i=0;i<rStart-rDest;i++){
    			 System.out.println("UP");
    		}
    	} else {
    		for(int i=0;i<rDest-rStart;i++){
    			 System.out.println("DOWN");
    		}
    	}
    	if(cStart - cDest >= 0 ){
    		for(int i=0;i<cStart-cDest;i++){
    			 System.out.println("LEFT");
    		}
    	} else {
    		for(int i=0;i<cDest-cStart;i++){
    			 System.out.println("RIGHT");
    		}
    	}
    
    	
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }
        displayPathtoPrincess(m,grid);
    }
}