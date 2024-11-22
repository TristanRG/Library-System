package Factories;

import Elements.AbstractElem;
import Elements.Carte;

import java.util.Scanner;

public class CarteParamFactory extends ParamFactory {
    private String autor;

    @Override
    protected void initializeSpecificParams(Scanner scanner) {
        System.out.println("Introdu autorul cartii: ");
        autor = scanner.nextLine();
    }

    @Override
    public AbstractElem createElem() {
        return new Carte(id, titlu, autor);
    }
}
