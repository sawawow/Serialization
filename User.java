package com.company;

import java.io.Serializable;

public class User implements Serializable {

    private final static long serialVersionUID = 2;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //модификатор доступа не влияет на процесс сериализации
    public int age;
    protected String name;
    //игнорирует поле при сериализации
    public transient Job job;
}
