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

    public void print(Integer height){
        if (value != null){
            System.out.print(value + " " + height + "\n");
            if (right != null){
                right.print(height + 1);
            }
            if (left != null){
                left.print(height + 1);
            }
        }
    }

    public boolean search(Integer value){
        System.out.print(this.value + " -> ");
        if (this.value == value){
            System.out.print("Found\n");
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
                System.out.print("End of tree\n");
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

    public Node clone(){
        Node newNode = new Node();
        newNode.setLeft(left);
        newNode.setRight(right);
        newNode.setValue(value);
        return newNode;
    }

    public void rotateRight(){
        Node temp = left.clone();
        left = left.getLeft();
        right = new Node(value);
        value = temp.getValue();
    }

    public void rotateLeft(){
        Node temp = right.clone();
        right = right.getRight();
        left = new Node(value);
        value = temp.getValue();
    }

    public void doubleRotationRight(){
        left.rotateLeft();
        rotateRight();
    }

    public void doubleRotationLeft(){
        right.rotateRight();
        rotateLeft();
    }

    public int findLargest(int largestValue){
        if (value > largestValue){
            largestValue = value;
        }
        if (left != null){
            return findLargest(largestValue);
        }
        if (right != null){
            return findLargest(largestValue);
        }
        return largestValue;
    }

    public void checkBalance(){
        if (value != null){
            Integer factor = getFactor();
            if (factor > 1){
                if (left.getFactor() > 0){
                    rotateRight();
                } else if (left.getFactor() < 0){
                    doubleRotationRight();
                }
            } else if (factor < -1){
                if (right.getFactor() < 0){
                    rotateLeft();
                } else if (right.getFactor() > 0) {
                    doubleRotationLeft();
                }
            }
        }
        if (right != null) {
            right.checkBalance();
        }
        if (left != null) {
            left.checkBalance();
        }
    }

    public Node searchNode(Integer value){
        if (this.value == value){
            return this;
        }
        else {
            if (value > this.value && right != null){
                return right.searchNode(value);
            }
            else if (left != null) {
                return left.searchNode(value);
            }
            else {
                return null;
            }
        }
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
