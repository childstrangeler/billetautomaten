public class Stoppestd {
  public TransportLinje[] linjer;
  public String stop_navn = "Nowhere";

  public Zone(TransportLinje[] a, String navn) {
    linjer = a;
    stop_navn = navn;
  }

  public int linjer() { return linjer.length; }
}
