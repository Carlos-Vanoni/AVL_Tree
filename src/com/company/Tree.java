package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public boolean insert(String newValue, Person person){
        if (root != null) {
            root.insert(newValue, person);
            root.checkBalance();
        } else {
            root = new Node(newValue, person);
        }
        return true;
    }

    public boolean remove(String value){
        if (root.getValue() != null){
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
            return true;
        }
        return false;
    }

    public void checkBalance(){
        root.checkBalance();
    }

//    public void print(){
//        System.out.println("Estado atual da árvore: ");
//        int height = root.getTreeHeight(0);
//        String[][] tree = new String[height][(int) Math.pow(2, height - 1) * 2];
//        root.print(0, (int) Math.pow(2, height - 1) - 1, tree);
//        for(int i = 0; i < tree.length; i++){
//            for (int j = 0; j < tree[i].length; j++){
//                if (tree[i][j] == null) {
//                    System.out.print("  ");
//                } else {
//                    if (tree[i][j] < 10){
//                        System.out.print(" ");
//                    }
//                    System.out.print(tree[i][j]);
//                }
//            }
//            System.out.print("\n");
//        }
//    }

//    public boolean search(String value){
//        if (root.getValue() != null){
//            return root.search(value);
//        }
//        return false;
//    }

    public Person searchPerson(String value){
        if (root.getValue() != null){
            return root.searchCPF(value);
        }
        return null;
    }

    public ArrayList<Person> searchName(String value){
        if (root.getValue() != null){
            ArrayList<Person> people = new ArrayList<Person>();
            return root.searchName(value, people);
        }
        return null;
    }
    public ArrayList<Person> searchDate(LocalDate start, LocalDate end) {
        if (root.getPerson() != null){
            ArrayList<Person> people = new ArrayList<Person>();
            return root.searchDate(start, end, people);
        }
        return null;
    }
}
