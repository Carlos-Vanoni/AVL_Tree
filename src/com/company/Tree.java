package com.company;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public void insert(Integer newValue){
        root.insert(newValue);
        root.checkBalance();
    }

    public void remove(Integer value){
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
    }

    public void checkBalance(){
        root.checkBalance();
    }

    public void print(){
        root.print(0);
    }

    public boolean search(Integer value){
        return root.search(value);
    }
}
