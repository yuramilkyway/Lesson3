package ru.innopolis.main;

public class Person {
    private final int age;
    private final Sex sex;
    private final String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Sex: %s, Age: %d;", name, sex, age);
    }
}
