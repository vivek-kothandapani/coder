package com.blogspot.vivekkothandapani.cdlity;

import java.util.ArrayList;

class Solution {
	int M ;
	int N ;
	int maxX ;   	
	int maxY;
	Point dest;
	Point start = new Point(0,0);
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
    	
    	 dest = new Point(maxX, maxY);
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(start);
    	out = findPath(points,points);
    	return out;
    }
    
    public int findPath(ArrayList<Point> points, ArrayList<Point> history){
    	if(points != null && points.size() > 0)
    	{       int l = history.size();
    		    for(Point p : points){
    		    	ArrayList<Point> newHistory = new ArrayList<Point>();
    		    	newHistory.addAll(history);
    		    	newHistory.add(p);    		    	
    		    	if(p.equals(dest)){
    		    		 l = newHistory.size();
    		    		 break;
    		    	}
    		    }
    		    for(Point p : points){
    		    	ArrayList<Point> newHistory = new ArrayList<Point>();
    		    	newHistory.addAll(history);
    		    	newHistory.add(p);    		    	
    		    	ArrayList<Point> newPoints = nextMoves(p.x, p.y,history);
    		    	int cl = findPath(newPoints,newHistory);
    		    	if(cl!= -1 && cl > l){
    		    		
    		    		l = cl; 
    		    	}
    		    }
    		    return l;
    	} else {
    		return history.size();
    	}
    }
    
    public ArrayList<Point> nextMoves(int cX,int cY, ArrayList<Point> history){
    	ArrayList<Point> points = new ArrayList<Point>();
    	
    	if(cX - 2 >= 0 && cY - 1 >= 0 && A[cX - 2][ cY - 1] != 1 ){
    		Point p = new Point(cX-2 ,cY-1 );
    		if(!history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX - 2 >= 0 && cY + 1 <= maxY && A[cX - 2 ][ cY + 1] != 1){
    		Point p = new Point(cX - 2 , cY + 1);
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX - 1 >= 0 && cY - 2 >= 0 && A[cX - 1][ cY - 2] != 1){
    		Point p = new Point(cX - 1, cY - 2);
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX - 1 >= 0 && cY + 2 <= maxY && A[cX - 1][cY + 2] != 1){
    		Point p = new Point(cX - 1,cY + 2 );
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX + 1 <= maxX && cY - 2 >= 0 && A[cX + 1 ][ cY - 2] != 1){
    		Point p = new Point(cX + 1 , cY - 2 );
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX + 1 <= maxX && cY + 2 <= maxY && A[cX + 1 ][cY + 2] != 1){
    		Point p = new Point(cX + 1 ,cY + 2 );
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX + 2 <= maxX && cY - 1 >= 0 && A[cX + 2][cY - 1] != 1){
    		Point p = new Point(cX + 2, cY - 1);
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	if(cX + 2 <= maxX && cY + 1 <= maxY && A[cX + 2 ][ cY + 1] != 1){
    		Point p = new Point(cX + 2 , cY + 1);
    		if(!points.contains(p) && !history.contains(p)){
    			points.add(p);
    		}
    	}
    	
    	
    	return points;
    }
    
    private class Point{
		public int x;
		public int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
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
		private Solution getOuterType() {
			return Solution.this;
		}
		
	}
    
    public static void main(String args[]){
    	Solution s = new Solution();
    	int[][] A = {{0,0,0},{0,0,1},{1,0,0},{0,0,0}};
    	System.out.println(s.solution(A));
    }
}