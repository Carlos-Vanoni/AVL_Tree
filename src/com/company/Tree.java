package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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


    public Person searchPerson(String value){
        if (root.getValue() != null){
            return root.searchCPF(value);
        }
        return null;
    }

    public ArrayList<Person> searchName(String value){
        if (value.length() > 0) {
            if (root.getValue() != null){
                ArrayList<Person> people = new ArrayList<Person>();
                root.searchName(value, people);
//                System.out.println(people.size() + " pessoas encontradas");
                return people;
            }
        }
        return null;
    }

    public ArrayList<Person> searchDate(String start, String end){
        if (start.length() > 0 && end.length() > 0) {
            if (root.getValue() != null){
                ArrayList<Person> people = new ArrayList<Person>();
                root.searchDate(start, end, people);
//                System.out.println(people.size() + " pessoas encontradas");
                return people;
            }
        }
        return null;
    }
}
