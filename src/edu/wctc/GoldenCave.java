package edu.wctc;

public class GoldenCave extends Room implements Lootable,Exitable{

    public GoldenCave(){
        super("Golden Cave");
    }

    @Override
    public String loot(Player player) {
        player.addToScore(30);
        player.addToInventory("Gold coins");
        return "You just opened the chest and collected the gold coins!";
    }

    @Override
    public String getDescription() {
        return "There is a chest here";
    }

    @Override
    public String exit(Player player) {
        return "You have left " + getName() + ", and you have finished the maze.";
    }
}
