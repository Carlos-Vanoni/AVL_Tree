//Participantes: Eduardo Bernardi e Carlos Eduardo Vanoni
package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Person> people;

        boolean running = true;

        while (running) {
            Reader reader = new Reader();
            UserInteraction userCommands = new UserInteraction(reader);
            String user = userCommands.leString("\n Digite usuário do seu computador: ");
            String file = userCommands.leString("\n Digite o nome do arquivo csv que deseja ler (sem a extensão): ");
            reader.read(user, file);
            System.out.println("Pessoas carregadas do arquivo");

            while (true) {
                String command = userCommands.leString("\nDigite 1 para pesquisar por uma pessoa pelo CPF: "
                        + "\nDigite 2 para pesquisar pessoas pelo nome"
                        + "\nDigite 3 para pesquisar pessoas que nasceram em certo periodo"
                        + "\nDigite 4 para sair"
                        + "\nDigite 0 para voltar a seleção do arquivo");

                if(command.equals("1")) {
                    String cpf = userCommands.leString("\n Digite o CPF: ");
                    Person person = userCommands.searchCPF(cpf);
                    if (person == null)
                        System.out.println("Nao foi encontrado ninguem");
                    else
                        System.out.println(person);
                }
                if(command.equals("2")) {
                    String name = userCommands.leString("\n Digite o nome (ou iniciais): ");
                    people = userCommands.searchName(name);
                    if (people == null || people.isEmpty())
                        System.out.println("Nao foi encontrado ninguem");
                    else
                        System.out.println(people);
                }
                if(command.equals("3")) {
                    String start = userCommands.leString("\n Digite a data inicial no formato DIA/MES/ANO: ");
                    String end = userCommands.leString("\n Digite a data final no formato DIA/MES/ANO: ");
                    people = userCommands.searchDate(start, end);
                    if (people == null || people.isEmpty())
                        System.out.println("Nao foi encontrado ninguem");
                    else
                        System.out.println(people);
                }
                if(command.equals("4")) {
                    running = false;
                    break;
                }
                if(command.equals("0")) {
                    break;
                }
            }
        }


    }
}

