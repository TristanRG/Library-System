package Visitors;

import Elements.Carte;
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
}
