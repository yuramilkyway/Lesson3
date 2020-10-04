package ru.innopolis.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

    private void personMenu() throws IOException {
        int key;
        do {
            printPersonMenu();
            int countPerson;
            key = this.scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.println("\nВведите количество Person.");
                    countPerson = this.scanner.nextInt();
                    persons = new GeneratorPerson(countPerson).getArray();
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
                        MethodOfSortDecorator methodOfSortDecorator = new MethodOfSortDecorator(sortPersons);
                        persons = methodOfSortDecorator.getSortedList(oldPersons);
                        System.out.println("\nВремя работы программы: " + (methodOfSortDecorator.getSortExecutionTime()) + " секунд.");
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

    public void start() throws IOException {
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