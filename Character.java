public class Character extends GameObject {
  
  private Location location;

  public Character(String name, Location location) {
    super(name, "");
    this.location = location;
  }

  public Character setCurrentLocation(Location location) {
    this.location = location;
    return this;
  }

  public void getCurrentLocation() {
    System.out.println(location.getDescription());
  }
}