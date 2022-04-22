package com.company;

import com.sun.source.doctree.ValueTree;

import java.util.ArrayList;

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

    public void print(int x, int y, Integer[][] tree){
        if (value != null){
            tree[x][y] = value;
            if (right != null){
                right.print(x + 1, y + (int) Math.pow(2, getTreeHeight(0) - 2), tree);
            }
            if (left != null){
                left.print(x + 1, y - (int) Math.pow(2, getTreeHeight(0) - 2), tree);
            }
        }
    }

    public boolean search(Integer value){
        System.out.print(this.value + " -> ");
        if (this.value.equals(value)){
            System.out.print("Encontrado\n");
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
                System.out.print("Fim da árvore, valor não encontrado\n");
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
        Node temp = this.clone();
        value = left.getValue();
        left = left.getRight();
        temp.left = temp.getLeft().getRight();
        right = temp;
    }

    public void rotateLeft(){
        Node temp = this.clone();
        value = right.getValue();
        right = right.getRight();
        temp.right = temp.getRight().getLeft();
        left = temp;
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
        int largestLeft = 0;
        int largestRight = 0;
        if (value != null) {
            if (left != null){
                largestLeft = left.findLargest(0);
            }
            if (right != null){
                largestRight = right.findLargest(0);
            }
            if (largestLeft > largestRight){
                largestValue = largestLeft;
            } else {
                largestValue = largestRight;
            }
            if (value > largestValue){
                largestValue = value;
            }
        }
        return largestValue;
    }

    public boolean checkBalance(){
        boolean balanceRight = true;
        boolean balanceLeft = true;
        if (value != null){
            Integer factor = getFactor();
            if (factor > 1){
                System.out.println("Arvore desbalanceada");
                if (left.getFactor() > 0){
                    System.out.println("Realizando rotação a direita");
                    rotateRight();
                    balanceRight = false;
                } else if (left.getFactor() < 0){
                    System.out.println("Realizando dupla rotação a direita");
                    doubleRotationRight();
                    balanceRight = false;
                }
            } else if (factor < -1){
                System.out.println("Arvore desbalanceada");
                if (right.getFactor() < 0){
                    System.out.println("Realizando rotação a esquerda");
                    rotateLeft();
                    balanceLeft = false;
                } else if (right.getFactor() > 0) {
                    System.out.println("Realizando dupla rotação a esquerda");
                    doubleRotationLeft();
                    balanceLeft = false;
                }
            }
        }
        if (right != null) {
            balanceRight = right.checkBalance();
        }
        if (left != null) {
            balanceLeft = left.checkBalance();
        }
        return balanceRight && balanceLeft;
    }

    public Node searchNode(Integer value){
        if (this.value.equals(value)){
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

    public void remove(){
        if (left != null){
            Integer largestValue = left.findLargest(0);
            Node largestLeft = searchNode(largestValue);
            if (largestLeft != null){
                value = largestLeft.getValue();
                largestLeft.remove();
            }
        } else if (right != null) {
            value = right.getValue();
            right.remove();
        } else {
            Node toRemove = searchNode(value);
            toRemove = null;
            clear();
        }
        checkNull();
    }

    public void checkNull(){
        if (left != null){
            if (left.getValue() == null){
                left = null;
            }
            else {
                left.checkNull();
            }
        }
        if (right != null){
            if (right.getValue() == null){
                right = null;
            } else {
                right.checkNull();
            }
        }
    }

    public void clear(){
        left = null;
        right = null;
        value = null;
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

