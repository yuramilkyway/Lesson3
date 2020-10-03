package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

public class CompareAge implements MyCompare {
    @Override
    public boolean myCompare(Object obj1, Object obj2) {
        Person person1 = (Person) obj1;
        Person person2 = (Person) obj2;
        return person1.getAge() < person2.getAge();
    }
}
