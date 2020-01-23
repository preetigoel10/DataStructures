package com.company.BinaryTree;

import org.jetbrains.annotations.Contract;

public class inOrder {
    static class BinaryTree {
        int info;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int info) {
            this.info = info;
        }
    }
    static void inorder(BinaryTree root){
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.info);
        inorder(root.right);
    }
    static void preorder(BinaryTree root){
        if(root == null)
        {
            return;
        }

        System.out.println(root.info);
        inorder(root.left);
        inorder(root.right);
    }
    static void postorder(BinaryTree root){
        if(root == null)
        {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        System.out.println(root.info);
    }
     public static void main(String[] args) {
         BinaryTree root = new BinaryTree(10);
         root.left = new BinaryTree(5);
         root.right = new BinaryTree(3);
         postorder(root);
    }
}
