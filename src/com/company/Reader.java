package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private Tree treeCpf;
    private Tree treeName;
    private Tree treeDate;

    public com.company.Tree getTreeCpf() {
        return treeCpf;
    }

    public com.company.Tree getTreeName() {
        return treeName;
    }

    public com.company.Tree getTreeDate() {
        return treeDate;
    }

    public Reader() {
        this.treeCpf = new Tree();
        this.treeName = new Tree();
        this.treeDate = new Tree();
    }

    public void read(String user, String nome) {
        try {
            FileReader fis = new FileReader("C:\\Users\\" + user + "\\" + nome);
            BufferedReader r = new BufferedReader(fis);

            String line = "";
            line = r.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

            while (line != null) {
                String[] listSplited = line.split(";");


                    String cpf = listSplited[0];
                    String rg = listSplited[1];
                    String name = listSplited[2];
                    String bornDate = listSplited[3];
                    String city = listSplited[4];

                    Person newPerson = new Person(cpf, rg, name, bornDate, city);

                    treeCpf.insert(cpf, newPerson);
                    treeDate.insert(bornDate, newPerson);
                    treeName.insert(name, newPerson);

                    System.out.println(cpf);
                    System.out.println(rg);
                    System.out.println(name);
                    System.out.println(bornDate);
                    System.out.println(city);
                    System.out.println(" ");
                    line = r.readLine();
            }

            r.close();
        }catch (FileNotFoundException ex) {
            System.out.println("Arquivo Nao Encontrado");
        }catch (IOException ex) {
            System.out.println("IOE");
        }

    }

    public Person searchCPF(String cpf){
        return treeCpf.searchPerson(cpf);
    }

    public ArrayList<Person>  searchName(String name){
        return treeName.searchName(name);
    }

}
