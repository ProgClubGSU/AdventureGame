import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class AdventureData {

  private static Boolean introCompleted = false;

  public static Character interactIntroSteve (String playerName) {

    Character player = new Character(playerName);

    Character introSteve = new Character("Steve Sminkle");

    introSteve.setScript(
        new DialogNode(
            "You mind if I ask you a few question?",
            null,
            new ArrayList<>(
                List.of(
                    new SimpleEntry<>(
                        "Why do you think it's me?",
                        new DialogNode(
                            "Your friend Xavier spotted you at the scene of the crime shortly after the incident " +
                                "took place! Next time you plan on vandalizing school property, give it some thought at least ",
                            null,
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
                            "his handcuffs out and arrests you on felony vandalism",
                            false
                        ) // first bad end
                    )
                )
            )
        )

    );

    if (!introSteve.interact(player)) {
      return null;
    }

    return player;
  }

  public static boolean loadGameDataAndMC (Character player) {
    boolean success = LocationData.loadLocationData();
    success &= CharacterData.loadCharacterData();
    success &= ItemData.loadItemData();

    // Set player location
    player.setCurrentLocation(LocationData.insideLangdale);

    return success;
  }
}
