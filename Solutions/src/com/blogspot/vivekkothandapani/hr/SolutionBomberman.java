package com.blogspot.vivekkothandapani.hr;

import java.io.*;
import java.util.*;

public class SolutionBomberman {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		int N = scan.nextInt();
		scan.nextLine();
		int[][] a = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = scan.nextLine();
			char[] rchar = line.toCharArray();
			for (int j = 0; j < C; j++) {
				if(rchar[j] == '.'){
					a[i][j] = 4;
				}else{
					a[i][j] = 0;
				}
			}
		}
		N = N%100;
		if(N%2 != 0){
		
			ArrayList<String> snapshot = new ArrayList<String>();
			int loopCount = 0;
			int repeatStart = 0;
			String resultString = "";
			boolean repeatFound = false;
			boolean setBomb = false;
			while (loopCount < N) {
				String snapTemp = "";
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (a[i][j] == 4 && setBomb) {
							a[i][j] = 0;
						} else if (a[i][j] == 0) {
							a[i][j] = 1;
						} else if (a[i][j] == 1) {
							a[i][j] = 2;
						} else if (a[i][j] == 2 && !setBomb ) {
							a[i][j] = 4;
							if (j - 1 >= 0 && a[i][j - 1] != 2) {
								a[i][j - 1] = 4;
							}
							if (j + 1 <= C - 1 && a[i][j + 1] != 2) {
								a[i][j + 1] = 4;
							}
	
							if (i - 1 >= 0 && a[i - 1][j] != 2) {
								a[i - 1][j] = 4;
							}
							if (i + 1 <= R - 1 && a[i + 1][j] != 2) {
								a[i + 1][j] = 4;
							}
						}
						if(N > 200) {snapTemp = snapTemp + Integer.toString(a[i][j]);}
						
					}
				}
				//System.out.println(snapTemp);
			   if(N > 200){
				repeatStart = 0;
				for(String s: snapshot){
					System.out.println(s);
					if(s != null && s.equals(snapTemp)){
 						repeatFound = true;
						int bs = N - repeatStart;
						int r = bs%(loopCount - repeatStart + 1);
						int index = repeatStart + r + 1 ;
						if(index== snapshot.size()){ index = repeatStart;}
						resultString = snapshot.get(index);
						//System.out.println("resultString : " + resultString);
						//System.out.println("repeatStart + r + 2 : " + repeatStart + r + 2);
						break;
					}
					repeatStart++;
				}
			   }
				
				if(repeatFound && N > 200){break;};
				if(N > 200) {snapshot.add(snapTemp);};
				
				if (!setBomb) {
					setBomb = true;
				} else {
					setBomb = false;
				}
				loopCount++;
			}
			
		    if(repeatFound && N > 200){
		    	char[] c = resultString.toCharArray();
		    	int m = 0;
		    	for (int i = 0; i < R; i++) {
			    	for (int j = 0; j < C; j++) {
						a[i][j] = Integer.parseInt(Character.toString(c[m]));
						m++;
					}
		    	}
		    }   
		    
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (a[i][j] != 4 || N%2 == 0) {
					System.out.print('O');
				} else {
					System.out.print('.');
				}

			}
			System.out.println();
		}
	}
}