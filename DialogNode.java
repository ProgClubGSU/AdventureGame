import java.util.*;

public class DialogNode {
	private String blurb;
	private Map<String, DialogNode> choices;
	// Whether reaching this dialog node wins/loses the game; most nodes are null
	private Boolean wins = null;
	// TODO: separate constructor for required elements
	private List<Item> required;

	public DialogNode (String blurb, Map<String, DialogNode> choices) {
		this.blurb = blurb;
		this.choices = choices;
	}

	public DialogNode (String blurb, Boolean wins, Map<String, DialogNode> choices) {
		this.blurb = blurb;
		this.choices = choices;
		this.wins = wins;
	}

	public DialogNode (String blurb, Boolean wins, Map<String, DialogNode> choices, List<Item> required) {
		this.blurb = blurb;
		this.choices = choices;
		this.wins = wins;
		this.required = required;
	}
}