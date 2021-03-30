import java.util.Scanner;

class Adventure {
  
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

    Scanner scan = new Scanner(System.in);
    System.out.print("Please enter you name:");

		//Main characters
		Player mainPlayer = new Player(scan.nextLine());
		Player SteveSminkle = new Player("Steve Sminkle");
		Player Xavier = new Player("Xavier");
		Player Glenda = new Player("Glenda");
    
    //All Locations
		Location studentCenter = new Location("Student Center", "1",1,2,3,4);
		Location languageHall = new Location("Language Hall", "2",1,2,3,4);
		Location AdmissionsOffice = new Location("Admissions Office", "3",1,2,3,4);

		//Objects
		Item Security_Tape = new Item("Security Tape", "Evidence");
		Item Red_marker = new Item("Red Marker", "Evidence");
		Item receiptOfTotalSale = new Item("Receipt of Total Sale", "Evidence");
		Item recountedTestimony = new Item("Recounted Testimony", "Evidence");

		//Starting at Student Center Location
		mainPlayer.setCurrentLocation(studentCenter);
    mainPlayer.getCurrentLocation();
		
		//Game introduction
		getIntro(mainPlayer.getName());
    studentCenter.setDescription("You are at the Student Center. Here is the scene of the crime and Glenda the girl scout's usual cookie stall location.");

		//List of Evidence:
    Security_Tape.setDescription("Shows a vague figure walking towards the student center on the night of the incident. You cannot distinguish the face of the person pictured but they are noticably shorter than you or Xavier.");
    studentCenter.addObject(Security_Tape, 0);
    studentCenter.addObject(Red_marker, 1);

    studentCenter.addObject(receiptOfTotalSale, 2);
		languageHall.addObject(Security_Tape, 4);

    studentCenter.printItemsHere();
    
  Scanner input = new Scanner(System.in);
  
  /*public static void LookAround(){
    System.out.println("Any clues");
  }*/
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
    
  }
}