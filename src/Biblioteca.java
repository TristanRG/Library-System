import java.time.LocalDate;
import java.util.*;

import Elements.*;
import Factories.AbstractElemFactory;
import Factories.CarteParamFactory;
import Factories.ParamFactory;
import Factories.RevistaParamFactory;
import Interface.IComparare;
import Interface.IAbstractElemVisitor;
import Lists.Catalog;
import Lists.ElemList;
import Lists.ListaMembri;
import Operations.Retinere;
import Operations.Tranzactie;
import Visitors.FunditaDisplayVisitor;
import Visitors.NormalDisplayVisitor;
import Visitors.JsonDisplayVisitor;

public class Biblioteca {
    private static Biblioteca singleton;

    private ElemList<IComparare<String>, String> listaElemente;
    private ElemList<IComparare<String>, String> listaMembri;
    private List<Tranzactie> tranzactii = new ArrayList<>();
    private Map<String, Retinere> retineri = new HashMap<>();
    private Scanner scanner;

    private Biblioteca() {
        listaElemente = new ElemList<>();
        listaMembri = new ElemList<>();
        scanner = new Scanner(System.in);
        initElementeInitiale();
        initMembriInitiali();
    }

    public static Biblioteca getInstance() {
        if (singleton == null) {
            singleton = new Biblioteca();
        }
        return singleton;
    }

    private void initMembriInitiali() {
        Membru membru1 = new Membru(1, "Tristan", "072212321", "Posada");
        Membru membru2 = new Membru(2, "Razvan", "072212321", "CevaSat");

        ListaMembri.getInstance().adaugaMembru(membru1, listaMembri);
        ListaMembri.getInstance().adaugaMembru(membru2, listaMembri);
    }
    private void initElementeInitiale() {
        AbstractElem carte1 = new Carte(1, "Plumb", "Bacovia");
        AbstractElem carte2 = new Carte(2, "1984", "George Orwell");

        AbstractElem revista1 = new Revista(3, "Science Weekly", 9);
        AbstractElem revista2 = new Revista(4, "Tech Today", 10);

        Catalog.getInstance().adaugaElement(carte1, listaElemente);
        Catalog.getInstance().adaugaElement(carte2, listaElemente);
        Catalog.getInstance().adaugaElement(revista1, listaElemente);
        Catalog.getInstance().adaugaElement(revista2, listaElemente);
    }

    public void adaugaElement() {
        System.out.println("Selecteaza tipul elementului (1-8): ");
        System.out.println("1 = Carte");
        System.out.println("2 = Carte in Sala");
        System.out.println("3 = Carte in Sala cu Taxa");
        System.out.println("4 = Carte cu Taxa");
        System.out.println("5 = Revista");
        System.out.println("6 = Revista in Sala");
        System.out.println("7 = Revista in Sala cu Taxa");
        System.out.println("8 = Revista cu Taxa");

        int choice = scanner.nextInt();
        scanner.nextLine();

        ParamFactory factory;
        switch (choice) {
            case AbstractElemFactory.CARTE:
            case AbstractElemFactory.CARTE_SALA:
            case AbstractElemFactory.CARTE_SALA_TAXA:
            case AbstractElemFactory.CARTE_TAXA:
                factory = new CarteParamFactory();
                break;
            case AbstractElemFactory.REVISTA:
            case AbstractElemFactory.REVISTA_SALA:
            case AbstractElemFactory.REVISTA_SALA_TAXA:
            case AbstractElemFactory.REVISTA_TAXA:
                factory = new RevistaParamFactory();
                break;
            default:
                System.out.println("Optiune invalida!");
                return;
        }

        System.out.println("Introdu ID-ul elementului: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introdu titlul elementului: ");
        String titlu = scanner.nextLine();

        factory.setId(id);
        factory.setTitlu(titlu);

        if (factory instanceof CarteParamFactory) {
            CarteParamFactory carteFactory = (CarteParamFactory) factory;
            System.out.println("Introdu autorul cartii: ");
            String autor = scanner.nextLine();
            carteFactory.setAutor(autor);
        } else if (factory instanceof RevistaParamFactory) {
            RevistaParamFactory revistaFactory = (RevistaParamFactory) factory;
            System.out.println("Introdu numarul revistei: ");
            int numar = scanner.nextInt();
            scanner.nextLine();
            revistaFactory.setNumar(numar);
        }

        AbstractElem element = AbstractElemFactory.Instance().CreazaElemConcret(factory);

        switch (choice) {
            case AbstractElemFactory.CARTE_SALA:
            case AbstractElemFactory.REVISTA_SALA:
                element = new ElemInSala(element);
                break;
            case AbstractElemFactory.CARTE_SALA_TAXA:
            case AbstractElemFactory.REVISTA_SALA_TAXA:
                System.out.println("Introdu taxa: ");
                double taxaa = scanner.nextDouble();
                scanner.nextLine();
                element = new ElemCuTaxa(new ElemInSala(element), taxaa);
                break;
            case AbstractElemFactory.CARTE_TAXA:
            case AbstractElemFactory.REVISTA_TAXA:
                System.out.println("Introdu taxa: ");
                double taxa = scanner.nextDouble();
                scanner.nextLine();
                element = new ElemCuTaxa(element, taxa);
                break;
        }

        Catalog.getInstance().adaugaElement(element, listaElemente);
        System.out.println("Element creat si adaugat cu succes!");
    }


    public void adaugaMembru() {
        System.out.println("Introdu ID-ul membrului: ");
        int membruID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introdu numele membrului: ");
        String nume = scanner.nextLine();

        System.out.println("Introdu numarul de telefon al membrului: ");
        String telefon = scanner.nextLine();

        System.out.println("Introdu adresa membrului: ");
        String adresa = scanner.nextLine();

        Membru membru = new Membru(membruID, nume, telefon, adresa);
        ListaMembri.getInstance().adaugaMembru(membru, listaMembri);
        System.out.println("Membru adaugat cu succes!");
    }

    public void cautaElement() {
        System.out.println("Introdu ID-ul elementului (Carte sau Revista) pe care doresti sa il cauti: ");
        String id = scanner.nextLine();

        IComparare<String> element = Catalog.getInstance().cautaElement(id, listaElemente);
        if (element != null) {
            System.out.println(element);
        } else {
            System.out.println("Nu exista niciun element cu acest ID.");
        }
    }

    public void cautaMembru() {
        System.out.println("Introdu ID-ul membrului pe care doresti sa il cauti: ");
        String id = scanner.nextLine();

        Membru membru = ListaMembri.getInstance().cautaMembru(id, listaMembri);
        if (membru != null) {
            System.out.println(membru);
        } else {
            System.out.println("Nu exista niciun membru cu acest ID.");
        }
    }

    public void afiseazaCatalog() {
        System.out.println("Alege formatul de afisare: ");
        System.out.println("1 = Normal");
        System.out.println("2 = Fundita 🎀");
        System.out.println("3 = JSON");
        int choice = scanner.nextInt();
        scanner.nextLine();

        IAbstractElemVisitor visitor;

        switch (choice) {
            case 1:
                visitor = new NormalDisplayVisitor();
                break;
            case 2:
                visitor = new FunditaDisplayVisitor();
                break;
            case 3:
                visitor = new JsonDisplayVisitor();
                break;
            default:
                System.out.println("Optiune invalida!");
                return;
        }

        for (IComparare<String> elem : listaElemente) {
            if (elem instanceof AbstractElem) {
                AbstractElem abstractElem = (AbstractElem) elem;
                abstractElem.Accept(visitor);
            }
        }
    }

    public void stergeElement() {
        System.out.println("Introdu ID-ul elementului (carte sau revista) pe care doresti sa il elimini: ");
        String id = scanner.nextLine();

        boolean rezultat = Catalog.getInstance().stergeElement(id, listaElemente);
        if (rezultat) {
            System.out.println("Element eliminat cu succes!");
        } else {
            System.out.println("Nu exista niciun element cu acest ID.");
        }
    }

    public void stergeMembru() {
        System.out.println("Introdu ID-ul membrului pe care doresti sa il elimini: ");
        String id = scanner.nextLine();

        boolean rezultat = ListaMembri.getInstance().stergeMembru(id, listaMembri);
        if (rezultat) {
            System.out.println("Elements.Membru eliminat cu succes!");
        } else {
            System.out.println("Nu exista niciun membru cu acest ID.");
        }
    }


    public void imprumutaElement() {
        System.out.println("Introdu ID-ul membrului care doreste sa imprumute un element: ");
        String idMembru = scanner.nextLine();

        Membru membru = ListaMembri.getInstance().cautaMembru(idMembru, listaMembri);
        if (membru == null) {
            System.out.println("Nu exista niciun membru cu acest ID.");
            return;
        }

        System.out.println("Introdu ID-ul elementului pe care doresti sa il imprumuti: ");
        String idElement = scanner.nextLine();

        AbstractElem element = (AbstractElem) Catalog.getInstance().cautaElement(idElement, listaElemente);
        if (element == null) {
            System.out.println("Nu exista niciun element cu acest ID.");
            return;
        }

        if (element.isImprumutat()) {
            Retinere retinere = retineri.computeIfAbsent(idElement, k -> new Retinere(element));
            retinere.adaugaMembru(membru);
            System.out.println("Elementul \"" + element.getTitlu() + "\" este deja imprumutat. Ai fost adaugat la lista de asteptare.");
            return;
        }

        Tranzactie tranzactie = new Tranzactie(membru, element, LocalDate.now());
        tranzactii.add(tranzactie);

        element.imprumutaElemente();
        System.out.println("Elementul \"" + element.getTitlu() + "\" a fost imprumutat cu succes de catre membrul: " + membru.getNume());
    }


    public void returneazaElement() {
        System.out.println("Introdu ID-ul elementului pe care doresti sa il returnezi: ");
        String idElement = scanner.nextLine();

        AbstractElem element = (AbstractElem) Catalog.getInstance().cautaElement(idElement, listaElemente);
        if (element == null) {
            System.out.println("Nu exista niciun element cu acest ID.");
            return;
        }

        if (!element.isImprumutat()) {
            System.out.println("Elementul nu este imprumutat.");
            return;
        }

        tranzactii.removeIf(tranzactie -> tranzactie.getElement().equals(element));

        Retinere retinere = retineri.get(idElement);
        if (retinere != null && retinere.areRetineri()) {
            Membru urmatorMembru = retinere.obtineUrmatorulMembru();
            if (urmatorMembru != null) {
                Tranzactie tranzactie = new Tranzactie(urmatorMembru, element, LocalDate.now());
                tranzactii.add(tranzactie);
                System.out.println("Elementul \"" + element.getTitlu() + "\" a fost automat imprumutat membrului: " + urmatorMembru.getNume());
                return;
            }
        }

        element.returneazaElement();
        System.out.println("Elementul \"" + element.getTitlu() + "\" a fost returnat cu succes.");
    }

    public void anuleazaRetinere() {
        System.out.println("Introdu ID-ul membrului care doreste sa isi anuleze retinerea pentru un element: ");
        String idMembru = scanner.nextLine();

        Membru membru = ListaMembri.getInstance().cautaMembru(idMembru, listaMembri);
        if (membru == null) {
            System.out.println("Nu exista niciun membru cu acest ID.");
            return;
        }

        System.out.println("Introdu ID-ul elementului pentru care doresti sa anulezi retinerea: ");
        String idElement = scanner.nextLine();

        AbstractElem element = (AbstractElem) Catalog.getInstance().cautaElement(idElement, listaElemente);
        if (element == null) {
            System.out.println("Nu exista niciun element cu acest ID.");
            return;
        }

        Retinere retinere = retineri.get(idElement);
        if (retinere == null || !retinere.areRetineri()) {
            System.out.println("Elementul nu are nicio retinere activa.");
            return;
        }

        retinere.anuleazaRetinere(membru);
        System.out.println("Retinerea pentru \"" + element.getTitlu() + "\" a fost anulata cu succes.");
    }


    public void getTranzactii() {
        System.out.println("Lista tranzactiilor active (elemente imprumutate):");
        for (Tranzactie tranzactie : tranzactii) {
            System.out.println("Element: " + tranzactie.getElement().getTitlu() +
                    " | Imprumutat de: " + tranzactie.getMembru().getNume());
        }
    }
}

