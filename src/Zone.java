public class Zone {
  public TransportLinje[] linjer;

  public Zone(TransportLinje[] a) { linjer = a; }

  public int linjer() { return linjer.length; }
}
