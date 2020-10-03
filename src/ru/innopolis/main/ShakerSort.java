package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

import java.util.List;

public class ShakerSort extends SortPersons {
    private long startTime;
    private long endTime;

    protected void sort(List<Person> arrayList, MyCompare myCompare) {
        Person buff;
        int left = 0;
        int right = arrayList.size() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (myCompare.compareTwoObjects(arrayList.get(i), arrayList.get(i + 1))) {
                    buff = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, buff);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (myCompare.compareTwoObjects(arrayList.get(i - 1), arrayList.get(i))) {
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
}
