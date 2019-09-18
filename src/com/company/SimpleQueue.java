package com.company;

import java.util.Scanner;

public class SimpleQueue {
    int front = -1,rear = -1;
    int MAX = -1;
    int arr[];
    int size =0;
    SimpleQueue(int n)
    {
         arr = new int[n];
        MAX = n;
    }
    void insert(int d)
    {
        if(front == 0 && rear == MAX-1)
        {
            System.out.println("Overflow");
        }
        else if(front==-1)
        {
            ++front;
            arr[++rear] = d;
            ++size;
        }
        else{
            arr[++rear] = d;
            ++size;
        }
    }
    void delete()
    {
        if(front<0){
            System.out.println("Underflow");
        }
        else{
            ++front;
            size--;
        }
    }
    void print(){
        if(front<0)
        {
            System.out.println("List empty");
        }
        else {
            int f = front, r = rear;
            while (f <= r) {
                System.out.print(arr[f] + " ");
                f++;
            }
            System.out.println("\n" + size);
        }
    }

    public static void main(String[] args) {
        SimpleQueue q = new SimpleQueue(5);
        boolean flag = true;
        while(flag)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Press 1 to insert\nPress 2 to delete\nPress 3 to print the queue");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter element to insert");
                    int num = sc.nextInt();
                    q.insert(num);
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.print();
                    break;
                default:
                    flag= false;
            }
        }
    }

}
