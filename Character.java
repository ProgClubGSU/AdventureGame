public class Character extends GameObject {
  
  private Location location;

  public Character(String name, Location location) {
    super(name, "");
    this.location = location;
  }

  public void setCurrentLocation(Location location) {
    this.location = location;
  }

  public void getCurrentLocation() {
    System.out.println(location.getDescription());
  }
}