package Elements;

import Interface.IComparare;
import Interface.IAbstractElemVisitor;

public class Revista extends AbstractElem implements IComparare<String> {
    private int numar;

    public Revista(int id, String titlu, int numar) {
        super(id, titlu);
        this.numar = numar;
    }

    public int getNumar() {
        return numar;
    }

    @Override
    public boolean compara(String id) {
        return String.valueOf(this.id).equals(id);
    }

    @Override
    public void Accept(IAbstractElemVisitor visitor) {
        visitor.Visit(this);
    }
}
