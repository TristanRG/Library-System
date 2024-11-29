package Visitors;

import Elements.AbstractElem;
import Elements.Carte;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

import java.util.HashSet;
import java.util.Set;

public class NormalDisplayVisitor implements IAbstractElemVisitor {
    private Set<Object> visited = new HashSet<>();
    private StringBuilder result = new StringBuilder();

    @Override
    public void Visit(Carte carte) {
        if (visited.contains(carte)) return;
        visited.add(carte);
        String output = "Carte: ID = " + carte.getId() +
                ", Titlu = " + carte.getTitlu() +
                ", Autor = " + carte.getAutor() +
                ", Retineri = " + carte.getRetineri() +
                ", Imprumutata = " + (carte.isImprumutata() ? "Da" : "Nu");
        System.out.println(output);
        result.append(output).append("\n");
    }

    @Override
    public void Visit(Revista revista) {
        if (visited.contains(revista)) return;
        visited.add(revista);
        String output = "Revista: ID = " + revista.getId() +
                ", Titlu = " + revista.getTitlu() +
                ", Numar = " + revista.getNumar() +
                ", Retineri = " + revista.getRetineri() +
                ", Imprumutata = " + (revista.isImprumutata() ? "Da" : "Nu");
        System.out.println(output);
        result.append(output).append("\n");
    }

    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        if (visited.contains(elemCuTaxa)) return;
        visited.add(elemCuTaxa);
        String output = "Taxa: " + elemCuTaxa.getTaxa() + " RON";
        System.out.println(output);
        result.append(output).append("\n");
        elemCuTaxa.getDecorat().Accept(this);
    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        if (visited.contains(elemInSala)) return;
        visited.add(elemInSala);
        String output = "Disponibil doar pentru sala de lectura.";
        System.out.println(output);
        result.append(output).append("\n");
        elemInSala.getDecorat().Accept(this);
    }

    public String getResult() {
        return result.toString();
    }
}
