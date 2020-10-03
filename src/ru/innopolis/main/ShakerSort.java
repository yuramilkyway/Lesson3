package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.api.MyCompare;

import java.util.ArrayList;
import java.util.List;

public class ShakerSort implements MethodOfSort {
    private final List<Person> woman = new ArrayList<>();
    private final List<Person> man = new ArrayList<>();
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

    private static void sort(List<Person> arrayList, MyCompare myCompaer) {
        Person buff;
        int left = 0;
        int right = arrayList.size() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (myCompaer.compareTwoObjects(arrayList.get(i), arrayList.get(i + 1))) {
                    buff = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, buff);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (myCompaer.compareTwoObjects(arrayList.get(i - 1), arrayList.get(i))) {
                    buff = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i - 1));
                    arrayList.set(i - 1, buff);
                }
            }
            left++;
        } while (left < right);
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
