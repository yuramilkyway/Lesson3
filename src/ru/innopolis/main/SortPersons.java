package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.api.MyCompare;

import java.util.ArrayList;
import java.util.List;

public abstract class SortPersons implements MethodOfSort {

    protected void sort(List<Person> arrayList, MyCompare o) {

    }

    protected void sortFromSex(List<Person> persons, List<Person> mans, List<Person> womans) {
        for (Person person : persons) {
            if (person.getSex().equals("MAN")) {
                mans.add(person);
            } else {
                womans.add(person);
            }
        }
    }

    @Override
    public List<Person> getSortedList(List<Person> incomingList) {
        List<Person> mans = new ArrayList<>();;
        List<Person> womans = new ArrayList<>();

        //startTime = System.nanoTime();
        sortFromSex(incomingList, mans, womans);
        sort(mans, new CompareAge());
        sort(mans, new CompareNameAtTheSameAge());
        sort(womans, new CompareAge());
        sort(womans, new CompareNameAtTheSameAge());

        List<Person> outgoingList = new ArrayList<>(mans);
        outgoingList.addAll(womans);
        //endTime = System.nanoTime();

        return outgoingList;
    }
}
