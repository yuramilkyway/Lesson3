package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.api.MyCompare;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements MethodOfSort {
    private final ArrayList<Person> woman = new ArrayList<>();
    private final ArrayList<Person> man = new ArrayList<>();
    private long startTime;
    private long endTime;

    private void sortFromSex(List<Person> array) {
        for (Person person : array) {
            if (person.getSex().equals("MAN")) {
                man.add(person);
            } else {
                woman.add(person);
            }
        }
    }

    private void sort(ArrayList<Person> arrayList, MyCompare o) {
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (o.myCompare(arrayList.get(i), arrayList.get(i + 1))) {
                    isSorted = false;

                    buf = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, buf);
                }
            }
        }
    }

    public double getAlgorithmRunningTime() {
        return (endTime - startTime) / 1_000_000_000.0;
    }

    @Override
    public List<Person> getSortedList(List<Person> incomingList) {

        startTime = System.nanoTime();
        sortFromSex(incomingList);
        sort(man, new CompareAge());
        sort(man, new CompareNameAtTheSameAge());
        sort(woman, new CompareAge());
        sort(woman, new CompareNameAtTheSameAge());

        List<Person> outgoingList = new ArrayList<>(man);
        outgoingList.addAll(woman);
        endTime = System.nanoTime();

        return outgoingList;
    }
}
