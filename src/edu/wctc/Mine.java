package edu.wctc;

public class Mine extends Room implements Lootable{
    public Mine() {
        super("The Secret Mine");
    }

    @Override
    public String loot(Player player) {
        player.addToScore(10);
        player.addToInventory("Coins Coins");
        return "You just found the coins in the corner.";
    }

    @Override
    public String getDescription() {
        return "It's dark and cold.";
    }
}
