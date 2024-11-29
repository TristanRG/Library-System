package Visitors;

import Elements.Carte;
import Elements.Revista;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;

import Interface.IAbstractElemVisitor;

public class FormatAfisare implements IAbstractElemVisitor {
    @Override
    public void Visit(Carte carte) {
        System.out.println("Carte: ID=" + carte.getId() + ", Titlu=" + carte.getTitlu() + ", Autor=" + carte.getAutor() +
                ", Imprumutata=" + (carte.isImprumutata() ? "Da" : "Nu") +
                ", Retineri=" + carte.getRetineri());
    }

    @Override
    public void Visit(Revista revista) {
        System.out.println("Revista: ID=" + revista.getId() + ", Titlu=" + revista.getTitlu() +
                ", Numar=" + revista.getNumar() +
                ", Imprumutata=" + (revista.isImprumutata() ? "Da" : "Nu") +
                ", Retineri=" + revista.getRetineri());
    }

    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        System.out.println("Element Decorat cu Taxa:");
        System.out.println("  Taxa: " + elemCuTaxa.getTaxa() + " RON");
        System.out.println("  Informatii Element Decorat:");
        elemCuTaxa.getDecorat().Accept(this);
    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        System.out.println("Element Decorat in Sala:");
        System.out.println("  Disponibil doar pentru sala de lectura.");
        System.out.println("  Informatii Element Decorat:");
        elemInSala.getDecorat().Accept(this);
    }
}
