import java.io.*;
import java.util.*;

public class Task implements Serializable {

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        //return (isDone ? "O" : "X"); //O tick X cross, cant see unicode :/
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    //To include [X]/[TICK] whatever into the string
    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + this.description;
    }

}