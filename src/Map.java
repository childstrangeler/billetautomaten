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

    map.put("Nowhere", new ArrayList<>());
    for (String[] stop : kortprlinje.values())
      for (int i = 0; i < stop.length; i++)
        map.put(stop[i], new ArrayList<TransportLinje>());

    for (String linje : kortprlinje.keySet()) {
      String[] stop = kortprlinje.get(linje);
      for (int i = 0; i < stop.length - 1; i++)
        map.get(stop[i]).add(new TransportLinje(linje, stop[i + 1]));
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
