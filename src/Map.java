import java.util.ArrayList;

// Map er en graf struktur, hvor hver node er en zone og hver edge er en linje
// (c tog, m1, 350s, etc)
public class Map {

  public TransportLinje tp(String name, int next_zone) {
    return new TransportLinje(name, next_zone);
  }

  public Zone[] map;
  public Map() {
    map = new Zone[] {
        new Zone(new TransportLinje[] {tp("C", 1), tp("m1", 2)}),
        new Zone(new TransportLinje[] {tp("C", 2), tp("m1", 0)}),
        new Zone(new TransportLinje[] {tp("C", 0), tp("m3", 0)}),
    };
  }

  public boolean find_path_inner(int from, int to, int depth,
                                 ArrayList<TransportLinje> cache) {
    if (from == to)
      return true;
    if (depth > map.length)
      return false;

    for (int linje = 0; linje < map[from].linjer(); linje++)
      if (find_path_inner(map[from].linjer[linje].next_zone, to, depth + 1,
                          cache)) {
        cache.add(map[from].linjer[linje]);
        return true;
      }

    return false;
  }

  public ArrayList<TransportLinje> find_path(int from, int to) {
    ArrayList<TransportLinje> cache = new ArrayList<TransportLinje>(0);
    this.find_path_inner(from, to, 0, cache);
    return cache;
  }
}
