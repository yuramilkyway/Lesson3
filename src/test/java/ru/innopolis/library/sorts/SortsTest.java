package ru.innopolis.library.sorts;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.innopolis.library.person.Person;
import ru.innopolis.library.person.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SortsTest {

    private final SortsFactory.SortsType type;
    private SortPersons sorter;
    private List<Person> original;
    private List<Person> correct;

    public SortsTest(SortsFactory.SortsType type) {
        this.type = type;
    }

    @Before
    public void setUp() {
        sorter = SortsFactory.getSorter(type);
        original = new ArrayList<>();
        original.add(new Person(14, Sex.MAN, "Валера"));
        original.add(new Person(20, Sex.MAN, "Валера"));
        original.add(new Person(20, Sex.WOMAN, "Валя"));
        original.add(new Person(20, Sex.MAN, "Алексей"));
        original.add(new Person(20, Sex.MAN, "Ян"));

        correct = new ArrayList<>();
        correct.add(new Person(20, Sex.MAN, "Алексей"));
        correct.add(new Person(20, Sex.MAN, "Валера"));
        correct.add(new Person(20, Sex.MAN, "Ян"));
        correct.add(new Person(14, Sex.MAN, "Валера"));
        correct.add(new Person(20, Sex.WOMAN, "Валя"));
    }

    @Parameterized.Parameters
    public static Collection<SortsFactory.SortsType> sortsToBeTested() {
        return Arrays.asList(SortsFactory.SortsType.BUBBLE,
                SortsFactory.SortsType.SHAKE);
    }

    @Test
    public void sort() {
        List<Person> sorted = sorter.getSortedList(original);
        Assert.assertEquals(correct.size(), sorted.size());
        for (int i = 0; i < correct.size(); i++) {
            Assert.assertEquals(correct.get(i),sorted.get(i));

        }
    }

}