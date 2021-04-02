import java.util.*;

public class Location extends GameObject {

  private ArrayList<Character> people;
  private ArrayList<Item> items;
  private HashMap<String, Location> neighbors;

  public Location (String name, String description) {
    super(name, description);
    people = new ArrayList<>();
    items = new ArrayList<>();
    neighbors = new HashMap<>();
  }

  public String getLocation () {
    return this.getName();
  }

  public void addPerson (Character person) {
    people.add(person);
  }

  public void removePerson (Character person) {
    people.remove(person);
  }

  public void addItem (Item item) {
    items.add(item);
  }

  public void removeItem (Item item) {
    items.remove(item);
  }

  public Item containItem (String name) {
    for (Item i : this.items) {
      if (i.getName().equals(name)) {
        return i;
      }
    }

    return null;
  }

  public Character containCharacter (String name) {
    for (Character c : this.people) {
      if (c.getName().equals(name)) {
        return c;
      }
    }

    return null;
  }

  public void addNeighbor (String direction, Location neighbor) {
    neighbors.put(direction, neighbor);
  }

  public Location getNeighbor (String direction) {
    return neighbors.get(direction);
  }

  // Unless this game suddenly becomes a survival horror,
  // we won't need to remove doors between places
  public void removeNeighbor (String direction) {
    throw new UnsupportedOperationException("removeNeighbor not written");
  }

  public void printItemsHere () {
    System.out.println("Items Here: ");
    for (Item curr : items) {
      System.out.println("- " + curr.getName());
    }
  }

  public void printInfo () {
    System.out.println(getName());
    System.out.println(getDescription());
    System.out.println("Nearby:");
    for (Map.Entry<String, Location> kv : neighbors.entrySet()) {
      System.out.println(String.format("  - %s (go %s)", kv.getValue().getName(), kv.getKey()));
    }
  }

  public String toString () {
    return getName() + " - " + getDescription();
  }

}
