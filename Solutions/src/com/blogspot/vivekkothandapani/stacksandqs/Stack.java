package com.blogspot.vivekkothandapani.stacksandqs;

import com.blogspot.vivekkothandapani.common.Node;



public class Stack {
	Node top;
	
	void push(int item)
	{
		Node t = new Node(item);
		t.next = top;
		top = t;
		
	}
	
	Object pop(){
		if(top != null)
		{
			int item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	
	void printAll()
	{
		Node n = top;
		while(n!=null){ System.out.println(n.data); n = n.next;};
	}
}
