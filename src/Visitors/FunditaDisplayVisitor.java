package Visitors;

import Elements.Carte;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

import java.util.HashSet;
import java.util.Set;

public class FunditaDisplayVisitor implements IAbstractElemVisitor {
    private Set<Object> visited = new HashSet<>();

    @Override
    public void Visit(Carte carte) {
        if (visited.contains(carte)) return;
        visited.add(carte);
        System.out.println("🎀 ID = " + carte.getId() +
                " 🎀 Titlu = " + carte.getTitlu() +
                " 🎀 Autor = " + carte.getAutor() +
                " 🎀 Retineri = " + carte.getRetineri() +
                " 🎀 Imprumutata = " + (carte.isImprumutata() ? "Da 🎀" : "Nu 🎀"));
    }

    @Override
    public void Visit(Revista revista) {
        if (visited.contains(revista)) return;
        visited.add(revista);
        System.out.println("🎀 ID = " + revista.getId() +
                " 🎀 Titlu = " + revista.getTitlu() +
                " 🎀 Numar = " + revista.getNumar() +
                " 🎀 Retineri = " + revista.getRetineri() +
                " 🎀 Imprumutata = " + (revista.isImprumutata() ? "Da 🎀" : "Nu 🎀"));
    }

    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        if (visited.contains(elemCuTaxa)) return;
        visited.add(elemCuTaxa);
        System.out.println("🎀Element Decorat cu Taxa: " +
                " 🎀 Taxa=" + elemCuTaxa.getTaxa());
        if (!(elemCuTaxa.getDecorat() instanceof ElemInSala)) {
            System.out.println(" 🎀 Informatii Element Decorat: ");
            elemCuTaxa.getDecorat().Accept(this);
        }
    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        if (visited.contains(elemInSala)) return;
        visited.add(elemInSala);
        System.out.println(" 🎀 Disponibil doar pentru sala de lectura.");
        if (!(elemInSala.getDecorat() instanceof ElemCuTaxa)) {
            System.out.println(" 🎀 Informatii Element Decorat: ");
            elemInSala.getDecorat().Accept(this);
        }
    }
}
