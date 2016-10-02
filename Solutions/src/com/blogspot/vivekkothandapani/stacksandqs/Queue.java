package com.blogspot.vivekkothandapani.stacksandqs;

import com.blogspot.vivekkothandapani.common.Node;


public class Queue {
	
	Node first, last;
    public void enqueue(int d){
    	if(first == null){
    		first = new Node(d);
    	} else if (last == null) {
    		last = new Node(d);
    		first.next = last;
    	} else {
    		last.next = new Node(d);
    		last = last.next;
    	}
    }
    
    public Object dequeue(int d)
    {
    	if(first != null ) {
    		int t = first.data;
    		first = first.next;
    		return t;
    	}
    	return null;
    }
    
    void printAll()
    {
    	Node n = first;
    	while(n != null){
    		System.out.println(n.data);
    		n = n.next;
    	}
    }
}
