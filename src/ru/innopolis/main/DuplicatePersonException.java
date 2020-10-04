package ru.innopolis.main;

public class DuplicatePersonException extends Exception {
    public DuplicatePersonException(Person person) {
        super("Найден дубликат: " + person);
    }
}
