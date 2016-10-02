package com.blogspot.vivekkothandapani.stacksandqs;

public class TestClass {
	public static void main(String args[])
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		q.printAll();
		
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		
		s.printAll();
	}
}
