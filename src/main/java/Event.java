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