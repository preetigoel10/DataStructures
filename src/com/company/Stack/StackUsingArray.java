package com.company.Stack;

public class StackUsingArray {
    int top;
    int arr[];
    int capacity;
    int size;
    StackUsingArray(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
    }
    void push(int x){
        if(top>=capacity-1) {
            System.out.println("overflow");
            return;
        }
        arr[++top] = x;
        System.out.println("pushed" + arr[top]);
        size++;
    }
    int pop(){
        if(top<0){
            System.out.println("Underflow");
            return -1;
        }
        --size;
        return arr[top--];

    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray(6);
        stackUsingArray.pop();
        stackUsingArray.push(2);
        System.out.println(stackUsingArray.size);
        stackUsingArray.push(5);
        stackUsingArray.push(6);
        stackUsingArray.push(8);
        stackUsingArray.push(3);
        stackUsingArray.push(3);
        stackUsingArray.push(9);
        stackUsingArray.push(4);
        System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());
        System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());    System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());    System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());    System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());    System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());    System.out.println(stackUsingArray.top);
        System.out.println("pop"+ stackUsingArray.pop());

    }
}
