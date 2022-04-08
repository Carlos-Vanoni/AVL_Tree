package com.company;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public void insert(Integer newValue){
        root.insert(newValue);
    }

    public void print(){
        root.print();
    }
}
