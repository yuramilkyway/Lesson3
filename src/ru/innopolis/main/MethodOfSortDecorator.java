package ru.innopolis.main;

import ru.innopolis.api.MethodOfSort;

import java.util.List;

public class MethodOfSortDecorator implements MethodOfSort {
    private double timeSpentSolving = 0;
    SortPersons sortPersons;

    MethodOfSortDecorator(SortPersons sortPersons) {
        this.sortPersons = sortPersons;
    }
    public double getSortExecutionTime() {
        return timeSpentSolving;
    }

    private void setSortExecutionTime(double startTime, double finishTime) {
        double NANO_SECONDS_TO_SECONDS = 1_000_000_000.0;
        this.timeSpentSolving = (finishTime - startTime) / NANO_SECONDS_TO_SECONDS;
    }

    @Override
    public List<Person> getSortedList(List<Person> incomingList) {
        double startTime = System.nanoTime();
        incomingList = sortPersons.startAlgorithm(incomingList);
        setSortExecutionTime(startTime, System.nanoTime());

        return incomingList;
    }
}
