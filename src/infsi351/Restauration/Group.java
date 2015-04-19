package infsi351.Restauration;

import java.util.ArrayList;
import java.util.List;

public class Group {

  public String string;
  public final List<Boisson> children = new ArrayList<Boisson>();

  public Group(String string) {
    this.string = string;
  }

} 
