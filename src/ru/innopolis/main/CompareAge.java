package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

public class CompareAge implements MyCompare {
    @Override
    public boolean myCompare(Person person1, Person person2) {
        return person1.getAge() < person2.getAge();
    }
}
