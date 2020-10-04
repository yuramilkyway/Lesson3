package ru.innopolis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPerson {
    private static final int DEFAULT_COUNT_PERSON = 100;
    private final File fileWithMaleNames = new File("man.txt");
    private final File fileWithFemaleNames = new File("woman.txt");
    private final List<Person> list = new ArrayList<>();

    public GeneratorPerson(int countPerson) throws IOException {
        if (countPerson < DEFAULT_COUNT_PERSON) {
            countPerson = DEFAULT_COUNT_PERSON;
            System.out.println("Минимальное количество объектов класса Person: " + DEFAULT_COUNT_PERSON);
        }
        launchGeneratorPerson(countPerson);
    }

    private String createName(Sex sex) throws IOException {
        File file;
        int upperBound;

        if (sex.thisMan(sex)) {
            file = fileWithMaleNames;
            upperBound = (int) (Math.random() * 615);
        }
        else {
            file = fileWithFemaleNames;
            upperBound = (int) (Math.random() * 725);
        }

        BufferedReader r = new BufferedReader(new FileReader(file));
        for (int i = 0; i < upperBound; i++) {
            r.readLine();
        }
        return r.readLine();
    }

    private void launchGeneratorPerson(int countPerson) throws IOException {
        for (int i = 0; i < countPerson; i++) {
            int age = (int) ((Math.random() * (100)) + 1);
            Sex sex = new Sex((int) Math.round(Math.random()));
            String name = createName(sex);
            list.add(new Person(age, sex, name));
        }
    }

    public List<Person> getArray() {
        return list;
    }
}
