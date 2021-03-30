public class AdventureData {

  public static Character loadGameDataAndMC(String mainCharacterName) {
    // Locations
		Location studentCenter = new Location("Student Center", "You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");
		Location langdaleHall = new Location("Langdale Hall", "You are at Langdale Hall, also known as the Language Building.");
		Location admissionsOffice = new Location("Admissions Office", "");

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

    return new Character(mainCharacterName, studentCenter);
  }
}