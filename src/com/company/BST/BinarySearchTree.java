package com.company.BST;

public class BinarySearchTree {
    class Node{
        int key;
        Node left,right;

        public Node(int key) {
            this.key = key;
        }
    }
    Node root;
    void insert(int key){
        root = insertRec(root,key);
    }
     Node insertRec(Node root, int key){
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        if(key<root.key)
           root.left= insertRec(root.left,key);
        else if(key>root.key)
           root.right= insertRec(root.right,key);

        return root;
     }
     Node search(Node root,int key){
        if(root == null || root.key == key){
            return root;
        }
        if(key<root.key)
            return search(root.left,key);
        else
            return search(root.right,key);

     }
     void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
     }
     void delete(int key){
        root = deleteRec(root,key);
     }
     Node deleteRec(Node root, int key){
        if(root == null)
            return root;
        if(key<root.key){
            root.left = deleteRec(root.left,key);
        }
        else if(key>root.key)
           root.right = deleteRec(root.right,key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right,root.key);
        }
        return root;
     }
     int minValue(Node root){
        int min = root.key;
        while(root.left != null){
            min = root.left.key;
            root = root.left;
        }
        return min;
     }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.inorder(binarySearchTree.root);
        Node search = binarySearchTree.search(binarySearchTree.root,70);
        System.out.println();
        System.out.println(search.key);
        binarySearchTree.delete(40);
        binarySearchTree.inorder(binarySearchTree.root);
    }
}
