package com.comunda.isa.Model;

public class Person {
    String name;
    String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
