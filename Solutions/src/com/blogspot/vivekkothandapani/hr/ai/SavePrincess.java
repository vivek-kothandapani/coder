package com.blogspot.vivekkothandapani.hr.ai;

import java.util.*;
import java.io.*;

public class SavePrincess {
	int M ;
	int N ;
	int maxX ;   	
	int maxY;
	Point dest;
	Point start = new Point(0,0,"START");
	int[][] A;
	
    public int solution( int[][] A ) {
    	int out = 0;
    	this.A = A;
    	 M = this.A.length;
    	 N = this.A[0].length;
    	if(M < 3 && N < 3 || N == 1 || M == 1 ){ 
    		return -1;
    	}
    	
    	 maxX = M -1;    	
    	 maxY = N -1;
    	
    	 dest = new Point(maxX, maxY,"DEST");
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(start);
    	ArrayList<Point> history = findPath(points,points);
    	for(Point point:history){
    		System.out.println(point.direction);
    	}
    	return out;
    }
    
    
    public static void displayPathtoPrincess(int M,String[] grid){
    	SavePrincess savePrincess = new SavePrincess();
    	int[][] A = new int[M][M];
    	for(int i = 0; i < M; i++){
    		char[] 	cs = grid[i].toCharArray();
    		for(int j=0;j< M; j++){
    			if(cs[j] == '-')
    			{
    				A[i][j] = 0;
    			} else if(cs[j] == 'm'){
    				A[i][j] = 1;
    				savePrincess.start = savePrincess.new Point(i,j, "START");
    			}
    			else if(cs[j] == 'p'){
    				A[i][j] = 2;
    				savePrincess.dest = savePrincess.new Point(i,j,"DEST");
    			}
    		}
    	}
 	    savePrincess.solution(A);
    }
    
    public ArrayList<Point> findPath(ArrayList<Point> points, ArrayList<Point> history){
    	if(points != null && points.size() > 0)
    	{       int l = history.size();
    		    for(Point p : points){
    		    	ArrayList<Point> newHistory = new ArrayList<Point>();
    		    	newHistory.addAll(history);
    		    	newHistory.add(p);    		    	
    		    	if(p.equals(dest)){
    		    		 return newHistory;
    		    	}else{
    		    		return findPath(nextMoves(p.x,p.y,newHistory),newHistory);
    		    	}
    		    }
    		    return history;
    	} else {
    		return history;
    	}
    }
    
    public ArrayList<Point> nextMoves(int cX,int cY, ArrayList<Point> history){
    	ArrayList<Point> points = new ArrayList<Point>();
    	
    	if(cX - 1 >= 0 && cY >= 0 && A[cX - 1][ cY ] != 1 ){
    		Point p = new Point(cX-1 ,cY , "UP");
    		if(!history.contains(p)){
    			points.add(p);
    		}
    	}    	
    	if(cX >= 0 && cY + 1 <= maxY && A[cX  ][ cY + 1] != 1){
    		Point p = new Point(cX  , cY + 1, "RIGHT");
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX  >= 0 && cY - 1 >= 0 && A[cX ][ cY - 1] != 1){
    		Point p = new Point(cX - 1, cY - 1, "LEFT");
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	if(cX + 1 <= maxX && cY <= maxY && A[cX + 1 ][cY ] != 1){
    		Point p = new Point(cX + 1 ,cY , "DOWN");
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	return points;
    }
    
    private class Point{
		public int x;
		public int y;
		public String direction;
		
		public Point(int x, int y, String direction){
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private SavePrincess getOuterType() {
			return SavePrincess.this;
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