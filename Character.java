import java.util.ArrayList;

/**
 * The Character class implements the Contract interface
 */
public class Character implements Contract {
    /* An empty ArrayList that serves as the inventory / bag  */
    ArrayList<String> inventory;
    /* The character's position on the x-axis */
    int xPosition;
    /* The character's position on the y-axis */
    int yPosition;
    /* The character's size */
    int size;

    /**
     * Constructor for the Character class
     * creates an empty ArrayList of Strings for the inventory 
     * and sets the x and y positions to 0
     */
    public Character(int size) {
        this.inventory = new ArrayList<String>();
        this.xPosition = 0;
        this.yPosition = 0;
        this.size = size;
    }

   /** Grab function: adds an item to the inventory
    * @param item the item being grabbed
    */
    @Override public void grab(String item) {
        inventory.add(item);
        System.out.println("You grabbed a " + item + "!");
    }

    /** Drop function: checks if an item is in inventory, then if item is present, removes it, and
     * returns confirming message 
     * @param item the item being dropped
     * @return confirming message
     */
    @Override public String drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return item + " dropped!";
        } else {
            return item + " not found!";
        }
    }

    /** Examine function:
     * Prints a message of the item being examined
     * @param item item being examined
     */
    @Override public void examine(String item) {
        System.out.println("You examine the " + item + "!");
    }

    /** Use function: 
     * Checks that an item is in the inventory then prints a confirmation of the item's use
     * @param item being used
     */
    @Override public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("You use the " + item + "!");
        } else {
            System.out.println("You do not have this item!");
        }
    }

    /**
     * @param direction being walked
     * if the parameter is one of the recognized directions, the position moves 1 unit in that direction
     * @return whether action successful
     */
    @Override public boolean walk(String direction) {
        if (direction == "north") {
            yPosition += 1;
            System.out.println("New position: " + xPosition +", " + yPosition);
            return true;
        } if (direction == "east") {
            xPosition += 1;
            System.out.println("New position: " + xPosition +", "+ yPosition);
            return true; 
        } if (direction == "south") {
            yPosition -= 1;
            System.out.println("New position: " + xPosition +", "+ yPosition);
            return true;
        } if (direction == "west") {
            xPosition -= 1;
            System.out.println("New position: " + xPosition +", "+ yPosition);
            return true;
        } 
        System.out.println("Sorry, this direction is not found");
        return false;
    }

    /** fly: changes the x and y position by the input parameters
     * @param x how far being traveled left / right
     * @param y how far being traveled up / down 
     * @return boolean confirmation the fly was successful
     */
    @Override public boolean fly(int x, int y) {
        xPosition += x;
        yPosition += y;
        System.out.println("New position: " + xPosition +", " +yPosition);
        return true;
    }

    /** shrink function:
     * subtracts 1 from the current size
     * @return new size
     */
    @Override public Number shrink() {
        size -= 1;
        System.out.println("New size: "+ size);
        return size;
    }

    /** grow function:
     * adds 1 to the current size
     * @return new size
     */
    @Override public Number grow() {
        size += 1;
        System.out.println("New size: " + size);
        return size;
    }

    /** rest function:
     * prints a message confirming the character resting
     */
    @Override public void rest() {
        System.out.println("You rest and regain energy!");
    }

    /** undo function:
     * return's user's position to the origin
     */
    @Override public void undo() {
        xPosition = 0;
        yPosition = 0;
        System.out.println("Position returned to the origin!");
    }

    /**
     * main method 
     * @param args
     */
    public static void main(String[] args) {
    Character myCharacter = new Character(5);
    myCharacter.examine("apple");
    myCharacter.grab("apple");
    myCharacter.use("apple");
    System.out.println(myCharacter.drop("apple"));
    myCharacter.rest();
    myCharacter.grow();
    myCharacter.shrink();
    myCharacter.walk("up");
    myCharacter.walk("north");
    myCharacter.fly(1,1);
    myCharacter.undo();
}
}
