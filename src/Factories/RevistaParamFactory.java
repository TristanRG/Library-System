package Factories;

import Elements.AbstractElem;
import Elements.Revista;

import java.util.Scanner;

public class RevistaParamFactory extends ParamFactory {
    private int numar;

    @Override
    protected void initializeSpecificParams(Scanner scanner) {
        System.out.println("Introdu numarul revistei: ");
        numar = scanner.nextInt();
    }

    @Override
    public AbstractElem createElem() {
        return new Revista(id, titlu, numar);
    }
}
