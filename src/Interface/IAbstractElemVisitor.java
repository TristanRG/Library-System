package Interface;

import Elements.Carte;
import Elements.Revista;

public interface IAbstractElemVisitor {
    void Visit(Carte carte);
    void Visit(Revista revista);
}
