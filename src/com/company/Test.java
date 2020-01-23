package com.company;


import java.util.*;
import java.io.*;

class Test {

    public static int SeatingStudents(int[] arr) {
        int arr1[] = new int[arr[0]+1];
        for(int i=0;i<arr1.length;i++){
            arr1[i] = 0;
        }
        for(int i=1;i<arr.length;i++){
            arr1[arr[i]] = 1;
        }
        int count =0;
        for(int i=1;i<arr1.length-2;i++){
            if(arr1[i] == 0)
            {
                if(i%2 != 0)
                {
                    if(arr1[i] == 0 && arr1[i+1] == 0)
                        count++;
                    if(arr1[i] == 0 && arr1[i+2] == 0)
                        count++;
                }
                else{
                    if(arr1[i] == 0 && arr1[i+2] == 0)
                        count++;
                }
            }
        }
        int n = arr1.length;
        if(arr1[n-2] == 0 && arr1[n-1] == 0)
            count++;
        return count;


    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            int userInput = Integer.parseInt(sc.next());
            input[i] = userInput;
        }
        System.out.print(SeatingStudents(input));
    }
}
