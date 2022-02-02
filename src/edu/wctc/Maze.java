package edu.wctc;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished;


    // The Maze constructor include a player object, and all of the room objects
    // set the current room and each room correspondingly
    public Maze (Player player) {
        this.player = player;
        var mine = new Mine();
        this.currentRoom = mine;

        // secret cave up above the mine
        var secretCave = new SecretCave();
        mine.setUp(secretCave);
        secretCave.setDown(mine);

        // golden cave is up above the secret cave
        var goldenCave = new GoldenCave();
        secretCave.setUp(goldenCave);
        goldenCave.setDown(secretCave);

        // horror cave is on the east of the secret cave
        var horrorCave = new HorrorCave();
        secretCave.setEast(horrorCave);
        horrorCave.setWest(secretCave);
    }

    // If the currentRoom is an Exit, it returns the result of calling exit() on the Room.
    // If not, it returns a message that the current room is not exitable.
    public String exitCurrentRoom () {
        if (currentRoom instanceof Exitable)
            return ((Exitable) currentRoom).exit(player);
        return "Room [" + currentRoom.getName() + "] is not exitable";
    }

    // If the currentRoom is Interactable, it returns the result of calling interact on the Room.
    // If not, it returns a message that no interactions are possible.
    public String interactWithCurrentRoom () {
        if (currentRoom instanceof Interactable)
            return ((Interactable) currentRoom).interact(player);
        return "There is nothing to interact with this room.";
    }

    // If the currentRoom is Lootable, it returns the result of calling loot on the Room.
    // If not, it returns a message that the current room is not lootable.
    public String lootCurrentRoom () {
        if (currentRoom instanceof Lootable)
            return ((Lootable) currentRoom).loot(player);
        return "Room [" + currentRoom.getName() + "] is not lootable";
    }

    // If the direction is valid to move from within the currentRoom,
    // the adjoining Room becomes the new currentRoom and the method returns true.
    // If not, the method returns false.
    public boolean move (char cha) {
        if(currentRoom.isValidDirection(cha)) {
            this.currentRoom = currentRoom.getAdjoiningRoom(cha);
            return true;
        }
        return false;
    }

    // Methods named getPlayerScore and getPlayerInventory
    // that return the result of calling the Player's getScore and getInventory methods.
    public int getPlayerScore () {
        return player.getScore();
    }
    public String getPlayerInventory () {
        return player.getInventory();
    }

    // Methods named getCurrentRoomDescription and getCurrentRoomExits
    // that return the result of calling the getDescription and getExits method of the currentRoom.
    public String getCurrentRoomDescription (){
        return currentRoom.getDescription();
    }

    public String getCurrentRoomName (){
        return currentRoom.getName();
    }

    public String getCurrentRoomExits () {
        return currentRoom.getExits();
    }

    // A method named isFinished that returns the Maze's isFinished field (a boolean).
    public boolean isFinished () {
        return isFinished;
    }
}
