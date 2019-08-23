import java.util.Scanner; //For Input

public class Duke {
    public static void main(String[] args) {

        //TYPE EVERYTHING IN HERE >:( 
        
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        //Introduction
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");

        //Scanning for input
        String userText = "null";
        while (!userText.equals("bye")) {
            Scanner newInput = new Scanner(System.in);
            System.out.println();

            userText = newInput.next();
            System.out.println(userText);
        }

        //Bye
        System.out.println("Bye. Hope to see you again soon!");

    }
    
}

