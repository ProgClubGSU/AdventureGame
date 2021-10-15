import java.util.List;

public class ItemData {
	//Objects
	// General - These can drop randomly from vending machines
	public static Item lemon;
	public static Item persimmon;
	public static Item papaya;

	// Admissions Office
	public static Item securityTape = new Item("Security Tape",
			"Shows a vague figure walking towards the student" +
					" center on the night of the incident. You cannot distinguish the face of the person pictured but they " +
					"are noticeably shorter than you or Xavier.");

	// Langdale Hall
	public static Item keys = new Item("Keys", "Key to the security room");
	public static Item recountedTestimony = new Item("Recounted Testimony",
			"You now no longer have Xavier's word against you. This is his recounted testimony.");

	// Student Center
	public static Item redMarker = new Item("Red Marker",
			"A bright red marker, just like the one used for the crime.");
	public static Item receiptOfTotalSale = new Item("Receipt of Total Sale",
			"Shows proof that Glenda has been doing considerably well since the incident.");
	public static Item cookies = new Item("Cookies",
			"Delicious cookies from the cookie stall near the panther statue");
	public static Item poolNoodle = new Item("Pool Noodle","There isn't even any water around, you don't know why you have this.");

	public static boolean loadItemData() {
		// Item wiring
		CharacterData.xavier.addToInventory(recountedTestimony);

		CharacterData.janitor.addToInventory(keys);

		CharacterData.glenda.addToInventory(List.of(redMarker, receiptOfTotalSale, cookies));

		CharacterData.vault.addToInventory(securityTape);

		CharacterData.DBM.addToInventory(poolNoodle);
		return true;
	}
}
