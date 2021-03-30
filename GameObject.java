public class GameObject {
  
  private String name;
  private String description;
  
  public GameObject(String name, String description) {
    this.name = name;
		this.description = description;
  }
  
  public String getDescription() {
    return description;
  }

	public String getName() {
		return name;
	}

  public void setDescription(String newDescription) {
    description = newDescription;
  }

  public void setName(String newName) {
    name = newName;
  }
}