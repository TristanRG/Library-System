package Factories;

import Elements.AbstractElem;

public class AbstractElemFactory {
    public static final int CARTE = 1;
    public static final int REVISTA = 2;

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
