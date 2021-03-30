public class Location extends GameObject{
  
  public Item[] itemsHere;

	private int N, S, E, W;

  public Location(String name, String description, int aN, int aS, int aE, int aW) {
		super(name, description);
		this.N = aN;
		this.S = aS;
		this.E = aE;
		this.W = aW;
    this.itemsHere = new Item[25];
  }

	public String getLocation() {
		return this.getName();
	}
  
  public void addObject(Item object, int indexNumber) {
    this.itemsHere[indexNumber] = object;
  }
  
  public void removeObject(Object object) {
    for(int i = 0; i < itemsHere.length; i++) {
      if (itemsHere[i] == object) {
        itemsHere[i] = null;
      }
    }
  }
    
  public void printItemsHere() {
    System.out.println("Items Here: ");
    for (int i = 0; i < itemsHere.length; i++) {
      if (itemsHere[i] != null) {
        System.out.println("- " + itemsHere[i].getName());
      }
    }
  }
  
  public void printInfo() {
    System.out.println(this.getName());
    System.out.println(this.getDescription());
    System.out.println(this.itemsHere);
  }
  
}