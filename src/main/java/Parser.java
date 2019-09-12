import java.text.ParseException;
import java.util.Scanner;

/**
 * Parser deals with making sense of the user command
 */
public class Parser {

    public Scanner scan = new Scanner(System.in);
    private String command;

    /**
     * Creates a new parser which contains the user input
     */
    public Parser() {
        this.command = scan.nextLine();
    }

    /**
     * Creates a new scan
     */
    public void newScan() {
        this.command = scan.nextLine();
    }

    /**
     * Returns the first word of the user command
     *
     * @return first word of user command eg: <code>task, list</code>
     */
    public String userCommand() {
        return this.command.contains(" ") ? this.command.split(" ")[0] : this.command;
    }

    /**
     * Removes the given word once in the specified string
     *
     * @param word string that is to have a particular word removed
     * @return returns the rest of the string
     */
    public String removeWord(String word) {
        String[] tempStringList = this.command.split(word);
        return tempStringList[1];
    }

    /**
     * Gets the index in commands such as delete and done.
     * eg: gets the integer <code>6</code> from done 6
     *
     * @return returns the integer index
     */
    public int getIndex() {
        return -1 + Integer.parseInt(this.command.replaceAll("[\\D]", ""));
    }

    /**
     * Gets the task description for the deadline task
     *
     * @return returns the task description before the /by separator
     */
    public String beforeBy() {
        String tempString = this.command.split(" ", 2)[1];
        String[] tempStringList = tempString.split("/by", 2);
        return tempStringList[0];
    }

    /**
     * Gets the deadline of the task in string format
     *
     * @return returns the string after the /by separator
     */
    public String afterBy() {
        String[] tempStringList = this.command.split("/by", 2);
        return tempStringList[1];
    }

    /**
     * Gets the task description for the event task
     *
     * @return returns the task description before the /at separator
     */
    public String beforeAt() {
        String tempString = this.command.split(" ", 2)[1];
        String[] tempStringList = tempString.split("/at", 2);
        return tempStringList[0];
    }

    /**
     * Gets the details of the event task in string format
     *
     * @return returns the string after the /at separator
     */
    public String afterAt() {
        String[] tempStringList = this.command.split("/at", 2);
        return tempStringList[1];
    }
}
