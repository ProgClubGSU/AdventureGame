import java.util.Scanner;

public class Adventure {
  
  public static void printMenu() {
    System.out.println("************************");
    System.out.println("L - look around");
    System.out.println("X - exit location");
    System.out.println("A - add item to inventory");
    System.out.println("D - drop item");
    System.out.println("I - inventory");
    System.out.println("E - examine item");
    System.out.println("Q - quit game");
    System.out.println("************************");
  }

	public static void getIntro(String name) {
		System.out.println("Hello there " + name + " Welcome to GSU!");
		System.out.println("Today is Monday. You've been busy coordinating student tours and doing other extracurricular work for a while now. Your name is well known amongst the student body. You figure you'd start your day right by getting some breakfast from the student center, but when you arrive, things are not how they normally are. The panther statue next to the student center has been defaced in bright red marker and several students have gathered to witness the ensuing madness.");
	}
  
  public static void main(String[] args) {
    
    String choice = "";
    Boolean quit = false;

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter you name:");

    //All Locations
		Location studentCenter = new Location("Student Center", "You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");
		Location langdaleHall = new Location("Langdale Hall", "2");
		Location admissionsOffice = new Location("Admissions Office", "");

		//Main characters
		Character mainPlayer = new Character(input.nextLine(), studentCenter);
		Character SteveSminkle = new Character("Steve Sminkle", admissionsOffice);
		Character Xavier = new Character("Xavier", langdaleHall);
		Character Glenda = new Character("Glenda", studentCenter);
 
		//Objects
		Item securityTape = new Item("Security Tape", "Shows a vague figure walking towards the student center on the night of the incident. You cannot distinguish the face of the person pictured but they are noticably shorter than you or Xavier.");
		Item redMarker = new Item("Red Marker", "Evidence");
		Item receiptOfTotalSale = new Item("Receipt of Total Sale", "Evidence");
		Item recountedTestimony = new Item("Recounted Testimony", "Evidence");

		//Starting at Student Center Location
		mainPlayer.setCurrentLocation(studentCenter);
    mainPlayer.getCurrentLocation();
		
		//Game introduction
		getIntro(mainPlayer.getName());

		//List of Evidence:
    studentCenter
      .addItem(securityTape)
      .addItem(redMarker)
      .addItem(receiptOfTotalSale);

    studentCenter.printItemsHere();
    
  while (quit != true) {
    System.out.println("What is your choice?");
    System.out.println("Type M for menu.");
    choice = input.nextLine();
    if (choice.equals("L") || choice.equals("l")) {
      mainPlayer.getCurrentLocation();
    } else if (choice.equals("E") || choice.equals("e")) {
      System.out.println("What item would you like to examine?");
      choice = input.nextLine();
    } else if (choice.equals("M") || choice.equals("m")) {
      printMenu();
    } else if (choice.equals("Q") || choice.equals("q")) {
      quit = true;
    } else if (choice.equals("X") || choice.equals("x")) {
      System.out.println("Where would you like to go?");
      choice = input.nextLine();
    } else if (choice.equals("I") || choice.equals("i")) {
      System.out.println("You currently have: ");
    } else {
      System.out.println("That's not a valid choice.");
    }
  }
  input.close();

  }
}