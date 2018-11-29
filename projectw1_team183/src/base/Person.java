package base;

import java.util.Scanner;

public abstract class Person {
    private String name;
    private int age;

    Scanner reader = new Scanner(System.in);


    public String getName(){return this.name;};

    public int getAge(){return this.age;};

}
