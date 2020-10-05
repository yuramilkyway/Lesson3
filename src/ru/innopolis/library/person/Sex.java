package ru.innopolis.library.person;

import java.util.List;
import java.util.Random;

public enum Sex {
    MAN,
    WOMAN;

    private static final List<Sex> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Sex getRandomGender()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public boolean isMan(Sex sex) {
        return (sex == MAN);
    }
    /*final private String sex;

    public Sex(int b) {
        if (b == 1) {
            this.sex = "MAN";
        }
        else {
            this.sex = "WOMAN";
        }
    }
    public String getSex() {
        return sex;
    }

    public boolean isMan(Sex sex) {
        return sex.getSex().equals("MAN");
    }*/
}
