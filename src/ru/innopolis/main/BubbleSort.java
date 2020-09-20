package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;

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

    private void sortFromAge(ArrayList<Person> arrayList) {
        boolean isSorted = false;
        Person buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if(compareAge(arrayList.get(i), arrayList.get(i + 1))){
                    isSorted = false;

                    buf = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, buf);
                }
            }
        }
    }

    private void sortFromName(ArrayList<Person> arrayList) {
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (!(compareNameAtTheSameAge(arrayList.get(i), arrayList.get(i + 1)))) {
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
    public List<Person> getSortedList(List<Person> array) {
        startTime = System.nanoTime();

        sortFromSex(array);
        sortFromAge(man);
        sortFromName(man);
        sortFromAge(woman);
        sortFromName(woman);

        List<Person> list = new ArrayList<>(man);
        list.addAll(woman);

        endTime = System.nanoTime();
        return list;
    }
}
