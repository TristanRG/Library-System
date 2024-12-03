import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Biblioteca biblioteca = Biblioteca.getInstance();
        int optiune = 0;

        while (optiune != 8) {
            System.out.println("1. Adauga element");
            System.out.println("2. Adauga membru");
            System.out.println("3. Cauta element");
            System.out.println("4. Cauta membru");
            System.out.println("5. Afiseaza catalog si alege tip display");
            System.out.println("6. Sterge un element");
            System.out.println("7. Sterge un membru");
            System.out.println("8. Exit");
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
                    biblioteca.stergeElement();
                    break;

                case 7:
                    biblioteca.stergeMembru();
                    break;

                case 8:
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