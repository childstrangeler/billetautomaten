import java.util.ArrayList;
import java.util.HashMap;

// Map er en graf struktur, hvor hver node er en zone og hver edge er en linje
// (c tog, m1, 350s, etc)
public class Map {

  public TransportLinje tp(String name, String next_stop) {
    return new TransportLinje(name, next_stop);
  }

  public HashMap<String, Stoppested> map;

  public Map() {
    map = new HashMap<>();
  }

  public boolean find_path_inner(String from, String to, int depth, int max_depth,
      ArrayList<TransportLinje> cache) {
    if (from == to)
      return true;
    if (depth > max_depth)
      return false;

    for (int linje = 0; linje < map.get(from).linjer(); linje++)
      if (find_path_inner(map.get(from).linjer[linje].next_stop, to, depth + 1,
          max_depth, cache)) {
        cache.add(map.get(from).linjer[linje]);
        return true;
      }

    return false;
  }

  public ArrayList<TransportLinje> find_path(String from, String to) {
    ArrayList<TransportLinje> cache = new ArrayList<TransportLinje>(0);
    for (int max_depth = 0; max_depth < map.size(); max_depth++)
      for (int linje = 0; linje < map.get(from).linjer(); linje++)
        if (this.find_path_inner(map.get(from).linjer[linje].next_stop, to, 1,
            max_depth, cache)) {
          cache.add(map.get(from).linjer[linje]);
          return cache;
        }
    return cache;
  }
}
