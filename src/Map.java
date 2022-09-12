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

  public Zone[] quickest_route(int from, int to) { return new Zone[0]; }
}
