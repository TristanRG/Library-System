package Elements;

import Interface.IAbstractElemVisitor;
import Interface.IComparare;
import Visitors.NormalDisplayVisitor;

public abstract class AbstractElem implements IComparare<String> {
    protected int id;
    protected String titlu;
    protected int retineri;
    protected boolean imprumutata;

    public AbstractElem(int id, String titlu) {
        this.id = id;
        this.titlu = titlu;
        this.retineri = 0;
        this.imprumutata = false;
    }

    public String getTitlu() {
        return titlu;
    }

    public int getId() {
        return id;
    }

    public int getRetineri() {
        return retineri;
    }

    public boolean isImprumutat() {
        return imprumutata;
    }

    public void imprumutaElemente() {
        imprumutata = true;
    }

    public void returneazaElement() {
        imprumutata = false;
    }

    public void adaugaRetinere() {
        retineri++;
    }

    public void scadeRetinere() {
        if (retineri > 0) {
            retineri--;
        }
    }

    @Override
    public boolean compara(String otherId) {
        return String.valueOf(this.id).equals(otherId);
    }

    public abstract void Accept(IAbstractElemVisitor visitor);
    @Override
    public String toString() {
        NormalDisplayVisitor visitor = new NormalDisplayVisitor();
        this.Accept(visitor);
        return visitor.getResult();
    }
}

