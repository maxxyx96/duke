/**
 * Represents the Specific Task - Event that users are able to input,
 * with a <code>/at</code> separating between the task description and the
 * details of the event, such as period and maybe location.
 */
public class Event extends Task {

    protected String at;

    /**
     * Creates a new event task from the user's input
     *
     * @param description description of the task stored
     * @param at description of the period of the event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }
    /**
     * Overrides method toString to include the format of a event which has
     * "[E]" and a parenthesis to denote the event period
     *
     * @return Returns the String description
     */
    //To include [E] whatever at whenever time into the string
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}