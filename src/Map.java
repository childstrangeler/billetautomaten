import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Map er en graf struktur, hvor hver node er en zone og hver edge er en linje
// (c tog, m1, 350s, etc)
public class Map {
  public HashMap<String, ArrayList<TransportLinje>> map;
  ArrayList<String> stoppesteder;

  public void print_stops() {
    stoppesteder = new ArrayList<String>();
    int i = 0;
    for (String stop : map.keySet()) {
      stoppesteder.add(stop);
      System.out.println(i + ") " + stop);
      i++;
    }
  }

  public String get_stop_name(int i) { return stoppesteder.get(i); }

  public Map() {
    map = new HashMap<>();
    HashMap<String, String[]> kortprlinje = new HashMap<>();

    kortprlinje.put(
        "m2", new String[] {
                  "Lufthavnen St", "Kastrup St", "Femøren St",
                  "Amager Strand St", "Øresund St", "Lergravsparken St",
                  "Amagerbro St", "Christianshavn St", "Kongens Nytorv St",
                  "Nørreport St", "Forum St", "Frederiksberg St", "Fasanvej St",
                  "Lindevang St", "Flintholm St", "Vanløse St"});
    kortprlinje.put(
        "m1",
        new String[] {"Vestamager St", "Ørestad St", "Bella Center St",
                      "Sundby St", "DR Byen St", "Islands Brygge St",
                      "Christianshavn St", "Kongens Nytorv St", "Nørreport St",
                      "Forum St", "Frederiksberg St", "Fasanvej St",
                      "Lindevang St", "Flintholm St", "Vanløse St"});
    kortprlinje.put(
        "m3",
        new String[] {"København H", "Rådhuspladsen St", "Gammel Strand St",
                      "Kongens Nytorv St", "Marmorkirken St", "Østerport St",
                      "Trianglen St", "Poul Henningsens Plads St",
                      "Vibenshus Runddel St", "Skjolds Plads St", "Nørrebro St",
                      "Nørrebros Runddel St", "Nuuks Plads St",
                      "Aksel Møllers Have St", "Frederiksberg St",
                      "Frederiksberg Allé St", "Enghave Plads St", "helvede"});
    kortprlinje.put("m4", new String[] {"Orientkaj St", "Nordhavn St",
                                        "Østerport St", "Marmorkirken St",
                                        "Kongens Nytorv St", "Gammel Strand St",
                                        "Rådhuspladsen St", "København H"});
    kortprlinje.put(
        "A",
        new String[] {"Hundige St",        "Ishøj St",        "Vallensbæk St",
                      "Brøndby Strand St", "Avedøre St",      "Friheden St",
                      "Åmarken St",        "Ny Ellebjerg St", "Sjælør St",
                      "Sydhavn St",        "Dybbølsbro St",   "København H",
                      "Vesterport St",     "Nørreport St",    "Østerport St",
                      "Nordhavn St",       "Svanemøllen St",  "Hellerup St",
                      "Lyngby St",         "Holte St",        "Birkerød St",
                      "Allerød St",        "Hillerød St"});
    kortprlinje.put(
        "B",
        new String[] {"Farum St",        "Værløse St",      "Hareskov St",
                      "Skovbrynet St",   "Bagsværd St",     "Stengården St",
                      "Buddinge St",     "Kildebakke St",   "Vangede St",
                      "Dyssegård St",    "Emdrup St",       "Ryparken St",
                      "Svanemøllen St",  "Nordhavn St",     "Østerport St",
                      "Nørreport St",    "Vesterport St",   "København H",
                      "Dybbølsbro St",   "Carlsberg St",    "Valby St",
                      "Danshøj St",      "Hvidovre St",     "Rødovre St",
                      "Brøndbyøster St", "Glostrup St",     "Albertslund St",
                      "Taastrup St",     "Høje Taastrup St"});
    kortprlinje.put(
        "C",
        new String[] {"Klampenborg St", "Ordrup St",       "Charlottenlund St",
                      "Hellerup St",    "Svanemøllen St",  "Nordhavn St",
                      "Østerport St",   "Nørreport St",    "Vesterport St",
                      "København H",    "Dybbølsbro St",   "Carlsberg St",
                      "Valby St",       "Flintholm St",    "Vanløse St",
                      "Husum St",       "Herlev St",       "Skovlunde St",
                      "Malmparken St",  "Ballerup St",     "Måløv St",
                      "Veksø St",       "Stenløse St",     "Egedal St",
                      "Ølstykke St",    "Frederikssund St"});
    kortprlinje.put(
        "E", new String[] {
                 "Køge St",         "Ølby St",          "Køge Nord St",
                 "Jersie St",       "Solrød Strand St", "Karlslunde St",
                 "Greve St",        "Hundige St",       "Ishøj St",
                 "Ny Ellebjerg St", "Sjælør St",        "Sydhavn St",
                 "Dybbølsbro St",   "København H",      "Vesterport St",
                 "Nørreport St",    "Østerport St",     "Nordhavn St",
                 "Svanemøllen St",  "Hellerup St",      "Bernstorffsvej St",
                 "Gentofte St",     "Jægersborg St",    "Lyngby St",
                 "Sorgenfri St",    "Virum St",         "Holte St"});
    kortprlinje.put(
        "F", new String[] {"Ny Ellebjerg St", "Vigerslev Alle St", "Danshøj St",
                           "Ålholm St", "KB Hallen St", "Flintholm St",
                           "Grøndal St", "Fuglebakken St", "Nørrebro St",
                           "Bispebjerg St", "Ryparken St", "Hellerup St"});
    kortprlinje.put(
        "H", new String[] {"Ballerup St", "Malmparken St", "Skovlunde St",
                           "Herlev St", "Husum St", "Islev St",
                           "Jyllingevej St", "Vanløse St", "Flintholm St",
                           "Peter Bangs Vej St", "Langgade St", "Valby St",
                           "Carlsberg St", "Dybbølsbro St", "København H",
                           "Vesterport St", "Nørreport St", "Østerport St"});

    map.put("Nowhere", new ArrayList<>());
    for (String[] stop : kortprlinje.values())
      for (int i = 0; i < stop.length; i++)
        map.put(stop[i], new ArrayList<TransportLinje>());

    for (String linje : kortprlinje.keySet()) {
      String[] stop = kortprlinje.get(linje);
      for (int i = 0; i < stop.length - 1; i++) {
        map.get(stop[i]).add(new TransportLinje(linje, stop[i + 1]));
        map.get(stop[i + 1]).add(new TransportLinje(linje, stop[i]));
      }
    }
  }

  public Rute find_path(String from, String to) {
    // memo indeholder en liste af korteste ruter fundet fra 'from', encodet som
    // en graph struktur
    ArrayList<Rute> memo = new ArrayList<Rute>();
    HashSet<String> korteste_rute_fundet = new HashSet<String>();

    // fra memo[offset] og frem, er der kun child nodes.
    int offset = 0;

    // Load de første nodes hvofra man kan komme til, fra 'from'
    for (int linje_nr = 0; linje_nr < map.get(from).size(); linje_nr++) {
      TransportLinje linje = map.get(from).get(linje_nr);
      Rute start = new Rute();
      Rute stop_som_rute = start.add(linje);
      memo.add(stop_som_rute);
    }

    while (true) {
      // 'offset' til 'target' indeholder de child nodes der skal bygges videre
      // på, for at finde vores path.
      int target = memo.size();
      for (int i = offset; i < target; i++) {
        Rute continued = memo.get(i);

        String stoppested = continued.ende_stop.next_stop;
        if (stoppested.equals(to)) {
          // Er det her vi skal hen?
          return continued;
        }

        // Iterere gennem alle de nodes vi kan bevæge os til, fra den child node
        // 'continued'
        for (int linje_nr = 0; linje_nr < map.get(stoppested).size();
             linje_nr++) {
          TransportLinje linje = map.get(stoppested).get(linje_nr);

          // Har vi allerede funden den korteste rute til dette stop? så skip
          // children af denne linje. Dette gør at find_path undlader at tjekke
          // de samme ruter flere gange.
          if (korteste_rute_fundet.contains(linje.next_stop))
            continue;
          korteste_rute_fundet.add(linje.next_stop);

          // Så gemmer vi de relevante videre fogreninger, til næste iteration.
          Rute rute = continued.add(linje);
          memo.add(rute);
        }
      }
      offset = target;
    }
  }
}
