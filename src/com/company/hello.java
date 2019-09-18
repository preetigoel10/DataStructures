package com.company;


import java.util.Scanner;

public class hello {
    Node head;
    int size=0;
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void insertAtBeg(int d){
        if(head == null)
        {
            Node n = new Node(d);
            head = n;
        }
        else{
            Node n = new Node(d);
            n.next = head;
            head = n;
        }
        size++;
    }
    public void insertAtEnd(int d){
        if(head == null)
        {
            Node n = new Node(d);
            head = n;
        }
        else{
            Node n = new Node(d);
          Node h = head;
          while(h.next!=null)
          {
              h = h.next;
          }
          h.next = n;

        }
        size++;
    }
    public void deleteAtBeg(){
        if(head == null)
        {
            System.out.println("List is empty");
        }
        else{
          head = head.next;
        }
        size--;
    }
    public void deleteAtEnd(){
        if(head == null)
        {
            System.out.println("List is empty");
        }
        else if(size == 1){
            head = null;
        }
       else{
            Node h = head;
            while(h.next.next!=null)
            {
                h = h.next;
            }
            h.next = null;

        }
        size--;
    }
    public void print()
    {
        if(head == null)
        {
            System.out.println("List is empty");
        }
        Node h = head;
        while(h!=null)
        {
            System.out.print(h.data+" ");
            h = h.next;
        }
        System.out.println("\n"+size);
    }
    public void insertAtPt(int pos,int d)
    {
       if(pos>size)
       {
           System.out.println("Invalid");
       }
       else if(pos ==1)
       {
           insertAtBeg(d);
       }
       else if(pos==size+1)
       {
           insertAtEnd(d);
       }
       else {
          Node n = new Node(d);
          Node h = head;
          for(int i=1;i<pos-1;i++)
          {
           h = h.next;
          }
          n.next = h.next;
          h.next = n;
          size++;
       }
    }
    public void deleteAtPt(int pos)
    {
            if (pos > size || pos < 1) {
                System.out.println("Invalid");
            } else if (pos == 1) {
                deleteAtBeg();
            } else if (pos == size) {
                deleteAtEnd();
            }
            else if (head == null)
            {
                System.out.println("List is empty");
            }
            else {
                Node h = head;
                for (int i = 1; i < pos - 1; i++) {
                    h = h.next;
                }
                h.next = h.next.next;
                size--;
            }

    }
    Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    Node mergeSort(Node h)
    {
        // Base case : if head is null 
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list 
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        // set the next of middle Node to null 
        middle.next = null;

        // Apply mergeSort on left list 
        Node left = mergeSort(h);

        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list 
//    public static Node getMiddle(Node head)
//    {
//        if (head == null)
//            return head;
//
//        Node slow = head, fast = head;
//
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//    public Node sortedmerge(Node a,Node b)
//    {
//        if(a==null)
//            return b;
//        if(b == null)
//            return a;
//        Node result = null;
//        if(a.data <= b.data)
//        {
//            result = a;
//            result.next = sortedmerge(a.next,b);
//        }
//        else{
//            result = b;
//            result.next = sortedmerge(a,b.next);
//        }
//        return result;
//    }
//   public Node mergesort(Node h)
//    {
//       if(h== null || h.next == null)
//       {
//           return h;
//       }
//       Node middle = getMiddle(h);
//       Node middle_next = middle.next;
//       middle.next = null;
//       Node left = mergesort(h);
//       Node right = mergesort(middle_next);
//       Node sorted_list = sortedmerge(left,right);
//       return sorted_list;
//    }
    public Node getMiddle(Node h)
    {
        if(h==null )
        {
            return h;
        }
        Node slow =h,fast = h;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
  void reverseR(Node curr,Node prev)
  {
      if(curr == null){
          return;
      }
       if(curr.next == null)
       {
           head = curr;
           curr.next = prev;
           return;
       }
       Node next = curr.next;
       curr.next = prev;
       reverseR(next,curr);
  }
  Node reverseI()
  {
      Node curr = null, prev = null;
      while (head!=null)
      {
          prev = head.next;
          head.next = curr;
          curr = head;
          head = prev;

      }
      return curr;
  }
  void reverse(){
        Node curr = head,prev = null;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    void removeDuplicatesU(){
    Node pt1 = head, pt2 = null;
    while(pt1!=null && pt1.next!=null )
    {
        pt2 = pt1;
        while(pt2.next!=null){
            if(pt1.data == pt2.next.data){
                pt2.next = pt2.next.next;
            }
            else{
                pt2 = pt2.next;
            }
        }
        pt1 = pt1.next;
    }
    }
    void removeDuplicatesS(){
        Node pt1 = head;
        while (pt1!=null && pt1.next!= null)
        {
            if(pt1.data== pt1.next.data)
            {
                pt1.next = pt1.next.next;
            }
            else{
                pt1 = pt1.next;
            }
        }
    }
    public static void main(String[] args) {
        hello m = new hello();
        Scanner sc = new Scanner(System.in);
        boolean flag =true;
        while(flag) {
            System.out.println("Press 1 to insert at beginning\nPress 2 to insert at end\nPress 3 to delete at beginning\nPress 4 to delete at end\nPress 5 to view the list" +
                    "\nPress 6 to Insert At position \nPress 7 to Delete at position \nPress 8 to Sort \nPress 9 to Reverse \nPress 10 to Remove Duplicates \nPress 11 to Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter data");
                    int d = sc.nextInt();
                    m.insertAtBeg(d);
                    break;
                case 2:
                    System.out.println("enter data");
                    int da = sc.nextInt();
                    m.insertAtEnd(da);
                    break;
                case 3:
                    m.deleteAtBeg();
                    break;
                case 4:
                    m.deleteAtEnd();
                    break;
                case 5:
                    m.print();
                    break;
                case 6:
                    System.out.println("Enter position and data");
                    int n = sc.nextInt();
                    int dy = sc.nextInt();
                    m.insertAtPt(n,dy);
                    break;
                case 7:
                    System.out.println("Enter position");
                    int na = sc.nextInt();
                    m.deleteAtPt(na);
                    break;
                case 8:
                    m.head = m.mergeSort(m.head);
                    break;
                case 9:
                    //m.reverseR(m.head,null);
                  // m.head=  m.reverseI();
                    m.reverse();
                    break;
                case 10:
                    m.removeDuplicatesS();
                    break;
                case 11:
                    flag=false;
                    break;
                default:
                    System.out.println("Enter valid input");

            }
        }
    }
}
