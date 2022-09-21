public class TransportLinje {
  public String linje_name = "";
  public String next_stop = "Nowhere";

  public TransportLinje(String navn, String next) {
    linje_name = navn;
    next_stop = next;
  }

  public void print() {
    System.out.print(linje_name + " til stop " + next_stop);
  }
}
