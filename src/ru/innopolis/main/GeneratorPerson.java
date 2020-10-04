package ru.innopolis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorPerson {
    private static final int DEFAULT_COUNT_PERSON = 10000;
    private static final File FILE_WITH_MEAN_NAMES = new File("man.txt");
    private static final File FILE_WITH_FEMALE_NAMES = new File("woman.txt");
    final Random random = new Random();
    private final int COUNT_PERSON;

    public GeneratorPerson(int countPerson) {
        if (countPerson < DEFAULT_COUNT_PERSON) {
            this.COUNT_PERSON = DEFAULT_COUNT_PERSON;
            System.out.println("Минимальное количество объектов класса Person: " + DEFAULT_COUNT_PERSON);
        }
        else {
            this.COUNT_PERSON = countPerson;
        }
    }

    private String createName(Sex sex) throws IOException {
        File file;
        int upperBound;

        if (sex.isMan(sex)) {
            file = FILE_WITH_MEAN_NAMES;
            final int COUNT_MALE_NAMES = 614;
            upperBound = random.nextInt(COUNT_MALE_NAMES) + 1;
        }
        else {
            file = FILE_WITH_FEMALE_NAMES;
            final int COUNT_FEMALE_NAMES = 724;
            upperBound = random.nextInt(COUNT_FEMALE_NAMES) + 1;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < upperBound; i++) {
                bufferedReader.readLine();
            }
            return bufferedReader.readLine();
        }
    }

    private List<Person> launchGeneratorPerson(int countPerson) throws IOException {
        final List<Person> list = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            int age = random.nextInt(100) + 1;
            Sex sex = Sex.getRandomGender();
            String name = createName(sex);
            list.add(new Person(age, sex, name));
        }
        return list;
    }

    public List<Person> getListRandomPerson() throws IOException {
        return (launchGeneratorPerson(COUNT_PERSON));
    }
}
