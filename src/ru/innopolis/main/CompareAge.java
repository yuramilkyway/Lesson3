package ru.innopolis.main;

import ru.innopolis.api.MyCompaer;

public class CompareAge implements MyCompaer {
    @Override
    public boolean myCompare(Person person1, Person person2) {
        return person1.getAge() < person2.getAge();
    }
}
