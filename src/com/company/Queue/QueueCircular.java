package com.company.Queue;

public class QueueCircular {
    static class Node{
        int data;
        Node next;
    }
    Node front,rear;
    void enqueue(int num){
        Node newNode = new Node();
        newNode.data = num;
        if(rear == null){
            front = rear =newNode;
            rear.next = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }
    int dequeue(){
        if(front == null){
            System.out.println("Empty");
            return -1;
        }
        int value;
        if(front == rear){
             value = front.data;
            front = rear = null;
        }
        else {
             value = front.data;
            front = front.next;
            rear.next = front;
        }
        return value;
    }
    void print(){
        if(front!= null) {
            Node temp = front;
            while (temp.next != front) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    public static void main(String[] args) {
        QueueCircular queueCircular = new QueueCircular();
        queueCircular.enqueue(3);
        queueCircular.print();
        queueCircular.enqueue(5);
        queueCircular.print();
        queueCircular.enqueue(9);
        queueCircular.print();
        queueCircular.enqueue(7);
        queueCircular.print();
        queueCircular.dequeue();
        queueCircular.print();
    }
}
