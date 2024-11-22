package Visitors;

import Elements.Carte;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

public class FormatAfisare implements IAbstractElemVisitor {
    @Override
    public void Visit(Carte carte) {
        System.out.println("Elements.Carte: ID=" + carte.getId() + ", Titlu=" + carte.getTitlu() + ", Autor=" + carte.getAutor() +
                ", Imprumutata=" + (carte.isImprumutata() ? "Da" : "Nu") +
                ", Retineri=" + carte.getRetineri());
    }

    @Override
    public void Visit(Revista revista) {
        System.out.println("Elements.Revista: ID=" + revista.getId() + ", Titlu=" + revista.getTitlu() +
                ", Numar=" + revista.getNumar() +
                ", Imprumutata=" + (revista.isImprumutata() ? "Da" : "Nu") +
                ", Retineri=" + revista.getRetineri());
    }
}
