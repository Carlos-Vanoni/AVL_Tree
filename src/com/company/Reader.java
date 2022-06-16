package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reader {

    private Tree treeCpf;
    private Tree treeName;
    private Tree treeDate;


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
            ArrayList<Person> list = new ArrayList<>();
            ArrayList<Person> listAux = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");

            while (line != null) {
                String[] listSplited = line.split(";");


                    String cpf = listSplited[0];
                    String rg = listSplited[1];
                    String name = listSplited[2];
                    try {
                        Date date = formatter.parse(listSplited[3]);
                        String city = listSplited[4];
                        Person newPerson = new Person(cpf, rg, name, listSplited[3], city);
                        treeCpf.insert(cpf, newPerson);
                        Long days = TimeUnit.DAYS.convert(date.getTime(), TimeUnit.MILLISECONDS);
                        treeDate.insert(days.toString(), newPerson);
                        treeName.insert(name, newPerson);

                        System.out.println(cpf);
                        System.out.println(rg);
                        System.out.println(name);
                        System.out.println("days: " + days);
                        System.out.println(city);
                        System.out.println(" ");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
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

    public ArrayList<Person>  searchDate(String start, String end){
        return treeDate.searchDate(start, end);
    }

}
