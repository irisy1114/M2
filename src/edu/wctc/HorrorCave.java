package edu.wctc;

public class HorrorCave extends Room implements Interactable{
    public HorrorCave() {
        super("Horror Cave");
    }

    @Override
    public String interact(Player player) {
        player.addToScore(player.getScore() - 20);
        return "You crawled into a deep dark horror cave, there's a lot of bats here!";
    }

    @Override
    public String getDescription() {
        return "It smells bad and bloody here.";
    }
}
