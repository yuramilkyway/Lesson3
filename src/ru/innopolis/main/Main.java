package ru.innopolis.main;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, DuplicatePersonException {
        GeneratorPerson generatorPerson1 = new GeneratorPerson(100);
        Person[] array1 = generatorPerson1.getArray();
        long startTime = System.nanoTime();
        BubbleSort bubbleSort1 = new BubbleSort();
        long endTime = System.nanoTime();
        List<Person> people1 = bubbleSort1.getSortedList(array1);
        for (Person peop : people1) {
            System.out.println(peop.toString());
        }
        System.out.println("Время работы программы: " + ((endTime - startTime) / 1_000_000_000.0) + " секунд.");
    }
}
