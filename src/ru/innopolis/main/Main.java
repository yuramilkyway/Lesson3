package ru.innopolis.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new CaseMenu(scanner).start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
