package Elements;

import Interface.IAbstractElemVisitor;

public class ElemInSala extends ElemDecorator {
    public ElemInSala(AbstractElem elementDecorat) {
        super(elementDecorat);
    }

    @Override
    public void Accept(IAbstractElemVisitor visitor) {
        visitor.Visit(this);
        super.Accept(visitor);
    }
}
