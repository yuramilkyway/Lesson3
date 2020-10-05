package ru.innopolis.library.sorts;

public class SortsFactory {
    public enum SortsType {
        BUBBLE,
        SHAKE
    }
    public static SortPersons getSorter(SortsType type) {
        if (type == SortsType.BUBBLE) {
            return new BubbleSort();
        } else {
            return new ShakerSort();
        }
    }
}
