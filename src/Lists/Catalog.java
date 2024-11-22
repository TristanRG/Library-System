package Lists;

import Interface.IComparare;

public class Catalog {
    private static Catalog singleton;

    private Catalog() {}

    public static Catalog getInstance() {
        if (singleton == null) {
            singleton = new Catalog();
        }
        return singleton;
    }

    public void adaugaElement(IComparare<String> element, ElemList<IComparare<String>, String> lista) {
        lista.add(element);
    }

    public IComparare<String> cautaElement(String id, ElemList<IComparare<String>, String> lista) {
        return lista.search(id);
    }

    public boolean stergeElement(String id, ElemList<IComparare<String>, String> lista) {
        return lista.remove(id);
    }
}
