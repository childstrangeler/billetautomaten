public class Stoppested {
  public TransportLinje[] linjer;
  public String stop_navn = "Nowhere";

  public Stoppested(TransportLinje[] a, String navn) {
    linjer = a;
    stop_navn = navn;
  }

  public int linjer() {
    return linjer.length;
  }
}
