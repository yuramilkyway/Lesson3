package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements MethodOfSort {
    private ArrayList<Person> woman = new ArrayList<>();
    private ArrayList<Person> man = new ArrayList<>();

    private void sortFromSex(Person[] array) {
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
                if(arrayList.get(i).getAge() > arrayList.get(i).getAge()){
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
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                char[] str1 = arrayList.get(i).getName().toCharArray();
                char[] str2 = arrayList.get(i).getName().toCharArray();
                for (int j = 0; j < str1.length - 1; j++) {
                    if (str1[j] > str2[j]) {
                        isSorted = false;

                        buf = arrayList.get(i);
                        arrayList.set(i, arrayList.get(i + 1));
                        arrayList.set(i + 1, buf);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public List<Person> getSortedList(Person[] array) {
        sortFromSex(array);
        sortFromAge(man);
        sortFromName(man);
        sortFromAge(woman);
        sortFromName(woman);

        List<Person> list = new ArrayList<>(man);
        list.addAll(woman);
        return list;
    }
}
