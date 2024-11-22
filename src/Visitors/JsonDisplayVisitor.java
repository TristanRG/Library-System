package Visitors;

import Elements.Carte;
import Elements.Revista;
import Interface.IAbstractElemVisitor;

public class JsonDisplayVisitor implements IAbstractElemVisitor {
    @Override
    public void Visit(Carte carte) {
        System.out.println("{");
        System.out.println("  \"type\": \"Carte\",");
        System.out.println("  \"id\": " + carte.getId() + ",");
        System.out.println("  \"titlu\": \"" + carte.getTitlu() + "\",");
        System.out.println("  \"autor\": \"" + carte.getAutor() + "\",");
        System.out.println("  \"retineri\": " + carte.getRetineri() + ",");
        System.out.println("  \"imprumutata\": " + (carte.isImprumutata() ? "true" : "false"));
        System.out.println("}");
    }

    @Override
    public void Visit(Revista revista) {
        System.out.println("{");
        System.out.println("  \"type\": \"Revista\",");
        System.out.println("  \"id\": " + revista.getId() + ",");
        System.out.println("  \"titlu\": \"" + revista.getTitlu() + "\",");
        System.out.println("  \"numar\": " + revista.getNumar() + ",");
        System.out.println("  \"retineri\": " + revista.getRetineri() + ",");
        System.out.println("  \"imprumutata\": " + (revista.isImprumutata() ? "true" : "false"));
        System.out.println("}");
    }
}
