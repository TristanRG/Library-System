package Factories;

import Elements.AbstractElem;

public abstract class ParamFactory {
    protected int id;
    protected String titlu;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public abstract AbstractElem createElem();
}
