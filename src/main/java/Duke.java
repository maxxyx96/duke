import java.util.*; //For Input

public class Duke {
    public static void main(String[] args) {

        //list generation
        ArrayList<String> taskList = new ArrayList<String>();

        //input thing
        Scanner newInput = new Scanner(System.in);

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
        String userText = "";

        while (!userText.equals("bye")) {
            userText = newInput.nextLine();

            //If list requested
            if (userText.equals("list")) {
                //Print List
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println( (i + 1) + ". " + taskList.get(i));
                }
            }

            //Adding into the list
            else if (!userText.equals("bye")) {
                taskList.add(userText);
                System.out.println("added :" + userText);
            }

            else {
                System.out.println("Somehow the code ended here...");
            }

        }

        //Bye
        System.out.println("Bye. Hope to see you again soon!");

    }
    
}