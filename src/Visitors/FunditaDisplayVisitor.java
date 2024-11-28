package Visitors;

import Elements.Carte;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

public class FunditaDisplayVisitor implements IAbstractElemVisitor {
    @Override
    public void Visit(Carte carte) {
        System.out.println("🎀 ID = " + carte.getId() +
                " 🎀 Titlu = " + carte.getTitlu() +
                " 🎀 Autor = " + carte.getAutor() +
                " 🎀 Retineri = " + carte.getRetineri() +
                " 🎀 Imprumutata = " + (carte.isImprumutata() ? "Da 🎀" : "Nu 🎀"));
    }

    @Override
    public void Visit(Revista revista) {
        System.out.println("🎀 ID = " + revista.getId() +
                " 🎀 Titlu = " + revista.getTitlu() +
                " 🎀 Numar = " + revista.getNumar() +
                " 🎀 Retineri = " + revista.getRetineri() +
                " 🎀 Imprumutata = " + (revista.isImprumutata() ? "Da 🎀" : "Nu 🎀"));
    }

    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        System.out.println("🎀Element Decorat cu Taxa: " +
                " 🎀 Taxa=" + elemCuTaxa.getTaxa() + ", " +
                " 🎀 Informatii Element Decorat: ");

    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        System.out.println("🎀Element Decorat in Sala: " +
                " 🎀 Elementul este in sala=" + ", " +
                " 🎀 Informatii Element Decorat: ");
    }
}
