package edu.wctc;

public class SecretCave extends Room implements Interactable, Exitable{
    public SecretCave() {
        super("Secret Cave");
    }

    @Override
    public String interact(Player player) {
        player.addToScore(-20);
        return "You just found the secret sleeping dragon, don't wake it up!";
    }

    @Override
    public String getDescription() {
        return "You are in the tunnel to outside .";
    }

    @Override
    public String exit(Player player) {
        return "You have left " + getName() + ", and you have finished the maze.";
    }
}
