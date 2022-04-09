package com.company;

import com.sun.source.doctree.ValueTree;

public class Node {
    private Node right;
    private Node left;
    private Integer value;
    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

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



    public Node rotateLeft(){
        System.out.println("Rotate left");
        return null;
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
