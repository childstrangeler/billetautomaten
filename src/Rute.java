import java.util.ArrayList;

public class Rute {
  boolean start = true;
  public TransportLinje ende_stop = new TransportLinje("", "Nowhere");
  Rute prev_stops;
  int stop_count = 1;

  public Rute add(TransportLinje stop) {
    Rute tmp = new Rute();
    tmp.prev_stops = this;
    tmp.ende_stop = stop;
    tmp.stop_count = stop_count + 1;
    tmp.start = false;
    return tmp;
  }

  public ArrayList<String> format() {
    Rute tmp = this;
    ArrayList<String> stops = new ArrayList<String>();
    while (!tmp.start) {
      stops.add(tmp.ende_stop.format());
      tmp = tmp.prev_stops;
    }
    return stops;
  }
}
