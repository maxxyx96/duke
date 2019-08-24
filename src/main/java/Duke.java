import java.util.*; //For Input

public class Duke {
    public static void main(String[] args) {

        //array of Tasks generation
        ArrayList<Task> taskList = new ArrayList<>();

        //Input device
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

        //Adopting Switch Approach
        userText = newInput.nextLine();

        //Get first keyword
        String userCommand = userText.contains(" ") ? userText.split(" ")[0] : userText;

        while (!userText.equals("bye")) {

            //Switch will contain list, done, default will add to list.
            switch (userCommand) {
                case "list":
                    int number = 1;
                    //Outputs the list if its non-empty
                    if(taskList.isEmpty()){
                        System.out.println("List currently has nothing");
                    }
                    else {
                        for (Task i : taskList) {
                            System.out.println(number + ".[" + i.getStatusIcon() + "] "+ i.description);
                            number += 1;
                        }
                    }
                    break;

                case "done":
                    //Kill off the word done. -1 to account for 0 based indexing
                    int completedIndex = -1 + Integer.parseInt(userText.replaceAll("[\\D]", ""));
                    //System.out.println("Usertext is now : " + completedIndex);
                    //Stuff for done
                    Task markDone = taskList.get(completedIndex);
                    markDone.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + markDone.getStatusIcon() + "] "+ markDone.description);
                    break;

                default:
                    //Add to list
                    taskList.add(new Task(userText));
                    System.out.println("Task Added: " + userText);
            }

            //Prepare for next input
            userText = newInput.nextLine();

            //Get first keyword
            userCommand = userText.contains(" ") ? userText.split(" ")[0] : userText;
        }

        //Bye
        System.out.println("Bye. Hope to see you again soon!");
    }
    
}