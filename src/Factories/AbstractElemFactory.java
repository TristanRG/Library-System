package Factories;

import Elements.AbstractElem;

public class AbstractElemFactory {
    public static final int CARTE = 1;
    public static final int CARTE_SALA = 2;
    public static final int CARTE_SALA_TAXA = 3;
    public static final int CARTE_TAXA = 4;
    public static final int REVISTA = 5;
    public static final int REVISTA_SALA = 6;
    public static final int REVISTA_SALA_TAXA = 7;
    public static final int REVISTA_TAXA = 8;

    private static AbstractElemFactory singleton;

    private AbstractElemFactory() {}

    public static AbstractElemFactory Instance() {
        if (singleton == null) {
            singleton = new AbstractElemFactory();
        }
        return singleton;
    }

    public AbstractElem CreazaElemConcret(ParamFactory factory) {
        return factory.createElem();
    }
}
