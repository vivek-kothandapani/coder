package com.blogspot.vivekkothandapani;

public class MissingNumber {
	
	public static void main(String args[]){
		int N = 5;
		int A[] = {1,2,3,4};
		
		int sumOfN = N*(N+1)/2;
		int sumOfA = 0;
		for(int i=0;i<N-1;i++){
			sumOfA = sumOfA + A[i];
		}
		
		System.out.println(sumOfN - sumOfA);
		
	}

}
