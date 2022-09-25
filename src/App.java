import java.util.ArrayList;
import java.util.Scanner;

/*
K1) Når en automat opstilles på en station skal installatøren kunne angive
prisen per billet. Efter installation skal prisen være fast. K2) Automaten skal
kunne fortælle kunden hvad en billet koster. K3) Automaten skal kunne udskrive
en billet mærket med DSB’s nye logo (i terminalen). K4) Automaten vil til enhver
tid kunne vise kunden balancen, dvs. hvor mange penge kunden har puttet i
automaten. K5) Ved opstilling skal installatøren kunne angive balancen, sådan at
installatøren Programmering i Java. 3. HTX – Programmering B – 2022/23. Lærer:
Steen Grøntved kan udskrive en eller flere test-billetter uden at skulle putte
penge i automaten. K6) Medarbejderen skal kunne aflæse hvor mange billetter der
er blevet solgt af automaten og kunne tømme den for penge.
 */

public class App {

  static String admin_key = "admin1";

  public static void main(String[] args) throws Exception {

    String tilstop = "";
    String frastop = "";
    int pris_pr_stop = 14;
    int saldo = 0;
    boolean is_admin = false;

    Scanner user_input = new Scanner(System.in);

    Map kort = new Map();

    kort.print_stops();
    System.out.println("admin) login som admin");

    while (true) {
      try {
        System.out.println();

        if (is_admin) {
          System.out.println("# Saldo er " + saldo +
                             " DKK\n# Billeter er gratis for admin.");
          System.out.print(
              "# 1) Sæt pris pr stop. 2) Køb billet. 3) Exit admin shell. 4) Indsæt bytte penge på saldo\n: ");

          switch (Integer.parseInt(user_input.nextLine())) {
          case 1:
            System.out.print("# Ny pris pr stop: ");
            pris_pr_stop = Integer.parseInt(user_input.nextLine());
            continue;

          case 2:
            break;

          case 3:
            is_admin = false;
            continue;

          case 4:
            System.out.print("# Ny saldo: ");
            saldo = Integer.parseInt(user_input.nextLine());
            continue;

          default:
            System.out.println("Invalid option");
            continue;
          }
        }

        System.out.print("Hvilket stop vil du rejse fra (eller admin)? ");
        String input = user_input.nextLine();
        if (input.equals("admin")) {
          System.out.print("Password: ");
          input = user_input.nextLine();
          if (input.equals(admin_key)) {
            is_admin = true;
            continue;
          } else {
            System.out.println("Wrong password.");
            continue;
          }
        }
        frastop = kort.get_stop_name(Integer.parseInt(input));

        System.out.print("Hvilket stop vil du rejse til? ");
        tilstop = kort.get_stop_name(Integer.parseInt(user_input.nextLine()));

        ArrayList<String> rute = kort.find_path(frastop, tilstop).format();
        // ArrayList<String> rute = (new Rute()).format();

        int billetpris = 0;
        if (!is_admin) {
          billetpris = rute.size() * pris_pr_stop;
        }

        System.out.print("Billetten koster " + billetpris +
                         " DKK. Hvor mange penge putter du i maskinen? ");
        int byttepenge = Integer.parseInt(user_input.nextLine()) - billetpris;
        if (byttepenge < 0) {
          System.out.println("For lidt penge betalt!");
          continue;
        }
        if (byttepenge > saldo) {
          System.out.println("For lidt penge i maskinen");
          continue;
        }
        saldo += billetpris;

        System.out.println("Byttepenge: " + byttepenge + " DKK");

        logo();
        for (int i = rute.size() - 1; i >= 0; i--)
          format_kvittering((rute.size() - i) + " : " + rute.get(i));

        format_kvittering("");
        format_kvittering("Pris: " + billetpris + " DKK");
        if (is_admin)
          format_kvittering("!!! TEST BILLET !!!");
        System.out.println("|"
                           + "_".repeat(48) + "|");
      } catch (Exception e) {
        System.out.println("Please enter valid input");
        System.out.println(e);
      }
    }
    // user_input.close();
  }

  public static void format_kvittering(String kvit) {
    int width = 45;
    kvit += " ".repeat(width - kvit.length());
    System.out.println("|   " + kvit + "|");
  }

  public static void logo() {
    System.out.print("         ________________________________         \n"
                     + "        / @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\\        \n"
                     + "       / @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\\       \n"
                     + "      / @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\\      \n"
                     + "     / @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\\     \n"
                     + "    / @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\\    \n"
                     + "   / @@@@@@########@@@@&PJ7?JG@@G######@@@@@@@\\   \n"
                     + "  / @@@@@@#         G@#:     '@@?  .,,  Y@@@@@@\\  \n"
                     + " / @@@@@@@#. #@@@.  .##.  .#@@@@?  :#\"  5@@@@@@@\\ \n"
                     + "|  @@@@@@@#. #@@@@#  G@B.     &@?      {5@@@@@@@@|\n"
                     + "|\\  @@@@@@#. #@@@#. .&@@@@@.  .@? :@@@:  }@@@@@@/|\n"
                     +
                     "| \\  @@@@@#.       .#@5.     .B@?  \"\"\"' .&@@@@&/ |\n"
                     + "|  \\  @@@@P5555PG&@@@&G5YY5B@@@B55555G#@@@@@#@/  |\n"
                     + "|   \\  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B/   |\n"
                     + "|    \\  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@G/    |\n"
                     + "|     \\  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@P/     |\n"
                     + "|      \\  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Y/      |\n"
                     + "|       \\________________________________/       |\n"
                     + "|                                                |\n"
                     + "|                                                |\n"
                     + "|                                                |\n");
  }
}
