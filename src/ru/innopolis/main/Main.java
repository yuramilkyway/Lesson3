package ru.innopolis.main;

import ru.innopolis.library.menu.CaseMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new CaseMenu(scanner).start();
        }
    }
}
