public class Player{
  
  private String name;
  private Location currentLocation;
	//ArrayList
  // public exit

  public Player(String aName) {
    this.name = aName;
  }

  public void setCurrentLocation(Location aLocation) {
    this.currentLocation = aLocation;
  }

  public void getCurrentLocation() {
    System.out.println(this.currentLocation.description);
  }

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}
	//people.move
}