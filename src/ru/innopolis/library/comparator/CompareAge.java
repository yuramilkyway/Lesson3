package ru.innopolis.library.comparator;

import ru.innopolis.api.MyCompare;
import ru.innopolis.library.person.Person;

public class CompareAge implements MyCompare {

    /**
     * Сравнивает age двух объектов.
     * @param obj1 Person1
     * @param obj2 Person2
     * @return Меньше ли возраст первого объекта или нет.
     */
    @Override
    public boolean compareTwoObjects(Object obj1, Object obj2) {
        Person person1 = (Person) obj1;
        Person person2 = (Person) obj2;
        return person1.getAge() < person2.getAge();
    }
}
