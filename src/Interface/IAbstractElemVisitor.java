package Interface;

import Elements.Carte;
import Elements.Revista;
import Elements.ElemCuTaxa;
import Elements.ElemInSala;

public interface IAbstractElemVisitor {
    void Visit(Carte carte);
    void Visit(Revista revista);
    void Visit(ElemCuTaxa elemCuTaxa);
    void Visit(ElemInSala elemInSala);
}
