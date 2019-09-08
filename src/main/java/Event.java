/**
 * Represents the Specific Task - Event that users are able to input,
 * with a <code>/at</code> separating between the task description and the
 * details of the event, such as period and maybe location.
 */
public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    //To include [E] whatever at whenever time into the string
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}