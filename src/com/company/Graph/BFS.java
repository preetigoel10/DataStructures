package com.company.Graph;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v){
            adj.get(u).add(v);
            adj.get(v).add(u);
    }
    static void BreadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int V){
        System.out.println("BFS");
        boolean[] visited = new boolean[V];
        for (int i=0;i<V;i++){
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        while(queue.size()!=0){
            int s = queue.peek();
            System.out.print(queue.poll() + " ");
            for (int i=0;i<adj.get(s).size();i++){
                if(visited[adj.get(s).get(i)] == false) {
                queue.add(adj.get(s).get(i));
                    visited[adj.get(s).get(i)] = true;
                }
                }
            }
        System.out.println();
        }
        static void DepthFirstSearch(ArrayList<ArrayList<Integer>>adj, int V){
            System.out.println("DFS");
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
        }
            Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        while(!stack.empty()){
            int s = stack.peek();
            System.out.print(stack.pop()+" ");
            for(int i=0;i<adj.get(s).size();i++){
                int newNode = adj.get(s).get(i);
                if(!visited[newNode]){
                   visited[newNode] = true;
                   stack.push(newNode);
                }
            }
        }
        }
    public static void main(String[] args) {
            int V = 6;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
            for (int i=0;i<V;i++)
            {
                adj.add(new ArrayList<Integer>());
            }
            addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,4,3);
        addEdge(adj,4,5);
        addEdge(adj,3,5);
        BreadthFirstSearch(adj,V);
        DepthFirstSearch(adj,V);

    }
}
