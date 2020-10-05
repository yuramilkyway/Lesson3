package ru.innopolis.library.person;

import java.util.List;
import java.util.Random;

public enum Sex {
    MAN,
    WOMAN;

    private static final List<Sex> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * Возвращает рандомно выбранный элемент enum Sex.
     * @return элемент enum-а Sex
     */
    public static Sex getRandomGender()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public boolean isMan(Sex sex) {
        return (sex == MAN);
    }
}
