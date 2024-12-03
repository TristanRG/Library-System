package Operations;

import Elements.AbstractElem;
import Elements.Membru;
import java.util.LinkedList;
import java.util.Queue;

public class Retinere {
    private AbstractElem element;
    private Queue<Membru> listaDeAsteptare;

    public Retinere(AbstractElem element) {
        this.element = element;
        this.listaDeAsteptare = new LinkedList<>();
    }

    public void adaugaMembru(Membru membru) {
        listaDeAsteptare.add(membru);
        element.adaugaRetinere();
    }

    public Membru obtineUrmatorulMembru() {
        Membru urmator = listaDeAsteptare.poll();
        if (urmator != null) {
            element.scadeRetinere();
        }
        return urmator;
    }

    public boolean areRetineri() {
        return !listaDeAsteptare.isEmpty();
    }

    public void anuleazaRetinere(Membru membru) {
        listaDeAsteptare.remove(membru);
        element.scadeRetinere();
    }


    public AbstractElem getElement() {
        return element;
    }
}
