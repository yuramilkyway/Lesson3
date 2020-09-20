package ru.innopolis.api;

import ru.innopolis.main.DuplicatePersonException;
import ru.innopolis.main.Person;

import java.util.ArrayList;
import java.util.List;

public interface MethodOfSort {
    List<Person> getSortedList(List<Person> array) throws DuplicatePersonException;

}
