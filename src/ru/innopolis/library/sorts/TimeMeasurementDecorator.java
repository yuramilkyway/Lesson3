package ru.innopolis.library.sorts;

import ru.innopolis.api.MethodOfSort;
import ru.innopolis.library.person.Person;

import java.util.List;

public class TimeMeasurementDecorator implements MethodOfSort {
    private double timeSpentSolving = 0;
    SortPersons sortPersons;

    public TimeMeasurementDecorator(SortPersons sortPersons) {
        this.sortPersons = sortPersons;
    }
    public double getSortExecutionTime() {
        return timeSpentSolving;
    }

    private void setSortExecutionTime(double startTime, double finishTime) {
        final double NANO_SECONDS_TO_SECONDS = 1_000_000_000.0;
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
