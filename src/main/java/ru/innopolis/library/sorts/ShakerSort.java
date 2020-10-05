package ru.innopolis.library.sorts;

import ru.innopolis.api.MyCompare;
import ru.innopolis.library.person.Person;

import java.util.List;

public class ShakerSort extends SortPersons {

    /**
     * Реализация Шейкерной сортировки.
     * @param personList Лист, который надо отсортировать.
     * @param comparisonMethod Метод сравнения.
     */
    protected void sort(List<Person> personList, MyCompare comparisonMethod) {
        Person buff;
        int left = 0;
        int right = personList.size() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (comparisonMethod.compareTwoObjects(personList.get(i), personList.get(i + 1))) {
                    buff = personList.get(i);
                    personList.set(i, personList.get(i + 1));
                    personList.set(i + 1, buff);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (comparisonMethod.compareTwoObjects(personList.get(i - 1), personList.get(i))) {
                    buff = personList.get(i);
                    personList.set(i, personList.get(i - 1));
                    personList.set(i - 1, buff);
                }
            }
            left++;
        } while (left < right);
    }
}
