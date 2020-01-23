package com.company.Queue;

import java.util.Scanner;

public class Queue {
    int capacity,size,front,rear;
    int arr[];
    Queue(int capacity){
        this.capacity = capacity;
        front = size = 0;
        rear = capacity-1;
        arr = new int[capacity];
    }
    boolean isFull(){
        return this.capacity == this.size;
    }
    boolean isEmpty(){
        return this.size == 0;
    }
    void enqueue(int num){
        if(isFull())
            System.out.println("full");
        else {
            rear = (rear + 1) % capacity;
            arr[rear] = num;
            size++;
        }
    }
    int dequeue(){
        if(isEmpty()) {
            System.out.println("empty");
            return -1;
        }
        else {
            int num = arr[front];
            front = (front + 1) % capacity;
            --size;
            return num;
        }
    }
    void print(){
        if(isEmpty())
            System.out.println("empty");
        else {
            for (int i = front; i <= rear; i = (i + 1) % capacity) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < capacity; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter capacity");
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        Queue queue = new Queue(capacity);
        int t = 1;
        while(t!=0){
            System.out.println("Enter choice 1 to insert 2 to delete 3 to print 0 to exit");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter number");
                    int num = sc.nextInt();
                    queue.enqueue(num);
                    break;

                case 2:
                    System.out.println(queue.dequeue());
                    break;

                case 3:
                    queue.print();
                    break;

                case 0:
                    t =0;
                    break;
            }
        }
    }
}
