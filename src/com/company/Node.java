package com.company;

import com.sun.source.doctree.ValueTree;

public class Node {
    private Node right;
    private Node left;
    private Integer value;

    public Node(Node right, Node left, Integer value) {
        this.right = right;
        this.left = left;
        this.value = value;
    }

    public Node(Node right, Node left) {
        this.right = right;
        this.left = left;
    }

    public Node(Integer value) {
        this.right = null;
        this.left = null;
        this.value = value;
    }

    public Node() {
        this.right = null;
        this.left = null;
    }

    public void insert(Integer newValue){
        if (value == null){
            value = newValue;
        }
        else if (newValue < value){
            if (left == null){
                left = new Node(newValue);
            }
            else {
                left.insert(newValue);
            }
        }
        else if (newValue > value) {
            if (right == null) {
                right = new Node(newValue);
            } else {
                right.insert(newValue);
            }
        }
    }

    public void print(){
        if (value != null){
            System.out.print(" " + value + " " +  this.getFactor() + " " + "\n");
            if (right != null){
                right.print();
            }
            if (left != null){
                left.print();
            }
        }
    }

    public void checkBalance(){
        if (value != null){
            Integer factor = this.getFactor();
            if (factor > 1){
                if (left.getFactor() > 0){
                    rotateRight();
                }
            }
            if (factor < -1){
                if (right.getFactor() < 0){
                    rotateLeft();
                }
            }
        }
    }

    public void rotateRight(){

    }

    public void rotateLeft(){

    }

    public boolean search(Integer value){
        if (this.value == value){
            return true;
        }
        else {
            if (value > this.value && right != null){
                return right.search(value);
            }
            else if (left != null) {
                return left.search(value);
            }
            else {
                return false;
            }
        }
    }

    public Integer getFactor(){
        Integer heightLeft = 0;
        Integer heightRight = 0;
        if (left != null){
            heightLeft = left.getTreeHeight(0);
        }
        if (right != null){
            heightRight = right.getTreeHeight(0);
        }
        return heightLeft - heightRight;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getTreeHeight(Integer height){
        Integer heightLeft = 0;
        Integer heightRight = 0;
        if (value == null){
            return height;
        }
        if (right != null){
            heightRight = right.getTreeHeight(height);
        }
        if (left != null){
            heightLeft = left.getTreeHeight(height);
        }
        if (heightLeft > heightRight){
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }
}
