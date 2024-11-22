package Elements;

import Interface.IComparare;
import Interface.IAbstractElemVisitor;

public class Carte extends AbstractElem implements IComparare<String> {
    private String autor;

    public Carte(int id, String titlu, String autor) {
        super(id, titlu);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
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
