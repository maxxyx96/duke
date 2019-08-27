import java.io.*;
import java.util.*;

public class Data {

    //Task Loading
    public static ArrayList<Task> loadTask(ArrayList<Task> log) {
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

    public static void saveTask(ArrayList<Task> taskList) {
        try {
            FileOutputStream fileOS = new FileOutputStream("./taskLog");
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(taskList);
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
