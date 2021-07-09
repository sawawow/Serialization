package com.company;

public interface Animal {
    void run();
    default void eat(){
        System.out.println("eat");
    };
}
