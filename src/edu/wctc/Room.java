package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;

    // A constructor that accepts a String for the name of the Room.
    public Room (String name) {
        this.name = name;
    }

    // An abstract method named getDescription that returns a String.
    public abstract String getDescription ();

    // If this Room is connected to another Room in the given direction, that Room is returned.
    // Otherwise, return null.
    public Room getAdjoiningRoom (char direction) {
        switch (direction)
        {
            case 'n':
                return north;
            case 'w':
                return west;
            case 'e':
                return east;
            case 's':
                return south;
            case 'u':
                return up;
            case 'd':
                return down;
            default:
                return null;
        }
    }

    // A method named getExits that returns a String.
    // The String should be a list of all the directions the Player could exit from this Room to another Room.
    public String getExits() {
        var exits = "";
        if(up!=null) exits+="Up";
        if(down!=null) exits+=" Down";
        if(east!=null) exits+=" East";
        if(west!=null) exits+=" West";
        if(north!=null) exits+=" North";
        if(south!=null) exits+=" South";

        //if(exits=="") exits="There is no exit available in this room.";
        return exits;
    }

    public String getName () {
        return name;
    }

    // If this Room is connected to another Room in the given direction, return true.
    // Otherwise, return false.
    public boolean isValidDirection (char cha) {
        var room = getAdjoiningRoom(cha);
        return room!=null;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

}
