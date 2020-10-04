package ru.innopolis.main;

import ru.innopolis.api.MyCompare;

public class CompareNameAtTheSameAge implements MyCompare {

    @Override
    public boolean compareTwoObjects(Object obj1, Object obj2) {
        final Person person1 = (Person) obj1;
        final Person person2 = (Person) obj2;

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
            if (nameAtIndexI.length > nameAtIndexNextI.length) {
                temp = nameAtIndexNextI.length;
            }

            int i = 0;
            while (true){
                if ((nameAtIndexI[i] == nameAtIndexNextI[i]) && (i != temp - 1)) {
                    i++;
                }
                else if (nameAtIndexI[i] > nameAtIndexNextI[i]) {
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
