package ru.innopolis.main;

import java.io.IOException;

public class GeneratorPerson {
    final int defaultCountPerson = 10000;
    final private Person[] array;

    public GeneratorPerson(int countPerson) throws IOException {
        if (countPerson < defaultCountPerson) {
            countPerson = defaultCountPerson;
            System.out.println("Минимальное количество объектов класса Person - 10000;");
        }
        array = new Person[countPerson];
        for (int i = 0; i < countPerson; i++) {
            int age = (int) ((Math.random() * (100)) + 1);
            Sex sex = new Sex((int) Math.round(Math.random()));
            array[i] = new Person(age, sex);
        }
    }

    public Person[] getArray() {
        return array;
    }
}
