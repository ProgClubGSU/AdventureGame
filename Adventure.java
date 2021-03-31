import java.util.*;

public class Adventure {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter you name: ");
    Character player = AdventureData.loadGameDataAndMC(input.nextLine());
		
		//Game introduction
		getIntro(player.getName());
    
    String choice;
    boolean endGame = false;
    while (!endGame) {
      player.getCurrentLocation().printInfo();
      System.out.print("What would you like to do? ");
      choice = input.nextLine().toLowerCase();
      String[] command = choice.split(" ");
      if (choice.length() == 0 || command.length == 0) {
        System.out.println("Please input a command or type 'help' for options.");
      } else {
        switch (command[0]) {
          case "quit":
            endGame = true;
            break;
          case "look": 
            System.out.println(player.getCurrentLocation().getDescription());
            player.getCurrentLocation().printItemsHere();
            break;
          case "examine": 
            // Check to see if the thing being examined is a person or a thing
            // Always print the description
            // If it's a person, then start the dialog
            // If it's an item, then put the item into inventory
            if (command.length != 2) {
              System.out.println("You mustr specify an object/person to examine");
            }

            String examineName = command[1];
            
            break;
          case "go":
            if (command.length != 2) {
              System.out.println("You must specify a place to go.");
            }
            String name = command[1];
            Location newLocation = player.getCurrentLocation().getNeighbor(name);
            if (newLocation != null) {
              player.setCurrentLocation(newLocation);
            } else {
              System.out.println("Unable to go " + name);
            }
            break;
          case "help":
            printHelpScreen();
            break;
          case "stuff":
            System.out.println("You currently have: ");
            player.printStuff();
            break;
          default:
            System.out.println("Unknown command. Try again");
        }
      }
    }
    input.close();

  }
    
	private static void getIntro(String name) {
		System.out.println("Hello there " + name + " Welcome to GSU!");
		System.out.println("Today is Monday. You've been busy coordinating student tours and doing other extracurricular work for a while now. Your name is well known amongst the student body. You figure you'd start your day right by getting some breakfast from the student center, but when you arrive, things are not how they normally are. The panther statue next to the student center has been defaced in bright red marker and several students have gathered to witness the ensuing madness.");
	}
 
  private static void printHelpScreen() {
    System.out.println("************************");
    System.out.println("look - look around");
    System.out.println("examine <person/item> - talk to people, pick up things");
    System.out.println("go <location> - move to new location");
    System.out.println("stuff - how what you're carrying");
    System.out.println("quit - quit game");
    System.out.println("************************");
  }
  
}