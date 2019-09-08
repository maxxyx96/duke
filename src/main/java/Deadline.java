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

    public Deadline(String description, Date dueDate) {
        super(description);
        this.dueDate = dueDate;
        //Convert dueDate into something nicer
        by = simpleDateFormat.format(dueDate);
    }

    //To include [D] whatever by whenever into the string
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}