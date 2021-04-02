import java.awt.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class Character extends GameObject {

  private Location location;
  private List<Item> inventory;
  private DialogNode script;

  public Character (String name) {
    super(name, "");
    this.location = null;
    this.inventory = new ArrayList<>();
  }

  public Character (String name, String description, Location location) {
    super(name, description);
    this.location = location;
    this.inventory = new ArrayList<>();
  }

  public Character (String name, String description, Location location, List<Item> inventory) {
    super(name, description);
    this.location = location;
    this.inventory = inventory;
  }

  public void setScript (DialogNode script) {
    this.script = script;
  }

  // TODO: interact method for NPCs
  public void interact (Character playerInstance) {
    // change this to the actual interaction model
    Scanner interactionScanner = new Scanner(System.in);

    // logic
    /*
        Create Scanner

        loop
        Print DialogNode.root
        Print all choice options
        ask for choice number

        while ! valid choice number repeat
        once valid

        currentNode = root.choice.child

        end loop if root.choices.isEmpty
     */

    boolean conversationEnded = false;
    DialogNode currentNode = this.script;
    List<Item> playerInventory = playerInstance.inventory;

    // TODO: This while loop is faulty, find a different condition
    while (!conversationEnded || true) {
      List<Item> requirements = currentNode.getRequired();

      if (!requirements.isEmpty() && !playerInventory.containsAll(requirements)) {
        // the user doesn't have enough to progress the dialogue
        System.out.println("I have nothing to say to you right now.");
        conversationEnded = true;
        break;
      }

      System.out.println(currentNode.getBlurb());

      Item possibleReward = currentNode.getReward();

      if (possibleReward != null) {
        playerInstance.addToInventory(possibleReward);
        System.out.printf("%s gave you: %s", this.getName(), possibleReward.getName());
      }

      if (currentNode.getChoices().isEmpty()) {
        System.out.println("I have to go now.");
        conversationEnded = true;
        break;
      }

      int optionIterator = 1;
      for (SimpleEntry<String, DialogNode> kv : currentNode.getChoices()) {
        System.out.printf("(%d). %s%n", optionIterator, kv.getKey());

        optionIterator += 1;
      }

      // If we don't do this, it'll leave a \r\n in stdin which has some wild consequences
      int optionChosen = Integer.parseInt(interactionScanner.nextLine().trim());

      while (optionChosen > optionIterator) {
        System.out.println("Please select a valid option or use \"q\" to end the conversation here:");
        String input = interactionScanner.nextLine().trim().toLowerCase();
        if (input.equals("q")) {
          System.out.println("Okay, bye");
          conversationEnded = true;
          break;
        }
        else {
          optionChosen = Integer.parseInt(input);
        }
      }

      if (optionChosen <= -1) {
        conversationEnded = true;
        break;
      }

      currentNode = currentNode.getChoices().get(optionChosen - 1).getValue();  // This should work
    }
  }

  public void addToInventory (Item toAdd) {
    inventory.add(toAdd);
  }

  public List<Item> getInventory () {
    return inventory;
  }

  public void setCurrentLocation (Location location) {
    this.location = location;
  }

  public Location getCurrentLocation () {
    return location;
  }

  public void printStuff () {
    for (Item thing : inventory) {
      System.out.println(thing);
    }
  }
}
