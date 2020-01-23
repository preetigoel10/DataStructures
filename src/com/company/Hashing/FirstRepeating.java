package com.company.Hashing;
import java.util.*;
import java.lang.*;
import java.io.*;
public class FirstRepeating {
 public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t>0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++)
                {
                    arr[i] = sc.nextInt();
                }
                printFirstRepeating(arr,n);
                t--;
            }
        }
        public static void printFirstRepeating(int arr[],int n){
            HashSet<Integer> hs = new HashSet<>();
            int min = -1;
            for(int i=n-1;i>=0;i--)
            {
                if(hs.contains(arr[i]))
                {
                    min = i;
                }
                else
                    hs.add(arr[i]);
            }

            System.out.println(min);
        }
    }

