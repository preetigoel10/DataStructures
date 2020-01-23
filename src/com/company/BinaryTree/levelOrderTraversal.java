package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
        }
    }
 static void traversal(Node root){
     Queue<Node> q = new LinkedList<>();
     q.add(root);
     while(!q.isEmpty()){
         Node current = q.remove();
         System.out.print(current.data + " ");
         if(current.left != null)
             q.add(current.left);
         if(current.right != null)
             q.add(current.right);
     }
 }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(3);
        traversal(root);
    }
}
