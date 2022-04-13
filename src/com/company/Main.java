package com.company;

public class Main {

    public static void main(String[] args) {
        Tree avl = new Tree();
        avl.insert(32);
        avl.insert(16);
        avl.insert(48);
        avl.insert(8);
        avl.insert(24);
        avl.insert(40);
        avl.insert(56);

        avl.insert(36);
        avl.insert(28);

        avl.insert(44);
        avl.insert(52);

        avl.insert(60);

        avl.insert(58);
        avl.insert(62);

        avl.remove(8);
        avl.print();
    }
}

