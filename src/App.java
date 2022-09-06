import java.util.Scanner;

public class App {

    public String fraby = "";
    public String tilby = "";
    static public int zonepris = 14;

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
