public class AdventureData {

  public static Character loadGameDataAndMC(String mainCharacterName) {
    // Locations
		Location studentCenter = new Location("Student Center", "You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");
		Location langdaleHall = new Location("Langdale Hall", "You are at Langdale Hall, also known as the Language Building.");
		Location admissionsOffice = new Location("Admissions Office", "");

    Location cafeteria = new Location("Cafeteria", "You see a bunch of tables, some places to purchase breakfast, and a set of stairs that go off to where the Disciplinary Board Member is standing angrily.");
    Location cookieStall = new Location("Cookie Stall", "You see many boxes of all sorts of baked goods. Glenda sees you looking at her products and she smiles proudly.");
    Location pantherStatue = new Location("The Panther Statue", "The panther has profanity scrawled all over it in bright red marker.");

		// Characters
		Character SteveSminkle = new Character("Steve Sminkle", admissionsOffice);
		Character Xavier = new Character("Xavier", langdaleHall);
		Character Glenda = new Character("Glenda", studentCenter);

		//Objects
		Item securityTape = new Item("Security Tape", "Shows a vague figure walking towards the student center on the night of the incident. You cannot distinguish the face of the person pictured but they are noticably shorter than you or Xavier.");
		Item redMarker = new Item("Red Marker", "Evidence");
		Item receiptOfTotalSale = new Item("Receipt of Total Sale", "Evidence");
		Item recountedTestimony = new Item("Recounted Testimony", "Evidence");

		// Wiring
    studentCenter.addItem(securityTape);
    studentCenter.addItem(redMarker);
    studentCenter.addItem(receiptOfTotalSale);

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