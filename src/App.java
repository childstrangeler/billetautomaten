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

    // Køb gratis billet
    // set pris
    // se saldo

    Map kort = new Map();

    kort.print_stops();
    System.out.println("admin) login som admin");

    while (true) {
      System.out.println();

      if (is_admin) {
        System.out.println("# Saldo er " + saldo + " DKK");
        System.out.print(
            "# 1) sæt pris pr stop. 2) køb billet. 3) exit admin shell.\n: ");

        switch (Integer.parseInt(user_input.nextLine())) {
        case 1:
          System.out.print("# ny pris pr stop: ");
          pris_pr_stop = Integer.parseInt(user_input.nextLine());
          continue;

        case 2:
          break;

        case 3:
          is_admin = false;
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

      ArrayList<TransportLinje> rute = kort.find_path(frastop, tilstop);

      System.out.println("");

      logo();
      for (int i = rute.size() - 1; i >= 0; i--)
        format_kvittering((rute.size() - i) + " : " + rute.get(i).format());

      // String last_linje = "";
      // rute.get(0).print();
      // for (int i = rute.size() - 1; i >= 0; i--) {
      //   if (!rute.get(i).linje_name.equals(last_linje) || i == 0) {
      //     if (i != rute.size() - 1)
      //       billet_buffer += rute.get(i).next_stop;
      //     if (i != 0)
      //       billet_buffer += " + " + rute.get(i).linje_name + " til ";
      //     last_linje = rute.get(i).linje_name;
      //   }
      // }

      int billetpris = 0;
      if (!is_admin) {
        billetpris = rute.size() * pris_pr_stop;
      }

      format_kvittering(billetpris + " DKK");
      System.out.println("|"
                         + "_".repeat(48) + "|");
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
