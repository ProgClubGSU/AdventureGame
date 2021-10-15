import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class CharacterData {
	// Characters
	public static Character steveSminkle = new Character("Steve Sminkle",
			"Campus Cop and head of the Case. Speaks in a nasally tone.", LocationData.admissionsOffice);
	public static Character xavier = new Character("Xavier",
			"Student and alleged witness to the crime. Wears an impressively big jacket. Conveniently with a name tag", LocationData.insideLangdale);
	public static Character glenda = new Character("Glenda",
			"Girl Scout with an entrepreneurial spirit. Keeps her cookie stall right by the panther statue. " +
					"9-years-old but nearly has all the badges", LocationData.cookieStall);
	public static Character janitor = new Character("The Janitor",
			"She won't let you call her anything else. Loves girl scout cookies.", LocationData.downStairs);
	public static Character vault = new Character("The Wall Safe",
			"This contains all of the security tapes generated from the various CCTV cameras", LocationData.hallway);
	public static Character DBM = new Character("Disciplinary Board Member","A very angry looking man. Quick to accuse, slow to forgive.",LocationData.cafeteria);

	public static boolean loadCharacterData () {
		// Scripts wiring

		//Xavier Script:
		xavier.setScript(
				new DialogNode(
						"Oh uh… hey. - Xavier looks at you nervously.",
						null,
						new ArrayList<>(
								List.of(
										new AbstractMap.SimpleEntry<>(
												"Why are you lying about me Xavier?",
												new DialogNode(
														"I-I'm not! Well, I mean… I don't know. Everything happened so fast…" +
																" he looks down at the floor. I… I was close to the student center when it happened," +
																" I didn't see it or anything, but that campus cop came up to me all frazzled and started" +
																" accusing me! I didn't know what to do and your name just fell out of my mouth. I'm really" +
																" sorry, I didn't mean to cause trouble.",
														null,
														new ArrayList<>(
																List.of(
																		new AbstractMap.SimpleEntry<>(
																				"Cause trouble? They might not let me graduate or worse! Can't you just tell" +
																						" that cop you were lying?",
																				new DialogNode(
																						"Hah! Yea right! He'll just think it was me! Xavier stands defensively." +
																								" If you can find out who really did it, maybe then I'll recount my" +
																								" testimony, but I don't want this all to fall on me when there's" +
																								" nowhere left to turn."
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"Got any idea who DID do it?",
																				new DialogNode(
																						"Xavier pauses to think for a moment. No idea, but maybe you could" +
																								" ask Glenda? The girl scout? She's always at the student center at" +
																								" her cookie stall. Maybe she saw something."
																				)
																		)
																)
														)
												)
										),
										new AbstractMap.SimpleEntry<>(
												"You did it didn't you! I'll get you for this!!!",
												new DialogNode(
														"Huh, what? No! I swear!” Xavier runs off. It's probably going to be pretty hard to" +
																" prove your innocence without his recounted testimony.",
														false
												) //Second bad end
										),
										new AbstractMap.SimpleEntry<>(
												"Here, look at this red marker",
												new DialogNode(
														"Woah… you got this from Glenda? This looks just like the kind of marker used on" +
																" the statue! But it isn't enough by itself… Why would she do something like that?",
														null,
														new ArrayList<>(),
														List.of(ItemData.redMarker)
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
						null,
						new ArrayList<>(
								List.of(
										new AbstractMap.SimpleEntry<>(
												"Sure",
												new DialogNode(
														"You get some cookies from the stall. Glenda nearly sheds a tear. Thanks for your business!",
														ItemData.cookies
												)
										),
										new AbstractMap.SimpleEntry<>(
												"Do you know anything about the incident?",
												new DialogNode(
														"Glenda smiles innocently. Nope! Of course not. I'm literally 9-years-old," +
																" how could I do something oh-so-horrid?"
												)
										),
										new AbstractMap.SimpleEntry<>(
												"How's business?",
												new DialogNode(
														"Glenda brightens up and proudly proclaims, Business has been great! It's really " +
																"been booming since this morning. You know, cause like, the panther and all." +
																" People are really fascinated.",
														null,
														new ArrayList<>(
																List.of(
																		new AbstractMap.SimpleEntry<>(
																				"I've got some free time if you need any help with anything.",
																				new DialogNode(
																						"That would be great! I've been swamped with all the business," +
																								" but I want to be MORE swamped! Could you make some flyers for me?" +
																								" I'd really appreciate it.",
																						ItemData.redMarker
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"How would you like to be nominated for the annual uh…" +
																						" 9-year-olds of entrepreneurial excellence award?",
																				new DialogNode(
																						"Oh boy would I!! You sneakily tell Glenda you'll need proof of all" +
																								" the incredible sales she's been making. She happily reaches" +
																								" into her little makeshift register and pulls out the Receipt of Total Sale.",
																						ItemData.receiptOfTotalSale
																				)
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
						null,
						new ArrayList<>(
								List.of(
										new AbstractMap.SimpleEntry<>(
												"Security footage?",
												new DialogNode("I'm not partial to helping criminals. " +
														"But… come to think of it, the security footage SHOULD show you at the scene" +
														" of the crime. If only I could find the keys to the safe. Oh well! Good luck, kid."
												)
										),
										new AbstractMap.SimpleEntry<>(
												"I've got evidence for you.",
												new DialogNode(
														"Well what are you waiting for? Give it to me.",
														true,
														new ArrayList<>(
																List.of(
																		new AbstractMap.SimpleEntry<>(
																				"Here's a Red Marker",
																				new DialogNode(
																						"Huh? What good is this?",
																						List.of(ItemData.redMarker)
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"Here's the total Glenda has earned",
																				new DialogNode(
																						"Well now I'm just hungry",
																						List.of(ItemData.receiptOfTotalSale)
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"Here's Xavier's recounted testimony",
																				new DialogNode(
																						"Steve is speechless",
																						List.of(ItemData.recountedTestimony)
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"Here's the Security Tape",
																				new DialogNode(
																						"Well you certainly look... taller in person.",
																						List.of(ItemData.securityTape)
																				)
																		),
																		new AbstractMap.SimpleEntry<>(
																				"Based on the evidence I've gathered, I believe Glenda is the true culprit",
																				new DialogNode(
																						"Steve can hardly believe his eyes but he also cannot refute" +
																								" the evidence before him. He closes his eyes, sighs, and nods." +
																								" Sorry for the confusion. No hard feelings right?" +
																								" He doesn’t wait for your response and presumably heads" +
																								" towards the Student Center to apprehend the real criminal.",
																						List.of(ItemData.redMarker, ItemData.receiptOfTotalSale, ItemData.recountedTestimony, ItemData.securityTape)
																				) // Win Condition
																		)
																)
														)
												)
										)
								)
						)
				)
		);


		// Janitor Script:
		janitor.setScript(
				new DialogNode(
						"Please, call me The Janitor. What can I do for you?",
						null,
						new ArrayList<>(
								List.of(
										new AbstractMap.SimpleEntry<>(
												"No no, what can I do for YOU?",
												new DialogNode(
														"Well, I am pretty hungry. Some of those girl scout cookies would really hit the spot." +
																" If you can grab some for me, I can give you these keys I found on the ground." +
																" I don't know what they go to so they're essentially useless but hey, seems fair to me."
												)
										),
										new AbstractMap.SimpleEntry<>(
												"Here are the cookies you wanted",
												new DialogNode(
														"Here's the keys I promised, use the wisely",
														List.of(ItemData.cookies),
														ItemData.keys
												)
										),
										new AbstractMap.SimpleEntry<>(
												"You sure you wouldn't rather go by your name?",
												new DialogNode("Look, how about you let me do me and I'll let you do you yea?")
										)
								)
						)
				)
		);
		vault.setScript(
			new DialogNode(
				"The wall safe is locked. Drat.",
				null,
				List.of(
					new AbstractMap.SimpleEntry<>(
						"Try to pick the lock",
						new DialogNode(
							"You don't know how to pick locks. What were you expecting?"
						)
					),
					new AbstractMap.SimpleEntry<>(
						"Use keys",
						new DialogNode(
							"The key turns and the safe door swings open.",
							List.of(ItemData.keys),
							ItemData.securityTape
						)
					)
				)
			)
		);
		DBM.setScript(
			new DialogNode("Hey! Can't you see I'm busy? Here, entertain yourself with this.",ItemData.poolNoodle)
		);
		return true;
	}
}