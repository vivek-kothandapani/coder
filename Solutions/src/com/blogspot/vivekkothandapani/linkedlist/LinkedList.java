package com.blogspot.vivekkothandapani.linkedlist;

import com.blogspot.vivekkothandapani.common.Node;


public class LinkedList {

	 public Node head = null;
	 void appendToTail(int d){
			Node end = new Node(d);
			Node n = this.head;
			if(n == null){ this.head = end;return;};
			while(n.next != null){n = n.next;};	
			n.next = end;
	    }
	    
	    void printAll()
	    {
	    	Node n = this.head;
	    	do{ System.out.println(n.data); n = n.next;} while(n != null);
	    }
	    
	    Node deleteNode(int d)
	    {
	    	Node n = this.head;
	    	if(head.data == d) {
	    		return head.next;
	    	}
	    	while(n.next != null)
	    	{
	    		if(n.next.data == d)
	    		{
	    			n.next = n.next.next;
	    			break;
	    		}
	    		n = n.next;
	    	}
	        return head;
	    }
} 