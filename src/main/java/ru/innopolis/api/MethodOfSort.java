package ru.innopolis.api;

import ru.innopolis.library.exception.DuplicatePersonException;
import ru.innopolis.library.person.Person;

import java.util.List;

public interface MethodOfSort {
    List<Person> getSortedList(List<Person> incomingList) throws DuplicatePersonException;
}
