package ru.innopolis.library.sorts;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.api.MyCompare;
import ru.innopolis.library.comparator.CompareAge;
import ru.innopolis.library.comparator.CompareNameAtTheSameAge;
import ru.innopolis.library.person.Person;
import ru.innopolis.library.person.Sex;

import java.util.ArrayList;
import java.util.List;

public abstract class SortPersons implements MethodOfSort {

    protected abstract void sort(List<Person> arrayList, MyCompare o);

    /**
     * Разбиваем по полу список persons.
     * @param persons Список со смешанными объектами Person.
     * @param means Список для хранения объектов Person, где пол == Sex.MAN.
     * @param women Список для хранения объектов Person, где пол == Sex.WOMAN.
     */
    protected void sortFromSex(List<Person> persons, List<Person> means, List<Person> women) {
        for (Person person : persons) {
            if (person.getSex() == Sex.MAN) {
                means.add(person);
            } else {
                women.add(person);
            }
        }
    }

    /**
     * Методы запускает вспомогательные методы для сортировки принимаемого листа.
     * @param incomingList Лист с объекьами Person для сортировки.
     * @return Возвращает отсортированный лист.
     */
    protected List<Person> startAlgorithm(List<Person> incomingList) {

        List<Person> means = new ArrayList<>();
        List<Person> women = new ArrayList<>();

        sortFromSex(incomingList, means, women);
        sort(means, new CompareAge());
        sort(means, new CompareNameAtTheSameAge());
        sort(women, new CompareAge());
        sort(women, new CompareNameAtTheSameAge());

        List<Person> outgoingList = new ArrayList<>(means);
        outgoingList.addAll(women);

        return outgoingList;
    }

    /**
     * Вызывает метод сортировки.
     * @param incomingList Принимает сортируемый список.
     * @return Возвращает отсортированный список.
     */
    @Override
    public List<Person> getSortedList(List<Person> incomingList) {
        return startAlgorithm(incomingList);
    }
}
