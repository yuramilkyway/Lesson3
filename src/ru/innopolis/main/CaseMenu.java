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
        System.out.println("2. Перейти в меню сортировки Person с помощью Bubble Sort");
        System.out.println("3. Перейти в меню сортировки Person с помощью Shaker Sort;");
        System.out.println("4. Выход из приложения;");
    }

    private void printPersonMenu() {
        System.out.println("\n1. Сгенерировать список Person");
        System.out.println("2. Вывести весь список Person;");
        System.out.println("3. Вернуться в прошлое меню\n");
    }

    private void printSortMenu() {
        System.out.println("\n1. Отсортировать список Person;");
        System.out.println("2. Показать время работы алгоритма");
        System.out.println("3. Вернуться в прошлое меню");
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

    private void bubbleSortMenu() {
        BubbleSort bubbleSort = null;
        int key;
        do {
            printSortMenu();
            key = this.scanner.nextInt();
            switch (key) {
                case 1:
                    bubbleSort = new BubbleSort();
                    persons = bubbleSort.getSortedList(persons);
                    break;
                case 2:
                    assert bubbleSort != null;
                    System.out.println("\nВремя работы программы: " + bubbleSort.getSortExecutionTime() + " секунд.");
                    break;
                case 3:
                    break;
                default:
                    printIncorrectValueMessage();
                    break;
            }
        } while (key != 3);
    }

    private void shakerSortMenu() {
        ShakerSort shakerSort = null;
        int key;
        do {
            printSortMenu();
            key = this.scanner.nextInt();
            switch (key) {
                case 1:
                    shakerSort = new ShakerSort();
                    persons = shakerSort.getSortedList(persons);
                    break;
                case 2:
                    assert shakerSort != null;
                    System.out.println("\nВремя работы программы: " + shakerSort.getSortExecutionTime() + " секунд.");
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
                    case 1 -> personMenu();
                    case 2 -> bubbleSortMenu();
                    case 3 -> shakerSortMenu();
                    case 4 -> System.out.println("\nЗавершение программы...");
                    default -> System.out.println("\nВы ввели неверное значение меню...");
                }
            } while (key != 4);
        }
    }
}