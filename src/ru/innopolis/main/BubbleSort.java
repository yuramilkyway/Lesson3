package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements MethodOfSort {
    private final ArrayList<Person> woman = new ArrayList<>();
    private final ArrayList<Person> man = new ArrayList<>();

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
                if(arrayList.get(i).getAge() < arrayList.get(i + 1).getAge()){
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
                if (arrayList.get(i).getAge() == arrayList.get(i + 1).getAge()) {

                    try {
                        if(!(arrayList.get(i).getName().equals(arrayList.get(i + 1).getName()))) {
                            throw new DuplicatePersonException(arrayList.get(i));
                        }
                    } catch (DuplicatePersonException e) {
                        System.out.println(e.getMessage());
                    }
                    char[] str1 = arrayList.get(i).getName().toCharArray();
                    char[] str2 = arrayList.get(i + 1).getName().toCharArray();

                    int temp = str1.length;
                    if (str1.length > str2.length)
                        temp = str2.length;

                    int j = 0;
                    while (true){
                        if ((str1[j] == str2[j]) && (j != temp - 1)) {
                            j++;
                        }
                        else if (str1[j] > str2[j]) {
                            isSorted = false;

                            buf = arrayList.get(i);
                            arrayList.set(i, arrayList.get(i + 1));
                            arrayList.set(i + 1, buf);
                            break;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Person> getSortedList(Person[] array) throws DuplicatePersonException {
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
