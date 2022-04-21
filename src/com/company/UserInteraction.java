package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UserInteraction {

    private String s;
    private InputStreamReader i = new InputStreamReader (System.in);
    private BufferedReader d = new BufferedReader(i);
    private final Tree tree;
    public UserInteraction(Tree tree) {
        this.tree = tree;
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

    public boolean readCommand(String command, Integer value) {
        if(command.equalsIgnoreCase("i"))
            return tree.insert(value);
        if(command.equalsIgnoreCase("b"))
            return tree.search(value);
        if(command.equalsIgnoreCase("r"))
            return tree.remove(value);
        else {
            System.out.println("comando invalido");
            return false;
        }
    }

    public void print() {
        tree.print();
    }
}