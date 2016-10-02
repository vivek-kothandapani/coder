package com.blogspot.vivekkothandapani.hr;

import java.io.*;
import java.util.*;

public class SolutionMatrixRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        int R = scan.nextInt(); scan.nextLine();
        int tCount = M < N ? M/2:N/2;
       // int t[][] = new int[tCount][];
        int a[][] = new int[M][N];
        
        for(int i = 0; i < M ; i++ ){
            String[] s = scan.nextLine().split(" ");
            for(int j = 0; j < N ; j++){
                a[i][j] = Integer.parseInt(s[j]);
            }
            //scan.nextLine();
        }
        
        
        
        for(int i=0; i < tCount; i++){
            
            int mStart = i;
            int nStart = i;
            
            int mEnd = M -i;
            int nEnd = N -i;
            int index = 0;
            int flatArraySize = (mEnd - mStart)* 2 + (nEnd - nStart - 2) * 2 ;
            
            int t[] = new int[flatArraySize];
            for(int k=nStart; k < nEnd; k++){
                t[index] = a[mStart][k];
                index++;
            }
            for(int k=mStart+1; k < mEnd; k++){
                t[index] = a[k][nEnd-1];
                index++;
            }
            for(int k= nEnd-2; k >= nStart; k--){
                t[index] = a[mEnd-1][k];
                index++;
            }
            for(int k= mEnd-2; k >= mStart +1; k--){
                t[index] = a[k][nStart];
                index++;
            }
            
            int actR = R%flatArraySize;
            
            int rotated[] = new int[flatArraySize];
            System.arraycopy(t, actR, rotated, 0, flatArraySize-actR);
            System.arraycopy(t, 0, rotated,flatArraySize-actR , actR);
            
            index = 0;
            for(int k=nStart; k < nEnd; k++){
                a[mStart][k] = rotated[index];
                index++;
            }
            for(int k=mStart+1; k < mEnd; k++){
                a[k][nEnd-1] = rotated[index] ;
                index++;
            }
            for(int k= nEnd-2; k >= nStart; k--){
                a[mEnd-1][k] = rotated[index];
                index++;
            }
            for(int k= mEnd-2; k >= mStart +1; k--){
                a[k][nStart] = rotated[index];
                index++;
            }
            
//            for(int x=0; x < flatArraySize; x++){
//             
//                 System.out.print(t[x]);
//            
//         }
            //System.out.println();
            
        }
        
        for(int i = 0; i < M ; i++ ){
            //String[] s = scan.nextLine().split(" ");
            for(int j = 0; j < N ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println( );
        }
         
    }
}