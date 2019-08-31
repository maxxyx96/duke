import java.util.*;
import java.text.*;

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