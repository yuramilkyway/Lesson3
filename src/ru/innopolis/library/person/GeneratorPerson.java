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
    private boolean isNotInit = true;
    final Random random = new Random();
    private final int COUNT_PERSON;

    /**
     * Конструктор класса GeneratorPerson.
     * Задает количество элементов при генерации Person.
     * Если принимаемое значение меньше количества,
     * заданого по условию задачи(DEFAULT_COUNT_PERSON),
     * то задает дефолтное(DEFAULT_COUNT_PERSON) значение элементов.
     * @param countPerson Количество элементов, с которым мы хотим
     *                    сгенерировать список Person.
     */
    public GeneratorPerson(int countPerson) {
        if (countPerson < DEFAULT_COUNT_PERSON) {
            this.COUNT_PERSON = DEFAULT_COUNT_PERSON;
            System.out.println("Минимальное количество объектов класса Person: " + DEFAULT_COUNT_PERSON);
        }
        else {
            this.COUNT_PERSON = countPerson;
        }
    }

    private void initList() {
        readNamesFromFileAndWriteToList(FILE_WITH_MEAN_NAMES, LIST_WITH_MEAN_NAMES);
        readNamesFromFileAndWriteToList(FILE_WITH_FEMALE_NAMES, LIST_WITH_FEMALE_NAMES);
    }

    private void readNamesFromFileAndWriteToList(File file, List<String> list) {
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String temp = bufferedReader.readLine();
                while (temp != null) {
                    list.add(temp);
                    temp = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Не найдены файлы для чтения имен. " + e);
        }
    }

    private String getNameFromList(List<String> list) {
        int randomFemaleName = random.nextInt(list.size());
        return list.get(randomFemaleName);
    }

    private String getName(Sex sex) {
        if (isNotInit) {
            initList();
            isNotInit = false;
        }

        if (sex.isMan(sex)) {
            return getNameFromList(LIST_WITH_MEAN_NAMES);
        } else {
            return getNameFromList(LIST_WITH_FEMALE_NAMES);
        }
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
