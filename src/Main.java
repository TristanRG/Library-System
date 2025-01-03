import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Biblioteca biblioteca = Biblioteca.getInstance();
        int optiune = 0;

        while (optiune != 15) {
            System.out.println("1. Adauga element");
            System.out.println("2. Adauga membru");
            System.out.println("3. Cauta element");
            System.out.println("4. Cauta membru");
            System.out.println("5. Afiseaza catalog si alege tip display");
            System.out.println("6. Sterge un element");
            System.out.println("7. Sterge un membru");
            System.out.println("8. Imprumuta element");
            System.out.println("9. Returneaza element");
            System.out.println("10. Anuleaza retinere");
            System.out.println("11. Afiseaza tranzactii");
            System.out.println("12. Procesare retinere");
            System.out.println("13. Verifica retinere");
            System.out.println("14. Plaseaza retinere");
            System.out.println("15. Exit");
            System.out.print("Alege o optiune: ");

            optiune = myObj.nextInt();
            myObj.nextLine();

            switch (optiune) {
                case 1:
                    biblioteca.adaugaElement();
                    break;

                case 2:
                    biblioteca.adaugaMembru();
                    break;

                case 3:
                    biblioteca.cautaElement();
                    break;

                case 4:
                    biblioteca.cautaMembru();
                    break;

                case 5:
                    biblioteca.afiseazaCatalog();
                    break;

                case 6:
                    biblioteca.eliminaElement();
                    break;

                case 7:
                    biblioteca.eliminaMembru();
                    break;

                case 8:
                    biblioteca.imprumutaElement();
                    break;

                case 9:
                    biblioteca.returnareElement();
                    break;

                case 10:
                    biblioteca.eliminaRetinere();
                    break;

                case 11:
                    biblioteca.getTranzactii();
                    break;

                case 12:
                    biblioteca.procesareRetinere();
                    break;

                case 13:
                    biblioteca.verificaRetineri();
                    break;

                case 14:
                    biblioteca.plasareRetinere();
                    break;

                case 15:
                    System.out.println("Iesire din meniu.");
                    break;

                default:
                    System.out.println("Optiune invalida.");
                    break;
            }
        }
        myObj.close();
    }
}