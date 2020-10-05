package ru.innopolis.library.person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorPerson {
    private static final int DEFAULT_COUNT_PERSON = 10000;
    private static final File FILE_WITH_MEAN_NAMES = new File("resources/man.txt");
    private static final File FILE_WITH_FEMALE_NAMES = new File("resources/woman.txt");
    private final List<String> LIST_WITH_MEAN_NAMES = new ArrayList<>();
    private final List<String> LIST_WITH_FEMALE_NAMES = new ArrayList<>();
    private boolean isInit = true;
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

    private String getName(Sex sex) {
        try {
            if (isInit) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_WITH_MEAN_NAMES))) {
                    String temp = bufferedReader.readLine();
                    while (temp != null) {
                        LIST_WITH_MEAN_NAMES.add(temp);
                        temp = bufferedReader.readLine();
                    }
                }
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_WITH_FEMALE_NAMES))) {
                    String temp = bufferedReader.readLine();
                    while (temp != null) {
                        LIST_WITH_FEMALE_NAMES.add(temp);
                        temp = bufferedReader.readLine();
                    }
                }
                isInit = false;
            }

            if (sex.isMan(sex)) {
                int randomMeanName = random.nextInt(LIST_WITH_MEAN_NAMES.size());
                return LIST_WITH_MEAN_NAMES.get(randomMeanName);
            } else {
                int randomFemaleName = random.nextInt(LIST_WITH_FEMALE_NAMES.size());
                return LIST_WITH_FEMALE_NAMES.get(randomFemaleName);
            }
        } catch (IOException e) {
            System.out.println("Не найдены файлы для чтения имен. " + e);
        }
        return "unnamed";
    }

    private List<Person> launchGeneratorPerson(int countPerson) {
        final List<Person> list = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            int age = random.nextInt(100) + 1;
            Sex sex = Sex.getRandomGender();
            String name = getName(sex);
            list.add(new Person(age, sex, name));
        }
        return list;
    }

    public List<Person> getListRandomPerson() {
        return (launchGeneratorPerson(COUNT_PERSON));
    }
}
