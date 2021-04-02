import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class AdventureData {

  public static Character interactIntroSteve (String playerName) {

    Character player = new Character(playerName);

    Character introSteve = new Character("Steve Sminkle");

    introSteve.setScript(
        new DialogNode(
            "You mind if I ask you a few question?",
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "Why do you think it's me?",
                        new DialogNode("Your friend Xavier spotted you at the scene of the crime shortly after the incident " +
                            "took place! Next time you plan on vandalizing school property, give it some thought at least ",
                            new ArrayList<>(
                                List.of(
                                    new SimpleEntry<>(
                                        "Who's Xavier?",
                                        new DialogNode(
                                            "Very funny. The Disciplinary Board is meeting inside the student center as " +
                                                "we speak deciding your fate. You better hope the school doesn't press charges for what you wrote on that statue!"
                                        )
                                    )
                                )
                            )
                        )
                    ),
                    new SimpleEntry<>(
                        "I'm innocent I swear!!",
                        new DialogNode(
                            "Look, kid, if you really didn't do this, you're going to" +
                                "have to find me some kind of evidence. Right now, all teh cards are stacked against you. I've got" +
                                "a witness, Xavier saying they saw you at the scene of the crime at the time in question. Give me" +
                                "something better than that and, I'll hear it out."
                        )
                    ),
                    new SimpleEntry<>(
                        "Awwww, you got me.",
                        new DialogNode("You shrug and Steve begins to turn red. He huffily gets" +
                            "his handcuffs out and arrests you on felony vandalism", false) // first bad end
                    )
                    )
                )
            )
    );

    introSteve.interact(player);
    return player;
  }

  public static boolean loadGameDataAndMC (Character player) {
    // Locations
    Location studentCenter = new Location("Student Center",
        "You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");
    Location langdaleHall = new Location("Langdale Hall",
        "You are at Langdale Hall, also known as the Language Building.");
    Location admissionsOffice = new Location("Admissions Office",
        "You are at the Admissions Office. Steve Sminkle regularly lounges around the Admissions Office seemingly always... looking for something");

    // sublocations
    // General Sublocation - these can exist in any location
    Location vendingMachine = new Location("Vending Machine",
        "You can see all sorts of yummy treats and even your favorite kind of chips");

    // Student Center
    Location cafeteria = new Location("Cafeteria",
        "You see a bunch of tables, some places to purchase breakfast, and a set of stairs that go" +
            " off to where the Disciplinary Board Member is standing angrily.");
    Location cookieStall = new Location("Cookie Stall",
        "You see many boxes of all sorts of baked goods. Glenda sees you looking at her" +
            " products and she smiles proudly.");
    Location pantherStatue = new Location("The Panther Statue",
        "The panther has profanity scrawled all over it in bright red marker.");

    // Langdale Hall
    Location insideLangdale = new Location("Inside Langdale Hall",
        "When you first walk in and step up the stairs, you enter a small elevator lobby with a couple " +
            "of chairs, a vending machine and a student fidgeting with a coffee machine");
    Location downStairs = new Location("Downstairs in Langdale",
        "You find the Janitor's closet and conveniently the Janitor. She demands you exclusively call her by the title");

    // Admissions Office
    Location office = new Location("Admissions Office",
        "You see where people should be working but strangely there's no one here");
    Location hallway = new Location("Admissions Office Hallway",
        "There appears to be a small lounge area with an appropriately small fridge. " +
            "There is also a wall safe containing the CCTV servers");

    //Objects
    // General - These can drop randomly from vending machines
    Item lemon;
    Item persimmon;
    Item papaya;

    // Admissions Office
    Item securityTape = new Item("Security Tape",
        "Shows a vague figure walking towards the student" +
            " center on the night of the incident. You cannot distinguish the face of the person pictured but they " +
            "are noticeably shorter than you or Xavier.");

    // Langdale Hall
    Item keys = new Item("Keys", "Key to the security room");
    Item recountedTestimony = new Item("Recounted Testimony",
        "You now no longer have Xavier’s word against you. This is his recounted testimony.");

    // Student Center
    Item redMarker = new Item("Red Marker",
        "A bright red marker, just like the one used for the crime.");
    Item receiptOfTotalSale = new Item("Receipt of Total Sale",
        "Shows proof that Glenda has been doing considerably well since the incident.");
    Item cookies = new Item("Cookies",
        "Delicious cookies from the cookie stall near the panther statue");

    // Characters
    Character steveSminkle = new Character("Steve Sminkle",
        "Campus Cop and head of the Case. Speaks in a nasally tone.", admissionsOffice);
    Character xavier = new Character("Xavier",
        "Student and alleged witness to the crime. Wears an impressively big jacket. Conveniently with a name tag", insideLangdale);
    Character glenda = new Character("Glenda",
        "Girl Scout with an entrepreneurial spirit. Keeps her cookie stall right by the panther statue. " +
            "9-years-old but nearly has all the badges", cookieStall);
    Character janitor = new Character("The Janitor",
        "She won't let you call her anything else. Loves girl scout cookies.", downStairs);
    Character vault = new Character ("The Wall Safe",
        "This contains all of the security tapes generated from the various CCTV cameras", hallway);

    // Script wiring


    // Location Wiring
    player.setCurrentLocation(insideLangdale);

    office.addPerson(steveSminkle);

    insideLangdale.addPerson(xavier);

    cookieStall.addPerson(glenda);

    downStairs.addPerson(janitor);

    hallway.addPerson(vault);

    // student center
    studentCenter.addNeighbor("further west", admissionsOffice);

    studentCenter.addNeighbor("west", cookieStall);
    cookieStall.addNeighbor("back", studentCenter);

    studentCenter.addNeighbor("inside", cafeteria);
    cafeteria.addNeighbor("outside", studentCenter);

    studentCenter.addNeighbor("south", pantherStatue);
    pantherStatue.addNeighbor("back", studentCenter);

    // langdale hall
    langdaleHall.addNeighbor("further east", admissionsOffice);

    langdaleHall.addNeighbor("inside", insideLangdale);
    insideLangdale.addNeighbor("outside", langdaleHall);

    insideLangdale.addNeighbor("right", vendingMachine);
    vendingMachine.addNeighbor("back", langdaleHall);

    insideLangdale.addNeighbor("downstairs", downStairs);
    downStairs.addNeighbor("upstairs", insideLangdale);

    // admissions office
    admissionsOffice.addNeighbor("further east", studentCenter);
    admissionsOffice.addNeighbor("further west", langdaleHall);

    admissionsOffice.addNeighbor("inside", office);
    office.addNeighbor("outside", admissionsOffice);

    office.addNeighbor("left", hallway);
    hallway.addNeighbor("right", office);

    // Item wiring
    xavier.addToInventory(recountedTestimony);

    janitor.addToInventory(keys);

    glenda.addToInventory(List.of(redMarker, receiptOfTotalSale, cookies));

    vault.addToInventory(securityTape);

    return true;
  }
}
