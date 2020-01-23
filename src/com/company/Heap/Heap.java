package com.company.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {
    void heapify(int arr[],int n,int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l<n && arr[l]>arr[largest]){
            largest = l;
        }
        if(r<n && arr[r]>arr[largest])
            largest = r;
        if(largest != i)
        {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr,n,largest);
        }
    }
    void heapifyInsert(int arr[],int n,int i)
    {
        int parent = (i-1)/2;
        if(parent>=0)
        {
            if(arr[parent]<arr[i])
            {
                int swap = arr[i];
                arr[i] = arr[parent];
                arr[parent] = swap;

                heapifyInsert(arr, n, parent);
            }
        }
    }
    void insert(int []arr,int count, int key){
        arr[count] = key;
        count++;
        heapifyInsert(arr,count,count-1);

    }
    void buildHeap(int []arr,int n)
    {
        int startIdx = (n-2)/2;
        for(int i = startIdx;i>=0;i--)
        {
            heapify(arr,n,i);
        }
    }
    int deleteRoot(int arr[],int n){
//        System.out.println(n);
//        System.out.println(arr[0] + " " + arr[n-1]);
//       arr[0] = arr[n-1];
//       n = n-1;
//       print(arr);
//       heapify(arr,n,0);
//       return n;
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

        // return new size of Heap
        return n;
    }
    void print(int []arr){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i] + " ");
        System.out.println();
    }
     void prin(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    public static void main(String[] args) {
//        int arr[] = {22,1,83,4,9,12,55};
//        Heap heap = new Heap();
//        heap.print(arr);
//        heap.buildHeap(arr,7);
//        System.out.println();
//        heap.print(arr);
//        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
//        for(int i=0;i<7;i++)
//        {
//            queue.add(arr[i]);
//        }
//        System.out.println();
//        while (!queue.isEmpty()){
//            System.out.print(queue.poll() + " ");
//        }
        Heap heap = new Heap();
        int arr[] = new int[5];
        int count =-1;
        heap.insert(arr,++count,10);
        heap.print(arr);
        heap.insert(arr,++count,5);
        heap.print(arr);
        heap.insert(arr,++count,3);
        heap.print(arr);
        heap.insert(arr,++count,2);
        heap.print(arr);
        heap.insert(arr,++count,4);
        heap.print(arr);
//        heap.insert(arr,++count,13);
//        heap.print(arr);
//        heap.insert(arr,++count,11);
//        heap.print(arr);
        int n = arr.length;
      n= heap.deleteRoot(arr,arr.length);
        heap.prin(arr,n);

    }
}
