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
                            "his handcuffs out and arrests you on felony vandalism", false
                        ) // first bad end
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

    // <------------------ SCRIPT WIRING ---------------------->

    //Xavier Script:
    xavier.setScript(
        new DialogNode(
            "\"Oh uh… hey\". - Xavier looks at you nervously.",
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "Why are you lying about me Xavier?",
                        new DialogNode("I-I’m not! Well, I mean… I don’t know. Everything happened so fast…”" +
		                        " he looks down at the floor. “I… I was close to the student center when it happened," +
		                        " I didn’t see it or anything, but that campus cop came up to me all frazzled and started" +
		                        " accusing me! I didn’t know what to do and your name just fell out of my mouth. I’m really" +
		                        " sorry, I didn’t mean to cause trouble.",
                            new ArrayList<>(
                                List.of(
                                    new SimpleEntry<>(
                                        "Cause trouble? They might not let me graduate or worse! Can’t you just tell" +
		                                        " that cop you were lying?",
                                        new DialogNode(
                                            "Hah! Yea right! He’ll just think it was me!” Xavier stands defensively." +
		                                            " “If you can find out who really did it, maybe then I’ll recount my" +
		                                            " testimony, but I don’t want this all to fall on me when there’s" +
		                                            " nowhere left to turn."
                                        )
                                    ),
                                    new SimpleEntry<>(
                                        "Got any idea who DID do it?",
                                        new DialogNode(
                                            "Xavier pauses to think for a moment. “No idea, but maybe you could" +
		                                            " ask Glenda? The girl scout? She’s always at the student center at" +
		                                            " her cookie stall. Maybe she saw something."
                                        )
                                    )
                                )
                            )
                        )
                    ),
                    new SimpleEntry<>(
                        "You did it didn’t you! I’ll get you for this!!!",
                        new DialogNode(
                            "Huh, what? No! I swear!” Xavier runs off. It’s probably going to be pretty hard to" +
		                            " prove your innocence without his recounted testimony.", false
                        ) //Second bad end
                    ),
		                new SimpleEntry<>(
				                "Here, look at this red marker",
				                new DialogNode(
				                		"Woah… you got this from Glenda? This looks just like the kind of marker used on" +
								                " the statue! But it isn’t enough by itself… Why would she do something like that?",
						                null,
						                new ArrayList<>(),
						                List.of(redMarker)
				                )
		                )
                )
            )
        )
    );

    // Glenda Script:
    glenda.setScript(
        new DialogNode(
            "Hey there! Would you like to buy some cookies?",
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "Sure",
                        new DialogNode(
                            "You get some cookies from the stall. Glenda nearly sheds a tear. \"Thanks for your business!\""
                        ) //ITEM RECIEVE ---fix
                    ),
                    new SimpleEntry<>(
                        "Do you know anything about the incident?",
                        new DialogNode(
                            "Glenda smiles innocently. \"Nope! Of course not. I’m literally 9-years-old, how could I do something oh-so-horrid?\"")
                    ),
                    new SimpleEntry<>(
                        "How's business?",
                        new DialogNode(
                            "Glenda brightens up and proudly proclaims, \"Business has been great! It’s really been booming since this morning. You know, cause like, the panther and all. People are really fascinated.\"",
                            new ArrayList<>(
                                List.of(


                                    //<--------------Work on the obtains!!-------------------->

                                    new SimpleEntry<>(
                                        "I’ve got some free time if you need any help with anything.",
                                        new DialogNode(
                                            "\"That would be great! I’ve been swamped with all the business, but I want to be MORE swamped! Could you make some flyers for me? I’d really appreciate it.\"")
                                    ),
                                    new SimpleEntry<>(
                                        "How would you like to be nominated for the annual uh… 9-year-olds of entrepreneurial excellence award?",
                                        new DialogNode(
                                            "\"Oh boy would I!!\" You sneakily tell Glenda you’ll need proof of all the incredible sales she’s been making. She happily reaches into her little makeshift register and pulls out the Receipt of Total Sale.")
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    );


    // Steve Sminkle Script:
    steveSminkle.setScript(
        new DialogNode(
            "You got some nerve showing up here. What do you want?",
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "Security footage?",
                        new DialogNode("I’m not partial to helping criminals. But… come to think of it, the security footage SHOULD show you at the scene of the crime. If only I could find the keys to the safe. Oh well! Good luck, kid.")
                    ),
                    new SimpleEntry<>(
                        "I've got evidence for you.",
                        new DialogNode("Well what are you waiting for? Give it to me.")
                    )


                    //<--------------Work on the give!!-------------------->
                )
            )
        )
    );


    // Janitor Script:
    janitor.setScript(
        new DialogNode(
            "\"Please, call me The Janitor. What can I do for you?\"",
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "No no, what can I do for YOU?",
                        new DialogNode("\"Well, I am pretty hungry. Some of those girl scout cookies would really hit the spot. If you can grab some for me, I can give you these keys I found on the ground. I don’t know what they go to so they’re essentially useless but hey, seems fair to me.\"")

                    ),
                    new SimpleEntry<>(
                        "You sure you wouldn’t rather go by your name?",
                        new DialogNode("\"Look, how about you let me do me and I’ll let you do you yea?\"")
                    )
                )
            )
        )
    );


    // Location Wiring
    player.setCurrentLocation(langdaleHall);  // starting position is langdale for the player

    admissionsOffice.addPerson(steveSminkle);

    insideLangdale.addPerson(xavier);

    cookieStall.addPerson(glenda);

    downStairs.addPerson(janitor);

    studentCenter.addNeighbor("further west", admissionsOffice);
    admissionsOffice.addNeighbor("further east", studentCenter);

    studentCenter.addNeighbor("west", cookieStall);
    cookieStall.addNeighbor("back", studentCenter);
    studentCenter.addNeighbor("north", cafeteria);
    cafeteria.addNeighbor("outside", studentCenter);
    studentCenter.addNeighbor("south", pantherStatue);
    pantherStatue.addNeighbor("back", studentCenter);

    langdaleHall.addNeighbor("further east", admissionsOffice);
    admissionsOffice.addNeighbor("further west", langdaleHall);

    return true;
  }
}
