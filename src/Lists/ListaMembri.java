package Lists;

import Interface.IComparare;
import Elements.Membru;

public class ListaMembri {
    private static ListaMembri singleton;

    private ListaMembri() {}

    public static ListaMembri getInstance() {
        if (singleton == null) {
            singleton = new ListaMembri();
        }
        return singleton;
    }

    public void adaugaMembru(Membru membru, ElemList<IComparare<String>, String> lista) {
        lista.add(membru);
    }

    public Membru cautaMembru(String id, ElemList<IComparare<String>, String> lista) {
        return (Membru) lista.search(id);
    }

    public boolean stergeMembru(String id, ElemList<IComparare<String>, String> lista) {
        return lista.remove(id);
    }
}
