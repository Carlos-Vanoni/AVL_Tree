package com.company;

public class Main {

    public static void main(String[] args) {
        Tree avl = new Tree();
        avl.insert(120);
        avl.insert(100);
        avl.insert(130);
        avl.insert(80);
        avl.insert(110);
        avl.insert(200);
        avl.insert(150);

        //avl.print();

        avl.remove(150);

        avl.print();
//      avl.search(6);
//      avl.search(10);
//      avl.search(1);
//      avl.search(2);
    }
}

