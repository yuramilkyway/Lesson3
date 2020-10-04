package ru.innopolis.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPerson {
    private static final int DEFAULT_COUNT_PERSON = 100;
    private final List<Person> list;

    public GeneratorPerson(int countPerson) throws IOException {
        if (countPerson < DEFAULT_COUNT_PERSON) {
            countPerson = DEFAULT_COUNT_PERSON;
            System.out.println("Минимальное количество объектов класса Person: " + DEFAULT_COUNT_PERSON);
        }
        list = new ArrayList<>();
        launchGeneratorPerson(countPerson);
    }

    private void launchGeneratorPerson(int countPerson) throws IOException {
        for (int i = 0; i < countPerson; i++) {
            int age = (int) ((Math.random() * (100)) + 1);
            Sex sex = new Sex((int) Math.round(Math.random()));
            list.add(new Person(age, sex));
        }
    }

    public List<Person> getArray() {
        return list;
    }
}
