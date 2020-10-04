package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.api.MyCompare;

import java.util.ArrayList;
import java.util.List;

public abstract class SortPersons implements MethodOfSort {
    private final double NANO_SECONDS_TO_SECONDS = 1_000_000_000.0;
    private double timeSpentSolving = 0;

    public double getSortExecutionTime() {
        return timeSpentSolving;
    }

    private void setSortExecutionTime(double startTime, double finishTime) {
        this.timeSpentSolving = (finishTime - startTime) / NANO_SECONDS_TO_SECONDS;
    }

    protected void sort(List<Person> arrayList, MyCompare o) {

    }

    protected void sortFromSex(List<Person> persons, List<Person> means, List<Person> women) {
        for (Person person : persons) {
            if (person.getSex().equals("MAN")) {
                means.add(person);
            } else {
                women.add(person);
            }
        }
    }

    private List<Person> startAlgorithm(List<Person> incomingList) {

        double startTime = System.nanoTime();
        List<Person> means = new ArrayList<>();
        List<Person> women = new ArrayList<>();

        sortFromSex(incomingList, means, women);
        sort(means, new CompareAge());
        sort(means, new CompareNameAtTheSameAge());
        sort(women, new CompareAge());
        sort(women, new CompareNameAtTheSameAge());

        List<Person> outgoingList = new ArrayList<>(means);
        outgoingList.addAll(women);

        setSortExecutionTime(startTime, System.nanoTime());

        return outgoingList;
    }

    @Override
    public List<Person> getSortedList(List<Person> incomingList) {
        return startAlgorithm(incomingList);
    }
}
