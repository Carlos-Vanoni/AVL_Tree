package com.company;

public class Main {

    public static void main(String[] args) {
        Tree avl = new Tree();
        UserInteraction userCommands = new UserInteraction(avl);
        boolean exit =  true;
        avl.print();
        while (exit) {
            String command = userCommands.leString("\nDigite I para inserir um novo nó \nDigite B para buscar um nó" +
                    "\nDigite R para remover um nó \nDigite qualquer outra coisa para finalizar a operação");
            if (!(command.equalsIgnoreCase("I") || command.equalsIgnoreCase("R") || command.equalsIgnoreCase("B"))) {
                exit = false;
                System.out.println("saindo...");
                break;
            }
            int nodeValue = userCommands.leInt("Digite o valor do nó");
            if(userCommands.readCommand(command, nodeValue)) {
                System.out.println("Operação realizada com sucesso!");
            }
            userCommands.print();
        }
    }
}

