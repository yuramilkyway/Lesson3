package ru.innopolis.main;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GeneratorPerson generatorPerson = new GeneratorPerson(100);
        Person[] array = generatorPerson.getArray();

        /*for (Person person : array) {
            System.out.println(person.toString());
        }*/

        BubbleSort bubbleSort = new BubbleSort();
        List<Person> people = bubbleSort.getSortedList(array);

        for (Person people1 : people) {
            System.out.println(people1.toString());
        }
    }
}
