import java.util.*;

public class DialogNode {
  private final String blurb;
  private final List<AbstractMap.SimpleEntry<String, DialogNode>> choices;
  // Whether reaching this dialog node wins/loses the game; most nodes are null
  private final Boolean wins;
  // this is an item that will be given as a reward for hitting this particular dialogue
  // in most cases, this will also be null
  private final Item reward;

  private List<Item> required = new ArrayList<>();

  public DialogNode (String blurb) {
    this.blurb = blurb;
    this.choices = new ArrayList<>();
    this.wins = null;
    this.reward = null;
  }

  public DialogNode (String blurb, boolean b) {
    this.blurb = blurb;
    this.choices = new ArrayList<>();
    this.wins = b;
    this.reward = null;
  }

  public DialogNode (String blurb, List<AbstractMap.SimpleEntry<String, DialogNode>> choices) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = null;
    this.reward = null;
  }

  public DialogNode (String blurb, Boolean wins, List<AbstractMap.SimpleEntry<String, DialogNode>> choices) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.reward = null;
  }

  public DialogNode (String blurb, Boolean wins, List<AbstractMap.SimpleEntry<String, DialogNode>> choices, List<Item> required) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.required = required;
    this.reward = null;
  }

  public DialogNode(String blurb, Boolean wins, List<AbstractMap.SimpleEntry<String, DialogNode>> choices, List<Item> required, Item reward) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.required = required;
    this.reward = reward;
  }

  public Boolean getWin() { return this.wins; }

  public Item getReward() {
    return this.reward;
  }

  public List<Item> getRequired () {
    return required;
  }

  public List<AbstractMap.SimpleEntry<String, DialogNode>> getChoices () {
    return choices;
  }

  public String getBlurb () {
    return blurb;
  }
}
