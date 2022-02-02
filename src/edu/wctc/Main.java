package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create the Maze, and a Scanner to read keyboard input.
        Maze maze = new Maze(new Player());
        printGreetings(maze);
        Scanner keyboard = new Scanner(System.in);

        // loop until the Maze is finished.
        while (!maze.isFinished()) {
            // prompt user input
            System.out.print(">>");
            char input = keyboard.nextLine().charAt(0);

            switch (input)
            {
                case 'n':
                case 's':
                case 'e':
                case 'w':
                case 'u':
                case 'd':
                    if(!maze.move(input))
                        System.out.println("Invalid movement, cannot move to that direction.");
                    printGreetings(maze);
                    break;
                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    var exitMsg = maze.exitCurrentRoom();
                    System.out.println(exitMsg);
                    if(exitMsg.contains("you have finished the maze.")) {
                        maze.isFinished();
                        // When the maze is finished, print the player's score.
                        System.out.println("Your score is " + maze.getPlayerScore());
                    }
                    break;
                case 'v':
                    System.out.println(maze.getPlayerInventory());
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    static void printGreetings(Maze maze){
        System.out.println("********************************");
        System.out.println("You are in the " + maze.getCurrentRoomName() + "!");
        System.out.println(maze.getCurrentRoomDescription());

        // Print the current room exits.
        System.out.println("The exits are:" + maze.getCurrentRoomExits());
    }
}
