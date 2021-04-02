import java.util.*;

public class DialogNode {
  private final String blurb;
  private final Map<String, DialogNode> choices;
  // Whether reaching this dialog node wins/loses the game; most nodes are null
  private final Boolean wins;
  // this is an item that will be given as a reward for hitting this particular dialogue
  // in most cases, this will also be null
  private final Item reward;

  private List<Item> required = new ArrayList<>();

  public DialogNode (String blurb, Map<String, DialogNode> choices) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = null;
    this.reward = null;
  }

  public DialogNode (String blurb, Boolean wins, Map<String, DialogNode> choices) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.reward = null;
  }

  public DialogNode (String blurb, Boolean wins, Map<String, DialogNode> choices, List<Item> required) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.required = required;
    this.reward = null;
  }

  public DialogNode(String blurb, Boolean wins, Map<String, DialogNode> choices, List<Item> required, Item reward) {
    this.blurb = blurb;
    this.choices = choices;
    this.wins = wins;
    this.required = required;
    this.reward = reward;
  }

  public Item getReward() {
    return this.reward;
  }

  public List<Item> getRequired () {
    return required;
  }

  public Map<String, DialogNode> getChoices () {
    return choices;
  }

  public String getBlurb () {
    return blurb;
  }
}
