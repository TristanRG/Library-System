package Lists;

import Interface.IComparare;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ElemList<T extends IComparare<K>, K> implements Iterable<T> {
    private List<T> elements;

    public ElemList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T search(K id) {
        for (T element : elements) {
            if (element.compara(id)) {
                return element;
            }
        }
        return null;
    }

    public boolean remove(K id) {
        T element = search(id);
        if (element != null) {
            elements.remove(element);
            return true;
        }
        return false;
    }

    public void printAll() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
