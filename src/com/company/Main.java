package com.company;

public class Main {

    public static void main(String[] args) {
        Tree avl = new Tree();
        avl.insert(4);
        avl.insert(1);
        avl.insert(3);
        avl.insert(6);
        avl.insert(5);
        avl.insert(2);
        avl.insert(7);
        avl.print();
        System.out.println(avl.search(6));
        System.out.println(avl.search(10));
        System.out.println(avl.search(1));
        System.out.println(avl.search(0));
    }
}

