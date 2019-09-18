package com.company;

import java.util.Scanner;

public class DoublyLL {
    Node head;
    Node tail;
    int size = 0;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    void insertAtBeginning(int d) {
        Node n = new Node(d);
        n.prev = null;
        n.next = head;
        if (head == null) {
            head =n;
            tail = n;
        } else {
            head.prev = n;
            head = n;
        }
        size++;
    }

    void insertAtEnd(int d) {
        Node n = new Node(d);

        if (head == null) {
            head = tail= n;
            head.prev = null;
            tail.next= null;
        } else {
//            tail = head;
//            while (tail.next != null) {
//                tail = tail.next;
//            }
            tail.next = n;
            n.prev = tail;
            tail = n;
            tail.next = null;
        }
        size++;
    }

    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List empty");
        } else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List empty");
        } else {
//            tail = head;
//            while (tail.next != null) {
//                tail = tail.next;
//            }
            tail = tail.prev;
            tail.next=null;
        }
        size--;
    }

    void print() {
    if(head == null)
        System.out.println("List empty");
    else{
        Node t =head;
        while(t!=tail.next){
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println("\nSize: "+size);
    }
    }

    public static void main(String[] args) {
        DoublyLL m = new DoublyLL();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\nPress 1 to insert at beginning\nPress 2 to insert at end\nPress 3 to delete at beginning\nPress 4 to delete at end\nPress 5 to view the list");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter data");
                    int d = sc.nextInt();
                    m.insertAtBeginning(d);
                    break;
                case 2:
                    System.out.println("enter data");
                    int da = sc.nextInt();
                    m.insertAtEnd(da);
                    break;
                case 3:
                    m.deleteAtBeginning();
                    break;
                case 4:
                    m.deleteAtEnd();
                    break;
                case 5:
                    m.print();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid input");

            }
        }
    }
}
