package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Tree avl = new Tree();
//        avl.insert(32);
//        avl.insert(16);
//        avl.insert(48);
//        avl.insert(8);
//        avl.insert(24);
//        avl.insert(40);
//        avl.insert(56);
//
//        avl.insert(36);
//        avl.insert(28);
//
//        avl.insert(44);
//        avl.insert(52);
//
//        avl.insert(60);
//        avl.insert(7);
//        avl.insert(1);
//        avl.insert(2);
//        avl.insert(1);
//        avl.insert(5);
//        avl.insert(4);
//        avl.insert(14);
//        avl.insert(20);
//        avl.insert(16);
//        UserInteraction userCommands = new UserInteraction(avl);
//        boolean exit =  true;
//        avl.print();
//        while (exit) {
//            String command = userCommands.leString("\nDigite I para inserir um novo nó \nDigite B para buscar um nó" +
//                    "\nDigite R para remover um nó \nDigite qualquer outra coisa para finalizar a operação");
//            if (!(command.equalsIgnoreCase("I") || command.equalsIgnoreCase("R") || command.equalsIgnoreCase("B"))) {
//                exit = false;
//                System.out.println("saindo...");
//                break;
//            }
//            int nodeValue = userCommands.leInt("Digite o valor do nó");
//            if(userCommands.readCommand(command, nodeValue)) {
//                System.out.println("Operação realizada com sucesso!");
//            }
//            userCommands.print();
//        }
        Reader r = new Reader();
        r.read("eduar", "teste.csv");
//        Person tal = r.searchCPF("10987654325");
//        System.out.println(tal.toString());
//        ArrayList<Person> people = r.searchName("A");
        ArrayList<Person> people = r.searchDate("10/02/2020", "10/03/4002");
        System.out.println(people);
    }
}

