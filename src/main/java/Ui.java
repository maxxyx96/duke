/**
 * Deals with various interactions Duke has with the users, such as
 * welcome and goodbye.
 */
public class Ui {

    public static final void dukeWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        //Introduction
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
    }

    public static final void dukeGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

}
