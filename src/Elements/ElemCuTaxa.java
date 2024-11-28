package Elements;

import Interface.IAbstractElemVisitor;

public class ElemCuTaxa extends ElemDecorator {
    private double taxa;

    public ElemCuTaxa(AbstractElem elementDecorat, double taxa) {
        super(elementDecorat);
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    @Override
    public void Accept(IAbstractElemVisitor visitor) {
        visitor.Visit(this);
        super.Accept(visitor);
    }
}
