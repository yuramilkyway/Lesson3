package ru.innopolis.library.menu;

import ru.innopolis.library.person.GeneratorPerson;
import ru.innopolis.library.person.Person;
import ru.innopolis.library.sorts.BubbleSort;
import ru.innopolis.library.sorts.ShakerSort;
import ru.innopolis.library.sorts.SortPersons;
import ru.innopolis.library.sorts.TimeMeasurementDecorator;

import java.util.List;
import java.util.Scanner;

/**
 * Консольное меню проекта.
 * Дает возможнсоть запуска генерации объектов person и их сортировку.
 */
public class CaseMenu {
    private final Scanner scanner;
    private List<Person> persons;


    public CaseMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("\n1. Перейти в меню Person;");
        System.out.println("2. Перейти в меню сортировки Person с помощью Bubble Sort;");
        System.out.println("3. Перейти в меню сортировки Person с помощью Shaker Sort;");
        System.out.println("4. Выход из приложения.");
    }

    private void printPersonMenu() {
        System.out.println("\n1. Сгенерировать список Person");
        System.out.println("2. Вывести весь список Person;");
        System.out.println("3. Вернуться в прошлое меню.\n");
    }

    private void printSortMenu() {
        System.out.println("\n1. Отсортировать список Person;");
        System.out.println("2. Показать время работы алгоритма и отсортировать список;");
        System.out.println("3. Вернуться в прошлое меню.");
    }

    private void printIncorrectValueMessage() {
        System.out.println("\nВы ввели неверное значение меню...");
    }

    /**
     * Меню класса Person и GeneratePerson.
     * 1) Вызывает метод генерации Person.
     * 2) Выводит в консоль элементы списка Person.
     * 3) Возвращает в главное меню.
     * При невалидном вводе, выводит "заглушку".
     */
    private void personMenu() {
        int key;
        do {
            printPersonMenu();
            int countPerson;
            key = this.scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.println("\nВведите количество Person.");
                    countPerson = this.scanner.nextInt();
                    persons = (new GeneratorPerson(countPerson)).getListRandomPerson();
                    break;
                case 2:
                    System.out.println();
                    for (Person p : persons)
                        System.out.println(p.toString());
                    break;
                case 3:
                    break;
                default:
                    printIncorrectValueMessage();
                    break;
            }
        } while (key != 3);
    }

    /**
     * Меню сортировок.
     * 1) Вызывает сортировку списка Person.
     * 2) Вызывает сортировку списка Person с замером времени.
     * 3) Возвращает в главное меню.
     * При невалидном вводе, выводит "заглушку".
     * @param sortPersons Принимает вид сортировки, которая унаследуется от абстрактного класса SortPersons.
     */
    private void sortMenu(SortPersons sortPersons) {
        int key;
        List<Person> oldPersons = persons;
        do {
            printSortMenu();
            key = this.scanner.nextInt();
            switch (key) {
                case 1:
                    persons = sortPersons.getSortedList(oldPersons);
                    break;
                case 2:
                    try {
                        TimeMeasurementDecorator timeMeasurementDecorator = new TimeMeasurementDecorator(sortPersons);
                        persons = timeMeasurementDecorator.getSortedList(oldPersons);
                        System.out.println("\nВремя работы программы: " + (timeMeasurementDecorator.getSortExecutionTime()) + " секунд.");
                    } catch (NullPointerException e) {
                        System.out.println("Сортировка не запускалась.");
                    }
                    break;
                case 3:
                    break;
                default:
                    printIncorrectValueMessage();
                    break;
            }
        } while (key != 3);
    }

    /**
     * Метод запуска консольного меню.
     * 1) Переход в меню классов Person и GeneratePerson
     * 2) Переход в меню сорировки с Bubble сортировокой.
     * 3) Переход в меню сорировки с Shaker сортировокой.
     * 4) Завершение программы.
     * При невалидном вводе, выводит "заглушку".
     */
    public void start() {
        if (this.scanner != null) {
            int key;
            do {
                printMenu();
                System.out.print("\nВведите номер меню: ");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        personMenu();
                        break;
                    case 2:
                        sortMenu(new BubbleSort());
                        break;
                    case 3:
                        sortMenu(new ShakerSort());
                        break;
                    case 4:
                        System.out.println("\nЗавершение программы...");
                        break;
                    default:
                        System.out.println("\nВы ввели неверное значение меню...");
                }
            } while (key != 4);
        }
    }
}