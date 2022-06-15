package com.company;
import java.time.LocalDate;

public class Person {

    private String cpf;
    private String rg;
    private String name;
    private String bornDate;
    private String city;

    public Person(String cpf, String rg, String name, String bornDate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.bornDate = bornDate;
        this.city = city;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cpf=" + cpf +
                ", rg=" + rg +
                ", name='" + name + '\'' +
                ", bornDate=" + bornDate +
                ", city='" + city + '\'' +
                '}';
    }
}
