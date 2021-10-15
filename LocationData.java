public class LocationData {
	// Locations
	public static Location studentCenter = new Location("Student Center",
			"You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");
	public static Location langdaleHall = new Location("Langdale Hall",
			"You are at Langdale Hall, also known as the Language Building.");
	public static Location admissionsOffice = new Location("Admissions Office",
			"You are at the Admissions Office. Steve Sminkle regularly lounges around the Admissions Office seemingly always... looking for something");
	public static Location greenway = new Location("Greenway",
			"This pretty park is much better than the old building that used to be here." +
			" You notice a Seated Student near a tree, studying.");
	// sublocations
	// General Sublocation - these can exist in any location
	public static Location vendingMachine = new Location("Vending Machine",
			"You can see all sorts of yummy treats and even your favorite kind of chips");

	// Student Center
	public static Location cafeteria = new Location("Cafeteria",
			"You see a bunch of tables, some places to purchase breakfast, and a set of stairs that go" +
					" off to where the Disciplinary Board Member is standing angrily.");
	public static Location cookieStall = new Location("Cookie Stall",
			"You see many boxes of all sorts of baked goods. Glenda sees you looking at her" +
					" products and she smiles proudly.");
	public static Location pantherStatue = new Location("The Panther Statue",
			"The panther has profanity scrawled all over it in bright red marker.");

	// Langdale Hall
	public static Location insideLangdale = new Location("Inside Langdale Hall",
			"When you first walk in and step up the stairs, you enter a small elevator lobby with a couple " +
					"of chairs, a vending machine and a student fidgeting with a coffee machine. His nametag states \"Xavier\"");
	public static Location downStairs = new Location("Downstairs in Langdale",
			"You find the Janitor's closet and conveniently the Janitor. She demands you exclusively call her by the title");

	// Admissions Office
	public static Location office = new Location("Admissions Office",
			"You see where people should be working but strangely there's no one here");
	public static Location hallway = new Location("Admissions Office Hallway",
			"There appears to be a small lounge area with an appropriately small fridge. " +
					"There is also a wall safe containing the CCTV servers");

	// Greenway
	public static Location bench = new Location("Bench",
			"You could take a quick rest. The mystery doesn't seem like it's going anywhere.");

	public static boolean loadLocationData() {
		office.addPerson(CharacterData.steveSminkle);

		insideLangdale.addPerson(CharacterData.xavier);

		cookieStall.addPerson(CharacterData.glenda);

		downStairs.addPerson(CharacterData.janitor);

		hallway.addPerson(CharacterData.vault);

		greenway.addPerson(CharacterData.seatedStudent);

		// student center
		studentCenter.addNeighbor("further west", admissionsOffice);

		studentCenter.addNeighbor("northwest", greenway);

		studentCenter.addNeighbor("west", cookieStall);
		cookieStall.addNeighbor("back", studentCenter);

		studentCenter.addNeighbor("inside", cafeteria);
		cafeteria.addNeighbor("outside", studentCenter);

		studentCenter.addNeighbor("south", pantherStatue);
		pantherStatue.addNeighbor("back", studentCenter);

		// langdale hall
		langdaleHall.addNeighbor("further east", admissionsOffice);
		
		langdaleHall.addNeighbor("northeast", greenway);

		langdaleHall.addNeighbor("inside", insideLangdale);
		insideLangdale.addNeighbor("outside", langdaleHall);
		insideLangdale.addNeighbor("backdoor", greenway);

		insideLangdale.addNeighbor("right", vendingMachine);
		vendingMachine.addNeighbor("back", langdaleHall);

		insideLangdale.addNeighbor("downstairs", downStairs);
		downStairs.addNeighbor("upstairs", insideLangdale);

		// admissions office
		admissionsOffice.addNeighbor("further east", studentCenter);
		admissionsOffice.addNeighbor("further west", langdaleHall);
		admissionsOffice.addNeighbor("south", greenway);

		admissionsOffice.addNeighbor("inside", office);
		office.addNeighbor("outside", admissionsOffice);

		office.addNeighbor("left", hallway);
		hallway.addNeighbor("right", office);

		// greenway
		greenway.addNeighbor("southwest", langdaleHall);
		greenway.addNeighbor("southeast", studentCenter);
		greenway.addNeighbor("north", admissionsOffice);
		greenway.addNeighbor("upstairs", insideLangdale);

		greenway.addNeighbor("sit down", bench);
		bench.addNeighbor("get up", greenway);
		bench.addNeighbor("wait", bench);

		return true;
	}
}
