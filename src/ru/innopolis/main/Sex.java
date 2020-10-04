package ru.innopolis.main;

public class Sex {
    final private String sex;

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
    }
}
