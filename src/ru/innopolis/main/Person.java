package ru.innopolis.main;
import java.io.*;
import java.util.List;

public class Person {
    final private int age;
    final private Sex sex;
    final private String name;
    final private File fileWithMaleNames = new File("man.txt");
    final private File fileWithFemaleNames = new File("woman.txt");

    public Person(int age, Sex sex) throws IOException {
        this.age = age;
        this.sex = sex;
        this.name = createName(sex);
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex.getSex();
    }

    public String getName() {
        return name;
    }

    private String createName(Sex sex) throws IOException {
        File file;
        int upperBound;

        if (sex.thisMan(sex)) {
            file = fileWithMaleNames;
            upperBound = (int) (Math.random() * 615);
        }
        else {
            file = fileWithFemaleNames;
            upperBound = (int) (Math.random() * 725);
        }

        BufferedReader r = new BufferedReader(new FileReader(file));
        for (int i = 0; i < upperBound; i++)
        {
            r.readLine();
        }
        return r.readLine();
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Sex: %s, Age: %d;", name, sex.getSex(), age);
    }
}
