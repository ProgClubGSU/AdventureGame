import java.util.*;

public class Character extends GameObject {
  
  private Location location;
  private List<Item> inventory;
  
  public Character(String name, Location location) {
    super(name, "");
    this.location = location;
    this.inventory = new ArrayList<>();
  }

  public void setCurrentLocation(Location location) {
    this.location = location;
  }

  public Location getCurrentLocation() {
    return location;
  }
  
  public void printStuff() {
    for (Item thing : inventory) {
      System.out.println(thing);
    }
  }
}