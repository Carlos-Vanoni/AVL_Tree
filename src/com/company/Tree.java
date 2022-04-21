package com.company;

import java.util.ArrayList;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public boolean insert(int newValue){
        root.insert(newValue);
        root.checkBalance();
        return true;
    }

    public boolean remove(int value){
        Node toRemove =  root.searchNode(value);
        if (toRemove != null) {
            toRemove.remove();
        }
        root.checkNull();
        boolean balanced = root.checkBalance();
        balanced = root.checkBalance();
        while (!balanced){
            balanced = root.checkBalance();
        }
        return true;
    }

    public void checkBalance(){
        root.checkBalance();
    }

    public void print(){
        System.out.println("Estado atual da árvore: ");
        int height = root.getTreeHeight(0);
        Integer[][] tree = new Integer[height][(int) Math.pow(2, height - 1) * 2];
        root.print(0, (int) Math.pow(2, height - 1), tree);
        for(int i = 0; i < tree.length; i++){
            for (int j = 0; j < tree[i].length; j++){
                if (tree[i][j] == null) {
                    System.out.print("  ");
                } else {
                    if (tree[i][j] < 10){
                        System.out.print(" ");
                    }
                    System.out.print(tree[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    public boolean search(int value){
        return root.search(value);
    }
}
