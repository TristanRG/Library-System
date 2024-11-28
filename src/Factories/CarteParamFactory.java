package Factories;

import Elements.AbstractElem;
import Elements.Carte;

public class CarteParamFactory extends ParamFactory {
    private String autor;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public AbstractElem createElem() {
        return new Carte(id, titlu, autor);
    }
}
