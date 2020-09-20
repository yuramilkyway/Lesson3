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

    private boolean compareAge(Person person1, Person person2) {
        return person1.getAge() < person2.getAge();
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

    private boolean compareNameAtTheSameAge(Person person1, Person person2) {
        boolean result = true;
        if (person1.getAge() == person2.getAge()) {
            try {
                if(!(person1.getName().equals(person2.getName()))) {
                    throw new DuplicatePersonException(person1);
                }
            } catch (DuplicatePersonException e) {
                System.out.println(e.getMessage());
            }
            char[] nameAtIndexI = person1.getName().toCharArray();
            char[] nameAtIndexNextI = person2.getName().toCharArray();

            int temp = nameAtIndexI.length;
            if (nameAtIndexI.length > nameAtIndexNextI.length)
                temp = nameAtIndexNextI.length;

            int j = 0;
            while (true){
                if ((nameAtIndexI[j] == nameAtIndexNextI[j]) && (j != temp - 1)) {
                    j++;
                }
                else if (nameAtIndexI[j] > nameAtIndexNextI[j]) {
                    result = false;
                    break;
                }
                else {
                    break;
                }
            }
        }
        return result;
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
