package ru.innopolis.library.exception;

import ru.innopolis.library.person.Person;

public class DuplicatePersonException extends Exception {
    public DuplicatePersonException(Person person) {

        super("Найден дубликат: " + person);
    }
}
