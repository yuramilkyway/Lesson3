package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

import java.util.List;

public class BubbleSort extends SortPersons {
    private long startTime;
    private long endTime;

    protected void sort(List<Person> arrayList, MyCompare o) {
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (o.compareTwoObjects(arrayList.get(i), arrayList.get(i + 1))) {
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

}
