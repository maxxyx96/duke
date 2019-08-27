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

    //My attempt at level-7, ClassCastException: To do cannot be cast to java.util.Arraylist
    //Even though To do extends Task and implements serializable :/
    //Might need to change the way i handle the data :(:(:(:(:(:((((((((((
    public static ArrayList<Task> loadTask(ArrayList<Task> log) {
        try {
            FileInputStream fileIS = new FileInputStream("./taskLog");
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            log = (ArrayList<Task>) objectIS.readObject();
            objectIS.close();
            fileIS.close();
        }
        catch (FileNotFoundException f) {
            //Creates a file if there is no file found
            System.out.println("No file, i Created a file for ya :D");
            File newLog = new File("./taskLog");
        }
        catch (IOException i) {
            System.out.println("IO Exception from loadTask detected");
            i.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class Not Found Exception from loadTask detected");
            c.printStackTrace();
        }
        return log;
    }

    public static void saveTask(Task thisTask) {
        try {
            FileOutputStream fileOS = new FileOutputStream("./taskLog");
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(thisTask);
            objectOS.close();
            fileOS.close();
            //System.out.println("Serialized data is saved in /taskLog");
        }

        catch (IOException i) {
            i.printStackTrace();
        }
    }
}