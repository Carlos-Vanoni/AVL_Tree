package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserInteraction {

    private String s;
    private InputStreamReader i = new InputStreamReader (System.in);
    private BufferedReader d = new BufferedReader(i);

    private final Reader reader;
    private Tree treeCpf;
    private Tree treeName;
    private Tree treeDate;


    public UserInteraction(Reader reader) {
        this.reader = reader;
        this.treeCpf = reader.getTreeCpf();
        this.treeName = reader.getTreeName();
        this.treeDate = reader.getTreeName();
    }

    public int leInt (String msg)
    {   int a = 0;
        System.out.println(msg);
        try
        {
            s = d.readLine();
            a = Integer.parseInt(s);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: "+e );
        }
        catch (NumberFormatException e)
        {
            System.out.println ("o valor digitado deve ser inteiro: "+e );
        }
        return (a);
    }

    public String leString(String msg)
    {   s = "";
        System.out.println(msg);
        try
        {
            s = d.readLine();
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (s);
    }

    public Person searchCPF(String cpf){
        return treeCpf.searchPerson(cpf);
    }

    public ArrayList<Person> searchName(String name){
        return treeName.searchName(name);
    }

    public ArrayList<Person> searchDate(LocalDate start, LocalDate end){
        return treeDate.searchDate(start, end);
    }

//    public boolean readCommand(String command, String value) {
//        if(command.equalsIgnoreCase("i"))
//            return tree.insert(value);
//        if(command.equalsIgnoreCase("b"))
//            return tree.search(value);
//        if(command.equalsIgnoreCase("r"))
//            return tree.remove(value);
//        else {
//            System.out.println("comando invalido");
//            return false;
//        }
//    }

//    public void print() {
//        tree.print();
//    }
}