import java.io.*;
import java.util.*;

/**
 * Generic representation of Tasks in Duke, which the various
 * subclasses will inherit from.
 */
public class Task implements Serializable {

    protected String description;
    protected boolean isDone;

    /**
     * Creates a task from user input
     *
     * @param description description of a task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the icon of the current status of the task.
     * Cross symbolises it being undone and tick symbolises it being done.
     *
     * @return returns the icon of the task
     */
    public String getStatusIcon() {
        //return (isDone ? "O" : "X"); //O tick X cross, cant see unicode :/
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }

    /**
     * Marks the item as done when method is called.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Overrides method toString to include the status of the task inside
     * a square bracket.
     *
     * @return Returns the String description
     */
    @Override
    public String toString(){
        return "[" + getStatusIcon() + "]" + this.description;
    }

}