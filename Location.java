public class Location extends Object{
  
	public String name;
  public String description;
  public Object itemsHere[];

	private int N, S, E, W;

  public Location(String name, String description, int aN, int aS, int aE, int aW) {
		super(name, description);
		this.N = aN;
		this.S = aS;
		this.E = aE;
		this.W = aW;
    this.itemsHere = new Object[25];
  }

	public String getLocation() {
		return this.name;
	}
  
  public void setDescription(String string) {
    this.description = string;
  }
  
  public void addObject(Object object, int indexNumber) {
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
        System.out.println("- " + itemsHere[i].name);
      }
    }
  }
  
  public void printInfo() {
    System.out.println(this.name);
    System.out.println(this.description);
    System.out.println(this.itemsHere);
  }
  
}