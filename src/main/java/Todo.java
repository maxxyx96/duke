import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Represents the Specific Task - To-do that users are able to input
 * as a task.
 */
public class Todo extends Task implements Serializable {

    /**
     * Method which creates a new to-do from the user input
     *
     * @param description description of the task
     */
    public Todo(String description) {
        super(description);

    }

    /**
     * Overrides method toString to include the format of a to-do which has
     * "[T]"
     *
     * @return Returns the String description
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}