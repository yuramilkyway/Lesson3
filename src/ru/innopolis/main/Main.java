package ru.innopolis.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DuplicatePersonException {
        new CaseMenu(new Scanner(System.in)).start();

    }
}
