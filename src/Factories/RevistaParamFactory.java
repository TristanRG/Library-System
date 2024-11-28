package Factories;

import Elements.AbstractElem;
import Elements.Revista;

public class RevistaParamFactory extends ParamFactory {
    private int numar;

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public AbstractElem createElem() {
        return new Revista(id, titlu, numar);
    }
}
