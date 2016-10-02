package com.blogspot.vivekkothandapani.hr;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.blogspot.vivekkothandapani.common.Node;


    

public class BinarySearchTreeLevelOrder {
	
	static void levelOrder(Node root){
	    Queue<Node> nodeQueue = new LinkedList();
	    nodeQueue.add(root);

	    while(!nodeQueue.isEmpty()){
	        Node currentNode = nodeQueue.remove();
	        System.out.print(currentNode.data + " ");
	        if (currentNode.left != null){
	            nodeQueue.add(currentNode.left);
	        } 
	        if (currentNode.right != null){
	            nodeQueue.add(currentNode.right);
	        } 
	    }
	}
	
	public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	

}
