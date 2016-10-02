package com.blogspot.vivekkothandapani;

public class XORMissingNumber {
	public static void main(String args[]){
		int N = 5;
		int A[] = {1,2,3,5};
		int missingNumber = 0;
		for(int i=1;i<=N;i++){
			missingNumber = missingNumber^i;
		}
		for(int i=0;i<N-1;i++){
			missingNumber = missingNumber^A[i];
		}
		System.out.println(missingNumber);
	}
}
