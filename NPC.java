public class NPC extends Character {
    private DialogNode script;

    public NPC (String name, Location location) {
        super(name, location);
    }

    public void setScript(DialogNode script) {
        this.script = script;
    }
    
      // TODO: interact method for NPCs
      public void interact() {
    
      }
    
    
}
