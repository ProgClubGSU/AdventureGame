import java.util.*;

public class Location extends GameObject{
  
  private ArrayList<Item> items;
  private ArrayList<Location> neighbors;

  public Location(String name, String description) {
  	super(name, description);
    items = new ArrayList<>();
    neighbors = new ArrayList<>();
  }

	public String getLocation() {
		return this.getName();
	}
  
  public Location addItem(Item item) {
    items.add(item);
    return this;
  }
  
  public Location removeItem(Item item) {
    items.remove(item);
    return this;
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
  
}