package com.company.Stack;

public class StackUsingLL {
    static class Node{
        int data;
        Node next;
    }
    Node root;
    boolean empty(){
        if(root == null)
            return true;
        else
            return false;
    }
    void push(int x){
        Node newNode = new Node();
        newNode.data = x;
        if(root == null) {
            root = newNode;
            return;
        }
        Node temp = root;
        root = newNode;
        newNode.next = temp;
    }
    int pop(){
        if(root == null)
            return -1;
        int x = root.data;
        root = root.next;
        return x;
    }
    int peek(){
        if(root == null)
            return -1;
        return root.data;
    }
}
