package ru.innopolis.main;

import java.io.IOException;

public class GeneratorPerson {
    final private int DEFAULT_COUNT_PERSON = 10000;
    final private Person[] array;

    public GeneratorPerson(int countPerson) throws IOException {
        if (countPerson < DEFAULT_COUNT_PERSON) {
            countPerson = DEFAULT_COUNT_PERSON;
            System.out.println("Минимальное количество объектов класса Person: " + DEFAULT_COUNT_PERSON);
        }
        array = new Person[countPerson];
        launchGeneratorPerson(countPerson);
    }

    private void launchGeneratorPerson(int countPerson) throws IOException {
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
