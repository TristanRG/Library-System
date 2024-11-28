package Visitors;

import Elements.Carte;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

public class NormalDisplayVisitor implements IAbstractElemVisitor {
    private StringBuilder result = new StringBuilder();

    @Override
    public void Visit(Carte carte) {
        System.out.println("Carte: ID = " + carte.getId() +
                ", Titlu = " + carte.getTitlu() +
                ", Autor = " + carte.getAutor() +
                ", Retineri = " + carte.getRetineri() +
                ", Imprumutata = " + (carte.isImprumutata() ? "Da" : "Nu"));
    }

    @Override
    public void Visit(Revista revista) {
        System.out.println("Revista: ID = " + revista.getId() +
                ", Titlu = " + revista.getTitlu() +
                ", Numar = " + revista.getNumar() +
                ", Retineri = " + revista.getRetineri() +
                ", Imprumutata = " + (revista.isImprumutata() ? "Da" : "Nu"));
    }

    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        result.append(" (Taxa: ").append(elemCuTaxa.getTaxa()).append(" RON)");
    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        result.append(" (Doar pentru sala de lectura)");
    }

    public String getResult() {
        return result.toString();
    }
}
