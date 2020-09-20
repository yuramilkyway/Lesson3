package ru.innopolis.api;

import ru.innopolis.main.DuplicatePersonException;
import ru.innopolis.main.Person;

import java.util.List;

public interface MethodOfSort {
    List<Person> getSortedList(List<Person> array) throws DuplicatePersonException;

    default boolean compareAge(Person person1, Person person2) {
        return person1.getAge() < person2.getAge();
    }

    default boolean compareNameAtTheSameAge(Person person1, Person person2) {
        boolean result = true;
        if (person1.getAge() == person2.getAge()) {
            try {
                if(!(person1.getName().equals(person2.getName()))) {
                    throw new DuplicatePersonException(person1);
                }
            } catch (DuplicatePersonException e) {
                System.out.println(e.getMessage());
            }
            char[] nameAtIndexI = person1.getName().toCharArray();
            char[] nameAtIndexNextI = person2.getName().toCharArray();

            int temp = nameAtIndexI.length;
            if (nameAtIndexI.length > nameAtIndexNextI.length)
                temp = nameAtIndexNextI.length;

            int j = 0;
            while (true){
                if ((nameAtIndexI[j] == nameAtIndexNextI[j]) && (j != temp - 1)) {
                    j++;
                }
                else if (nameAtIndexI[j] > nameAtIndexNextI[j]) {
                    result = false;
                    break;
                }
                else {
                    break;
                }
            }
        }
        return result;
    }
}
