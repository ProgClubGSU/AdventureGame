import java.util.*;

public class AdventureData {

	public static void interactIntroSteve() {

		Character IntroSteve = new Character("Steve Sminkle");

		IntroSteve.setScript(
				new DialogNode(
						"You mind if I ask you a few question?",
						Map.of(
								"Why do you think it's me?",
								new DialogNode("Your friend Xavier spotted you at the scene of the crime shortly after the incident " +
										"took place! Next time you plan on vandalizing school property, give it some thought at least ",
										Map.of("Who's Xavier?",
												new DialogNode("Very funny. The Disciplinary Board is meeting inside the student " +
														"center as we speak deciding your fate. You better hope the school doesn't press charges for what you wrote on that statue!",
														Map.of()
												)
										)
								),
								"I'm innocent I swear!!", new DialogNode("Look, kid, if you really didn't do this, you're going to" +
										"have to find me some kind of evidence. Right now, all teh cards are stacked against you. I've got" +
										"a witness, Xavier saying they saw you at the scene of the crime at the time in question. Give me" +
										"something better than that and, I'll hear it out.", Map.of()),
								"Awwww, you got me.", new DialogNode("You shrug and Steve begins to turn red. He huffily gets" +
										"his handcuffs out and arrests you on felony vandalism", false, Map.of()) // first bad end
						)
				)

		);

	}

	public static Character loadGameDataAndMC (String mainCharacterName) {
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
		Item recountedTestimony = new Item("Recounted Testimony", "Evidence");

		// Student Center
		Item redMarker = new Item("Red Marker", "Evidence");
		Item receiptOfTotalSale = new Item("Receipt of Total Sale", "Evidence");

		// Characters
		Character SteveSminkle = new Character("Steve Sminkle", admissionsOffice);
		Character Xavier = new Character("Xavier", langdaleHall);
		Character Glenda = new Character("Glenda", cookieStall);
		Character Janitor = new Character("The Janitor", downStairs);

		// Script wiring

		// Location Wiring
		studentCenter.addPerson(SteveSminkle);

		langdaleHall.addPerson(Xavier);

		cookieStall.addPerson(Glenda);

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

		return new Character(mainCharacterName, studentCenter);
	}
}