import java.io.*;
import java.util.*;

/**
 * Storage deals with loading tasks from the file, as well as saving
 * tasks into the files.
 */
public class Storage {

    protected static ArrayList<Task> log = new ArrayList<>();

    /**
     * Loads the task list from a specific file path, and
     * creates a new file at the path if no file exists (Captured by the
     * FileNotFoundException exception)
     *
     * @return returns the loaded Task List.
     */
    public static ArrayList<Task> loadTask() {
        try {
            FileInputStream fileIS = new FileInputStream("./taskLog");
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            //Writes the stuff in the file to log
            log = (ArrayList<Task>) objectIS.readObject();
            objectIS.close();
            fileIS.close();
        }
        catch (FileNotFoundException f) {
            //Creates a file if there is no file found
            System.out.println("No file, i Created a file for ya :D");
            File newLog = new File("./taskLog");
            if (!newLog.exists()) {
                try {
                    newLog.createNewFile();
                }
                catch (IOException i) {
                    System.out.println("IO Exception from creating file detected");
                    i.printStackTrace();
                }

            }

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

    /**
     * Saves the file into the specified file path.
     *
     * @param saveData task list that is to be saved into the file
     */
    public static void saveTask(ArrayList<Task> saveData) {
        try {
            FileOutputStream fileOS = new FileOutputStream("./taskLog");
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(saveData);
            objectOS.close();
            fileOS.close();
            //System.out.println("Serialized data is saved in /taskLog");
        }

        catch (IOException i) {
            System.out.println("IO Exception from saveTask detected");
            i.printStackTrace();
        }
    }
}
