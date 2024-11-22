package Factories;

import Elements.AbstractElem;

import java.util.Scanner;

public abstract class ParamFactory {
    protected int id;
    protected String titlu;

    public void initializeParams(Scanner scanner) {
        System.out.println("Introdu ID-ul elementului: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introdu titlul elementului: ");
        titlu = scanner.nextLine();

        initializeSpecificParams(scanner);
    }

    protected abstract void initializeSpecificParams(Scanner scanner);
    public abstract AbstractElem createElem();
}
