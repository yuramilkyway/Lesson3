package ru.innopolis.library.sorts;

import ru.innopolis.api.MyCompare;
import ru.innopolis.library.person.Person;

import java.util.List;

public class BubbleSort extends SortPersons {

    /**
     * Реализация пузырьковой сортировки.
     * @param personList Лист, который надо отсортировать.
     * @param comparisonMethod Метод сравнения.
     */
    protected void sort(List<Person> personList, MyCompare comparisonMethod) {
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < personList.size() - 1; i++) {
                if (comparisonMethod.compareTwoObjects(personList.get(i), personList.get(i + 1))) {
                    isSorted = false;

                    buf = personList.get(i);
                    personList.set(i, personList.get(i + 1));
                    personList.set(i + 1, buf);
                }
            }
        }
    }
}
