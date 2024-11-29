package Elements;

import Interface.IAbstractElemVisitor;

public abstract class ElemDecorator extends AbstractElem {
    protected AbstractElem elementDecorat;

    public ElemDecorator(AbstractElem elementDecorat) {
        super(elementDecorat.getId(), elementDecorat.getTitlu());
        this.elementDecorat = elementDecorat;
    }

    @Override
    public void Accept(IAbstractElemVisitor visitor) {
        elementDecorat.Accept(visitor);
    }

    public AbstractElem getDecorat() {
        return elementDecorat;
    }
}
