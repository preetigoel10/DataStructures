package com.company.Queue;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int size = 0;
    void push(int x){
        size++;
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> q = q2;
        q2 = q1;
        q1 = q;
    }
int pop(){
        --size;
        if(!q1.isEmpty()){
            return q1.remove();
        }
        return -1;
}
int top(){
        if(!q1.isEmpty()){
            return q1.peek();
        }
        return -1;
}
int size(){
        return size;
}

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(2);
        System.out.println(stackUsingQueue.size()); 
        stackUsingQueue.push(5);
        System.out.println(stackUsingQueue.size()); 
        stackUsingQueue.push(6);
        System.out.println(stackUsingQueue.size());
        stackUsingQueue.pop();
        System.out.println(stackUsingQueue.size());
        stackUsingQueue.push(9);
        System.out.println(stackUsingQueue.size()); 
        stackUsingQueue.push(3);
        System.out.println(stackUsingQueue.size()); 
        stackUsingQueue.push(1);
        System.out.println(stackUsingQueue.size());
        stackUsingQueue.pop();
        stackUsingQueue.pop();
        System.out.println(stackUsingQueue.size());
        
    }
}
