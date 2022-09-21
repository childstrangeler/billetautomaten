import java.util.ArrayList;

// Map er en graf struktur, hvor hver node er en zone og hver edge er en linje
// (c tog, m1, 350s, etc)
public class Map {

  public TransportLinje tp(String name, String next_stop) {
    return new TransportLinje(name, next_stop);
  }

  public HashMap<String, TransportLinjer> map;

  public Map() {
    map = new Zone[] {
        new Zone(new TransportLinje[] {}),
        new Zone(new TransportLinje[] {tp("m3/m4", 2), tp("m1/m2", 2),
                                       tp("m1/m2", 3), tp("C", 2), tp("A", 2),
                                       tp("E", 2), tp("B", 2), tp("H", 2)}),
        new Zone(new TransportLinje[] {
            tp("m1/m2", 3), tp("m1/m2", 3), tp("C", 32), tp("A", 31),
            tp("E", 33), tp("E", 30), tp("B", 30), tp("B", 32), tp("H", 2)}),
        new Zone(new TransportLinje[] {tp("C", 2), tp("m1", 3)}),
    };
  }

  public boolean find_path_inner(int from, int to, int depth, int max_depth,
                                 ArrayList<TransportLinje> cache) {
    if (from == to)
      return true;
    if (depth > max_depth)
      return false;

    for (int linje = 0; linje < map[from].linjer(); linje++)
      if (find_path_inner(map[from].linjer[linje].next_zone, to, depth + 1,
                          max_depth, cache)) {
        cache.add(map[from].linjer[linje]);
        return true;
      }

    return false;
  }

  public ArrayList<TransportLinje> find_path(int from, int to) {
    ArrayList<TransportLinje> cache = new ArrayList<TransportLinje>(0);
    for (int max_depth = 0; max_depth < map.length; max_depth++)
      for (int linje = 0; linje < map[from].linjer(); linje++)
        if (this.find_path_inner(map[from].linjer[linje].next_zone, to, 1,
                                 max_depth, cache)) {
          cache.add(map[from].linjer[linje]);
          return cache;
        }
    return cache;
  }
}
