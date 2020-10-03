package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

public class CompareNameAtTheSameAge implements MyCompare {
    @Override
    public boolean myCompare(Person person1, Person person2) {
        boolean result = false;
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
                    result = true;
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
