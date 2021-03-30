public class Object {
  
  public String name;
  public String description;
  
  public Object(String name, String description) {
    this.name = name;
		this.description = description;
  }
  
  public void setDescription(String aDescription) {
    this.description = aDescription;
  }

	public String getName() {
		return name;
	}
  
}