package com.company.Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class queueUsingArray {
    int front,rear,size,capacity;
    int arr[];
    queueUsingArray(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        arr = new int[capacity];
    }
    boolean isFull(){
        return (size == capacity);
    }
    boolean isEmpty() {
        return size==0;
    }
    void enqueue(int n) {
        if (isFull())
            return;
        rear = (rear + 1)%capacity;
        arr[rear] = n;
        size++;
    }
    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int temp = arr[front];
        front = (front+1)%capacity;
        size = size-1;
        return temp;
    }
    int front() {
        if(isEmpty())
            return -1;
        return arr[front];
    }
    int rear() {
        if(isEmpty())
            return -1;
        return arr[rear];
    }

    @Override
    public String toString() {
        return "queueUsingArray{" +
                "front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                ", capacity=" + capacity +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        queueUsingArray queueUsingArray = new queueUsingArray(5);
        System.out.println(queueUsingArray.size+" "+queueUsingArray.front()+" "+queueUsingArray.rear());
        queueUsingArray.enqueue(1);
        queueUsingArray.enqueue(2);
        queueUsingArray.enqueue(3);
        queueUsingArray.enqueue(4);
        queueUsingArray.enqueue(5);
        System.out.println(queueUsingArray);
        System.out.println(queueUsingArray.dequeue());
        Queue<Integer> q = new LinkedList<>();
        q.add(12);
        queueUsingArray.enqueue(5);
        System.out.println(queueUsingArray);
    }
}
