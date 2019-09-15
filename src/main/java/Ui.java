/**
 * Deals with various interactions Duke has with the users, such as
 * welcome and goodbye.
 */
public class Ui {

    /**
     * Welcomes the user
     */
    public static final void dukeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
    }

    public static final void dukeWelcome() {
        //Introduction
        System.out.println("What can i do for you?");
    }

    /**
     * Says goodbye to the user
     */
    public static final void dukeGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Duke's Line indentation
     */
    public static final void dukeLine() {
        System.out.println("__________________________________________________________________");
    }

}
