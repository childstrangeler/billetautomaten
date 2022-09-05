import java.util.Scanner;

public class App {

    public String fraby = "";
    public String tilby = "";
    public int zonepris = 0;

    // billetautomaten tager konsol argumenter som adminpris
    public static void main(String[] args) throws Exception {
        System.out.println("Hvilken billet vil du købe?");

        Scanner userinput = new Scanner(System.in);

        String input = userinput.nextLine();

        userinput.close();
        System.out.println("du skrev: " + input);

    }
}
