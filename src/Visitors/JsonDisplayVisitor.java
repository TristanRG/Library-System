package Visitors;

import Elements.Carte;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

import java.util.HashSet;
import java.util.Set;

public class JsonDisplayVisitor implements IAbstractElemVisitor {
    private Set<Object> visited = new HashSet<>();

    @Override
    public void Visit(Carte carte) {
        if (visited.contains(carte)) return;
        visited.add(carte);
        System.out.println("{");
        System.out.println("  \"type\": \"Carte\",");
        System.out.println("  \"id\": " + carte.getId() + ",");
        System.out.println("  \"titlu\": \"" + carte.getTitlu() + "\",");
        System.out.println("  \"autor\": \"" + carte.getAutor() + "\",");
        System.out.println("  \"retineri\": " + carte.getRetineri() + ",");
        System.out.println("  \"imprumutata\": " + (carte.isImprumutat() ? "true" : "false"));
        System.out.println("}");
    }

    @Override
    public void Visit(Revista revista) {
        if (visited.contains(revista)) return;
        visited.add(revista);
        System.out.println("{");
        System.out.println("  \"type\": \"Revista\",");
        System.out.println("  \"id\": " + revista.getId() + ",");
        System.out.println("  \"titlu\": \"" + revista.getTitlu() + "\",");
        System.out.println("  \"numar\": " + revista.getNumar() + ",");
        System.out.println("  \"retineri\": " + revista.getRetineri() + ",");
        System.out.println("  \"imprumutata\": " + (revista.isImprumutat() ? "true" : "false"));
        System.out.println("}");
    }


    @Override
    public void Visit(ElemCuTaxa elemCuTaxa) {
        if (visited.contains(elemCuTaxa)) return;
        visited.add(elemCuTaxa);

        System.out.println("{");
        System.out.println("  \"type\": \"ElemCuTaxa\",");
        System.out.println("  \"taxa\": " + elemCuTaxa.getTaxa() + ",");
        System.out.println("  \"element_decorat\": ");
        elemCuTaxa.getDecorat().Accept(this);
        System.out.println("}");
    }

    @Override
    public void Visit(ElemInSala elemInSala) {
        if (visited.contains(elemInSala)) return;
        visited.add(elemInSala);

        System.out.println("{");
        System.out.println("  \"type\": \"ElemInSala\",");
        System.out.println("  \"in_sala\": true,");
        System.out.println("  \"element_decorat\": ");
        elemInSala.getDecorat().Accept(this);
        System.out.println("}");
    }
}
