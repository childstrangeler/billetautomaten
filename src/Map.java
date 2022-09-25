import java.util.ArrayList;
import java.util.HashMap;

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

  public String get_stop_name(int i) {
    return stoppesteder.get(i);
  }

  public Map() {
    map = new HashMap<>();
    HashMap<String, String[]> kortprlinje = new HashMap<>();

    kortprlinje.put(
        "m2", new String[] {
            "Lufthavnen St", "Kastrup St", "Femøren St",
            "Amager Strand St", "Øresund St", "Lergravsparken St",
            "Amagerbro St", "Christianshavn St", "Kongens Nytorv St",
            "Nørreport St", "Forum St", "Frederiksberg St", "Fasanvej St",
            "Lindevang St", "Flintholm St", "Vanløse St" });
    kortprlinje.put(
        "m1",
        new String[] { "Vestamager St", "Ørestad St", "Bella Center St",
            "Sundby St", "DR Byen St", "Islands Brygge St",
            "Christianshavn St", "Kongens Nytorv St", "Nørreport St",
            "Forum St", "Frederiksberg St", "Fasanvej St",
            "Lindevang St", "Flintholm St", "Vanløse St" });
    kortprlinje.put(
        "m3",
        new String[] { "København H", "Rådhuspladsen St", "Gammel Strand St",
            "Kongens Nytorv St", "Marmorkirken St", "Østerport St",
            "Trianglen St", "Poul Henningsens Plads St",
            "Vibenshus Runddel St", "Skjolds Plads St", "Nørrebro St",
            "Nørrebros Runddel St", "Nuuks Plads St",
            "Aksel Møllers Have St", "Frederiksberg St",
            "Frederiksberg Allé St", "Enghave Plads St", "helvede" });
    kortprlinje.put("m4", new String[] { "Orientkaj St", "Nordhavn St",
        "Østerport St", "Marmorkirken St",
        "Kongens Nytorv St", "Gammel Strand St",
        "Rådhuspladsen St", "København H" });
    kortprlinje.put(
        "A",
        new String[] { "Hundige St", "Ishøj St", "Vallensbæk St",
            "Brøndby Strand St", "Avedøre St", "Friheden St",
            "Åmarken St", "Ny Ellebjerg St", "Sjælør St",
            "Sydhavn St", "Dybbølsbro St", "København H",
            "Vesterport St", "Nørreport St", "Østerport St",
            "Nordhavn St", "Svanemøllen St", "Hellerup St",
            "Lyngby St", "Holte St", "Birkerød St",
            "Allerød St", "Hillerød St" });
    kortprlinje.put(
        "B",
        new String[] { "Farum St", "Værløse St", "Hareskov St",
            "Skovbrynet St", "Bagsværd St", "Stengården St",
            "Buddinge St", "Kildebakke St", "Vangede St",
            "Dyssegård St", "Emdrup St", "Ryparken St",
            "Svanemøllen St", "Nordhavn St", "Østerport St",
            "Nørreport St", "Vesterport St", "København H",
            "Dybbølsbro St", "Carlsberg St", "Valby St",
            "Danshøj St", "Hvidovre St", "Rødovre St",
            "Brøndbyøster St", "Glostrup St", "Albertslund St",
            "Taastrup St", "Høje Taastrup St" });
    kortprlinje.put(
        "C",
        new String[] { "Klampenborg St", "Ordrup St", "Charlottenlund St",
            "Hellerup St", "Svanemøllen St", "Nordhavn St",
            "Østerport St", "Nørreport St", "Vesterport St",
            "København H", "Dybbølsbro St", "Carlsberg St",
            "Valby St", "Flintholm St", "Vanløse St",
            "Husum St", "Herlev St", "Skovlunde St",
            "Malmparken St", "Ballerup St", "Måløv St",
            "Veksø St", "Stenløse St", "Egedal St",
            "Ølstykke St", "Frederikssund St" });
    kortprlinje.put(
        "E", new String[] {
            "Køge St", "Ølby St", "Køge Nord St",
            "Jersie St", "Solrød Strand St", "Karlslunde St",
            "Greve St", "Hundige St", "Ishøj St",
            "Ny Ellebjerg St", "Sjælør St", "Sydhavn St",
            "Dybbølsbro St", "København H", "Vesterport St",
            "Nørreport St", "Østerport St", "Nordhavn St",
            "Svanemøllen St", "Hellerup St", "Bernstorffsvej St",
            "Gentofte St", "Jægersborg St", "Lyngby St",
            "Sorgenfri St", "Virum St", "Holte St" });
    kortprlinje.put(
        "F", new String[] { "Ny Ellebjerg St", "Vigerslev Alle St", "Danshøj St",
            "Ålholm St", "KB Hallen St", "Flintholm St",
            "Grøndal St", "Fuglebakken St", "Nørrebro St",
            "Bispebjerg St", "Ryparken St", "Hellerup St" });
    kortprlinje.put(
        "H", new String[] { "Ballerup St", "Malmparken St", "Skovlunde St",
            "Herlev St", "Husum St", "Islev St",
            "Jyllingevej St", "Vanløse St", "Flintholm St",
            "Peter Bangs Vej St", "Langgade St", "Valby St",
            "Carlsberg St", "Dybbølsbro St", "København H",
            "Vesterport St", "Nørreport St", "Østerport St" });

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

  public boolean find_path_inner(String from, String to, int depth,
      int max_depth,
      ArrayList<TransportLinje> cache) {
    if (from.equals(to))
      return true;
    if (depth > max_depth)
      return false;

    for (int linje = 0; linje < map.get(from).size(); linje++)
      if (find_path_inner(map.get(from).get(linje).next_stop, to, depth + 1,
          max_depth, cache)) {
        cache.add(map.get(from).get(linje));
        return true;
      }

    return false;
  }

  public ArrayList<TransportLinje> find_path(String from, String to) {
    ArrayList<TransportLinje> cache = new ArrayList<TransportLinje>(0);
    for (int max_depth = 0; max_depth < map.size(); max_depth++)
      for (int linje = 0; linje < map.get(from).size(); linje++)
        if (this.find_path_inner(map.get(from).get(linje).next_stop, to, 1,
            max_depth, cache)) {
          cache.add(map.get(from).get(linje));
          return cache;
        }
    return cache;
  }
}
