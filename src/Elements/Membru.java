package Elements;

import Interface.IComparare;

public class Membru implements IComparare<String> {
    private int ID;
    private String nume;
    private String telefon;
    private String adresa;

    public Membru(int ID, String nume, String telefon, String adresa) {
        this.ID = ID;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public boolean compara(String id) {
        return String.valueOf(this.ID).equals(id);
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Nume: " + nume + "\n" +
                "Telefon: " + telefon + "\n" +
                "Adresa: " + adresa;
    }
}
