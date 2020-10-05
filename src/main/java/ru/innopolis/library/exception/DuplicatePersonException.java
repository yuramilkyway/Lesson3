package ru.innopolis.library.exception;

import ru.innopolis.library.person.Person;

public class DuplicatePersonException extends Exception {

    /**
     * Исключение для одинаковых объектов person.
     * @param person Дублирующийся person.
     */
    public DuplicatePersonException(Person person) {
        super("Найден дубликат: " + person);
    }
}
