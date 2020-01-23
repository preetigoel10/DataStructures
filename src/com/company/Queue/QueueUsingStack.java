package com.company.Queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int size;
    void add(int x){
        size++;
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }
    int remove(){
        size--;
        return s1.pop();
    }

}
