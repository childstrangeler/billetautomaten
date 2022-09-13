public class TransportLinje {
  public String name = "";
  public int next_zone = -1;

  public TransportLinje(String a, int b) {
    name = a;
    next_zone = b;
  }

  public void print() { System.out.print(name + " to zone " + next_zone); }
}
