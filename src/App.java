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

    public String fraby = "";
    public String tilby = "";
    static public int zonepris = 14;
    public String adminkey = "admin1";

    // billetautomaten tager konsol argumenter som adminpris
    public static void main(String[] args) throws Exception {

        System.out.println("Hvilken by vil du rejse fra?");

        Scanner userinput = new Scanner(System.in);

        String fraby = userinput.nextLine();

        System.out.println("Du vil gerne rejse fra: " + fraby + ". Hvor vil du gerne rejse til?");

        String tilby = userinput.nextLine();

        System.out.println("Du vil gerne rejse til: " + tilby);
        System.out.println(
                "Rejsen fra " + fraby + " til " + tilby + " vil koste dig: " + zonepris + " DKK, betal venligst:");

        userinput.close();
    }
}
