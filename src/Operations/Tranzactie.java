package Operations;

import Elements.AbstractElem;
import Elements.Membru;
import java.time.LocalDate;

public class Tranzactie {
    private Membru membru;
    private AbstractElem element;
    private LocalDate dataImprumut;
    private LocalDate dataScadenta;

    private static final int ZILE_IMPLICITE = 14;

    public Tranzactie(Membru membru, AbstractElem element, LocalDate dataImprumut) {
        this.membru = membru;
        this.element = element;
        this.dataImprumut = dataImprumut;
        this.dataScadenta = dataImprumut.plusDays(ZILE_IMPLICITE);
    }

    public Membru getMembru() {
        return membru;
    }

    public AbstractElem getElement() {
        return element;
    }

    public LocalDate getDataImprumut() {
        return dataImprumut;
    }

    public LocalDate getDataScadenta() {
        return dataScadenta;
    }

    public int calculeazaPenalizare(LocalDate dataReturnare, int sumaPeZi) {
        long zileIntarziere = java.time.temporal.ChronoUnit.DAYS.between(dataScadenta, dataReturnare);
        if (zileIntarziere <= 0) {
            return 0;
        }
        int penalizare = (int) zileIntarziere * sumaPeZi;
        if (element.getRetineri() > 0) {
            penalizare *= 2;
        }
        return penalizare;
    }
}
