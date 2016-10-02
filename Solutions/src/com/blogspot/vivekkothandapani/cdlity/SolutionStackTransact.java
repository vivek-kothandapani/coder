package com.blogspot.vivekkothandapani.cdlity;

// you can also use imports, for example:
// import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class SolutionStackTransact {
 	
	
	private Stack<Integer> stack ;
	private ArrayList<Stack<Integer>> transactions ;
	private int transactionCount;
	
	
    public SolutionStackTransact() {
    	this.transactionCount = 0;
        this.stack = new Stack<Integer>();
    	this.transactions = new ArrayList<Stack<Integer>>();
    	this.transactions.add(stack);
    }

    public void push(int value) {
    	if(stack != null){
    		this.stack.push(new Integer(value));
    	} else{
    		this.stack = new Stack<Integer>();
    		this.stack.push(new Integer(value));
    	}
    }

    public int top() {
    	if(stack != null && !stack.isEmpty()){
    		return this.stack.peek();
    	}
    	return 0;
    }

    public void pop() {
    	if(stack != null && !stack.isEmpty()){
    		this.stack.pop();
    	}
    }

    public void begin() {
    	this.transactionCount++;
    	Stack<Integer> newStack = (Stack<Integer>)this.stack.clone();
    	this.transactions.add(newStack);
    	this.stack = newStack;
    }

    public boolean rollback() {
    	transactionCount--;
    	boolean rollBack = false;
    	if(transactionCount >= 0){
    		this.stack = this.transactions.get(transactionCount);
    		this.transactions.remove(transactionCount);
    	    rollBack = true;
    	} 
    	return rollBack;
    }

    public boolean commit() {    	
    	boolean commit = false;
    	if(transactionCount > 0){
    		this.stack = this.transactions.get(transactionCount);
    		this.transactions.remove(transactionCount);
    	    commit = true;
    	} 
    	transactionCount--;
    	return commit;
    }
    public static void test() {
        // Define your tests here
        SolutionStackTransact sol = new SolutionStackTransact();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";
    }
};