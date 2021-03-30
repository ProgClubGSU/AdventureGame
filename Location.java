import java.util.*;

public class Location extends GameObject{
  
  private ArrayList<Item> items;
  private HashMap<String, Location> neighbors;

  public Location(String name, String description) {
  	super(name, description);
    items = new ArrayList<>();
    neighbors = new HashMap<>();
  }

	public String getLocation() {
		return this.getName();
	}
  
  public void addItem(Item item) {
    items.add(item);
  }
  
  public void removeItem(Item item) {
    items.remove(item);
  }

  public void addNeighbor(String direction, Location neighbor) {
    neighbors.put(direction, neighbor);
  }
    
  // Unless this game suddenly becomes a survival horror,
  // we won't need to remove doors between places
  public void removeNeighbor(String direction) {
    throw new UnsupportedOperationException("removeNeighbor not written");
  }

  public void printItemsHere() {
    System.out.println("Items Here: ");
    for (Item curr : items) {
      System.out.println("- " + curr.getName());
    }
  }
  
  public void printInfo() {
    System.out.println(getName());
    System.out.println(getDescription());
    printItemsHere();
  }

  public String toString() {
    return getName() + " - " + getDescription();
  }
  
}