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
        if (toRemove != null){
           if (toRemove.getLeft() != null){
               Integer largestValue = toRemove.getLeft().findLargest(toRemove.getValue());
               toRemove = toRemove.searchNode(largestValue);
           } else if (toRemove.getRight() != null) {
                toRemove = toRemove.getRight();
           } else {
               toRemove = null;
           }
        }
    }

    public void print(){
        root.print(0);
    }

    public boolean search(Integer value){
        return root.search(value);
    }
}
