package edu.wctc;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private int score;
    private List<String> inventory;

    public Player(){
        // initialize the list of inventory and score
        inventory = new ArrayList<>();
        score = 100;
    }

    // add inventory to player's inventory list.
    public void addToInventory (String invent){
        inventory.add(invent);
    }

    public void addToScore (int points) {
        // add points to score
        score += points;
    }

    public String getInventory () {
        // print out the player's inventory list, list convert to string
        if (inventory.isEmpty())
            System.out.println("Your inventory is empty.");

        return "Your inventory list is: " + String.join("|",inventory);
    }

    public int getScore () {
        // return the Player's score.
        return score;
    }
}
