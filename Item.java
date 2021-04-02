public class Item extends GameObject {
  public Item (String name, String description) {
    super(name, description);
  }

  @Override
  public String toString () {
    return getName();
  }
}
