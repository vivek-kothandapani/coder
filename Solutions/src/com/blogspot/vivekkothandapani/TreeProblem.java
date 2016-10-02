package com.blogspot.vivekkothandapani;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Node{
	public List<Node> nodes;
	public int index;
	public Node parent;
	public Node(int index, Node parent){
		this.index = index;
		this.nodes = new ArrayList<Node>();
		this.parent = parent;
	}
}
class Link{
	public int p;
	public int c;
	Link(int p, int c){
		this.p = p;
		this.c = c;
	}
}
class TestCase{
	public int u;
	public int v;
}

public class TreeProblem {
	
	public static boolean insert(Node root,int index,int parentIndex){
            if(parentIndex == root.index){
            	root.nodes.add(new Node(index,root));
            	return true;
            }
            else {
            	for(Node n:root.nodes){
            		if(insert(n,index,parentIndex)){
            			return true;
            		}
            	}
            }
            return false;
    }
	
	public static Node getNode(Node root,int index){
		    Node cur = null;
            if(index == root.index){
            	cur = root;
            }
            else {
            	for(Node n:root.nodes){
            		Node cur2 = getNode(n,index);
            		if(cur2 != null){
            			cur = cur2;
            			break;
            		}
            	}
            }
            return cur;
    }
	
	public static int scanChilds(Node root, Node excludeChild, Node end,int count){
		 count++;
		 if(root.index == end.index){
			    if(root.parent.index == end.parent.index){
			    	return 0;
			    }else{
			    	return count;
			    }
		    	
		 } else {
		    for(Node n:root.nodes){
		    	if(excludeChild.index != n.index){
			        int curCount = scanChilds(n,n,end,count);
			        if(curCount > 0){
                        return curCount;
                    }
		    	}
		    }
	    }
		return 0;
	}
	
	public static int scanParents(Node parent, Node excludeChild, Node end,int count){
		//count++;
		 if(parent.index == end.index){
		    	return 1;
		 } else {
			    int curCount = scanChilds(parent,excludeChild,end,0);
		        if(curCount > 0){
		        	return count;
		        }
	    }
		return 0;
	}
	
	public static int getDistance(Node startNode, Node endNode){
	    int count = 0;
	    if(startNode.index == endNode.index){
	    	return count;
	    } else {
	    	count = scanChilds(startNode,startNode,endNode,0)-1;
	    	if(count >= 1){
	    		return count;
	    	} else{
	    		Node parent = startNode.parent;
	    		Node child = startNode;
	    		int parentCount = 0;
	    		while(parent != null){
	    			count = scanParents(parent,child,endNode,0);
	    			if(count >= 1){
	    	    		return parentCount + count;
	    	    	}
	    			parentCount++;
	    			parent = parent.parent;
	    		}
	    	}
	    }
        return 0;
}
	
	
	public static int calculate(Node start,Node end){
		int val = 0;
		 if(start!=null){
			    int d = getDistance(start, end);
	            val = val +  d * d;
	            for(Node n:start.nodes){
            		val = val + calculate(n,end);
            	}
	     } 
	    return val;
	}

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();scan.nextLine();
    	
		Node rootNode = new Node(1,null);
		List<Link> links = new ArrayList<Link>();
    	for(int i=2;i<=N;i++){
    		links.add(new Link(scan.nextInt(),i));
    	}
    	boolean isAdded = true;
    	while(!links.isEmpty() && isAdded){
    		int index = 0;
    		 isAdded = false;
	    	for(Link l:links){
	    		if(insert(rootNode,l.c,l.p)){
	    			isAdded = true;
	    			break;
	    		}
	    		index++;
	    	}
	    	if(isAdded){
	    		links.remove(index);
	    	}
    	}
    	
    	int T = scan.nextInt(); scan.nextLine();
    	List<TestCase> tcs = new ArrayList<TestCase>();
    	for(int i=0;i<T;i++){
    		TestCase tc = new TestCase();
    		tc.u = scan.nextInt();
    		tc.v = scan.nextInt();
    		tcs.add(tc);
    	}
    	
    	for(TestCase tc: tcs){
    		System.out.println(calculate(getNode(rootNode,tc.v),getNode(rootNode,tc.u)));
    	}
    	scan.close();
    }
}