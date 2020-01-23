package com.company.Hashing;
import java.util.*;
import java.io.*;
import java.lang.*;

public class LinearProbing {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while (t-- > 0) {
            int hash_size = sc.nextInt();
            int array_size = sc.nextInt();

            int arr[] = new int[array_size];
            for (int i = 0; i < array_size; i++)
                arr[i] = sc.nextInt();

            int hash_table[] = new int[hash_size];
            for (int i = 0; i < hash_size; i++)
                hash_table[i] = -1;

            linearProbing(hash_table, hash_size, arr, array_size);

            for (int i = 0; i < hash_size; i++)
                System.out.print(hash_table[i] + " ");

            System.out.println();

        }
    }
    //Position this line where user code will be pasted.

    static void linearProbing(int hash_table[], int hash_size, int arr[], int array_size) {
        for(int i=0;i<array_size;i++)
        {
            int n = arr[i]%hash_size;
            if(hash_table[n] == -1)
                hash_table[n] = arr[i];
            else{
                while(hash_table[n]!= -1 && n<hash_size-1)
                    ++n;
                if(hash_table[n] == -1)
                    hash_table[n] = arr[i];
                else if(hash_table[n] == hash_size-1)
                {
                    n=0;
                    while(hash_table[n]!= -1 && n<hash_size-1)
                        ++n;
                    if(hash_table[n] == -1)
                        hash_table[n] = arr[i];
                }
            }
        }
    }
}

