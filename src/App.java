import java.util.ArrayList;
import java.util.Scanner;

/*
K1) Når en automat opstilles på en station skal installatøren kunne angive prisen per
billet. Efter installation skal prisen være fast.
K2) Automaten skal kunne fortælle kunden hvad en billet koster.
K3) Automaten skal kunne udskrive en billet mærket med DSB’s nye logo (i
terminalen).
K4) Automaten vil til enhver tid kunne vise kunden balancen, dvs. hvor mange penge
kunden har puttet i automaten.
K5) Ved opstilling skal installatøren kunne angive balancen, sådan at installatøren
Programmering i Java. 3. HTX – Programmering B – 2022/23. Lærer: Steen Grøntved
kan udskrive en eller flere test-billetter uden at skulle putte penge i automaten.
K6) Medarbejderen skal kunne aflæse hvor mange billetter der er blevet solgt af
automaten og kunne tømme den for penge.
 */

public class App {

    static String admin_key = "admin1";

    public static void main(String[] args) throws Exception {

        String tilstop = "";
        String frastop = "";
        int zonepris = 14;

        System.out.println("Kunde eller Admin?");

        Scanner user_input = new Scanner(System.in);

        boolean is_admin = user_input.nextLine() == admin_key;

        System.out.println("Hvilken zone vil du rejse fra?");

        frastop = user_input.nextLine();
        System.out.println("Du vil gerne rejse fra zone: " + frastop + ". Hvilken zone vil du gerne rejse til?");

        tilstop = user_input.nextLine();

        System.out.println("Du vil gerne rejse til zone: " + tilstop);

        Map kort = new Map();

        ArrayList<TransportLinje> rute = kort.find_path(frastop, tilstop);

        for (int i = rute.size() - 1; i >= 0; i--) {
            if (i != rute.size() - 1)
                System.out.print(" + ");
            rute.get(i).print();

        }
        System.out.println("");
        format_kvittering(
                "Rejsen fra zone " + frastop + " til zone " + tilstop + " vil koste dig: " + rute.size() * zonepris
                        + " DKK, betal venligst:");
        user_input.close();
    }

    public static void format_kvittering(String kvit) {
        int breathdhth = 49;
        for (int i = 0; i < (breathdhth - kvit.length()) / 2; i++) {
            kvit = " " + kvit + " ";
        }
        if (kvit.length() % 2 != 0)
            kvit += " ";
        System.out.println("|" + kvit + "|");
    }
}
