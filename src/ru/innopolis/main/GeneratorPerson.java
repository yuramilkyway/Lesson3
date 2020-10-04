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
    private final File fileWithMaleNames = new File("man.txt");
    private final File fileWithFemaleNames = new File("woman.txt");
    private final List<Person> list = new ArrayList<>();
    final Random random = new Random();

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

        if (sex.isMan(sex)) {
            file = fileWithMaleNames;
            final int COUNT_MALE_NAMES = 614;
            upperBound = random.nextInt(COUNT_MALE_NAMES) + 1;
        }
        else {
            file = fileWithFemaleNames;
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

    private void launchGeneratorPerson(int countPerson) throws IOException {
        for (int i = 0; i < countPerson; i++) {
            int age = random.nextInt(100) + 1;
            Sex sex = Sex.getRandomGender();
            String name = createName(sex);
            list.add(new Person(age, sex, name));
        }
    }

    public List<Person> getArray() {
        return list;
    }
}
