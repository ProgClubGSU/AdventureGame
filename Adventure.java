import java.util.*;

public class Adventure {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);

    // Player name and game introduction
    Character player = playIntro(input);

    if (!AdventureData.loadGameDataAndMC(player)) {
      System.out.println("Something broke in the game engine that shouldn't be possible");
      System.exit(-1);
    }

    String choice;
    boolean endGame = false;
    while (!endGame) {
      player.getCurrentLocation().printInfo();
      System.out.print("What would you like to do? ");
      choice = input.nextLine().toLowerCase();
      String[] command = choice.split(" ", 2);
      if (choice.length() == 0 || command.length == 0) {
        System.out.println("Please input a command or type 'help' for options.");
      }
      else {
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
              System.out.println("You must specify an object/person to examine");
            }
            String examineName = command[1];

            Item possibleItem = player.getCurrentLocation().containItem(examineName);
            if (possibleItem != null) {
              System.out.println(possibleItem.getDescription());

              // add into inventory
              player.addToInventory(possibleItem);
              // TODO: remove object from world
            }

            Character possiblCharacter = player.getCurrentLocation().containCharacter(examineName);
            if (possiblCharacter != null) {
              System.out.println(possiblCharacter.getDescription());

              // Start interaction
              possiblCharacter.interact(player);
            }

            break;
          case "go":
            if (command.length != 2) {
              System.out.println("You must specify a place to go.");
            }
            String name = command[1];
            Location newLocation = player.getCurrentLocation().getNeighbor(name);
            if (newLocation != null) {
              player.setCurrentLocation(newLocation);
            }
            else {
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

  private static Character playIntro (Scanner input) {
    System.out.println("Today is Monday. You've been busy coordinating student tours and doing other" +
        " extracurricular work for a while now. Your name is well known amongst the student body. You figure" +
        " you'd start your day right by getting some breakfast from the student center but, when you arrive" +
        " things are not how they normally are. The panther statue next to the student center has been " +
        "defaced in bright red marker and several students have gathered to witness the ensuing madness.\n Press ENTER");

    input.nextLine();

    System.out.println("You hear a nasally tone rise above the crowd of students, most of whom are busy taking" +
        " pictures or buying girl scout cookies from the nearby cookie stall. A rather irritated looking man" +
        " parts the students and walks with purpose towards you.\n Press ENTER");

    input.nextLine();

    System.out.println("The man introduces himself as Steve Sminkle, Campus Cop.\n Press ENTER");

    input.nextLine();

    System.out.println("Steve Sminkle: You mind if I ask you a few questions?");

    System.out.println("He doesn't pause to let you answer and instead immediately inquires");

    System.out.println("Steve Sminkle: What's your name?");
    System.out.println("Enter your name: ");

    String name = input.nextLine().trim();  // player name

    // Setup IntroSteve OR Just ask adventure data to instantiate IntroSteve and interact
    return AdventureData.interactIntroSteve(name);
  }

  private static void printHelpScreen () {
    System.out.println("************************");
    System.out.println("look - look around");
    System.out.println("examine <person/item> - talk to people, pick up things");
    System.out.println("go <location> - move to new location");
    System.out.println("stuff - show what you're carrying");
    System.out.println("quit - quit game");
    System.out.println("************************");
  }

}
