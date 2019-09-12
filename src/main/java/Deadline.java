import java.util.*;
import java.text.*;

/**
 * Represents the Specific Task - Deadline that users are able to input,
 * with a <code>/by</code> separating between the task description and the
 * date and time of the deadline
 */
public class Deadline extends Task {

    protected Date dueDate;
    protected String by;
    //Formats date to something that is nice :D
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy, hh:mm a");

    /**
     * Creates a new deadline task from the user's input
     *
     * @param description desciption of the task stored
     * @param dueDate due date which which will be formatted for better reading
     */
    public Deadline(String description, Date dueDate) {
        super(description);
        this.dueDate = dueDate;
        //Convert dueDate into something nicer
        by = simpleDateFormat.format(dueDate);
    }

    /**
     * Overrides method toString to include the format of a deadline which has
     * "[D]" and a parenthesis to denote the due date and time.
     *
     * @return Returns the String description
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}