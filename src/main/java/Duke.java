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

        //Input declaration
        String userText = "";
        String inputTask = "";
        String[] splitTask;

        //Input declaration
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
                        for (Task currentTask : taskList) {
                            System.out.print(number + ". ");
                            System.out.println(currentTask);
                            number += 1;
                        }
                    }
                    break;

                case "event":
                    //Replace "event " with "" to get actual event
                    inputTask = userText.replaceFirst("event ", "");
                    splitTask = inputTask.split("/at", 2);
                    System.out.println(splitTask[0] + splitTask[1]);
                    //Create new to do
                    Task inputEvent = new Event(splitTask[0], splitTask[1]);
                    taskList.add(inputEvent);
                    System.out.println("Got it. I've added this task: \n" + inputEvent);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "deadline":
                    //Replace "deadline " with "" to get actual deadline
                    inputTask = userText.replaceFirst("deadline ", "");
                    //Split the string where the nasty "/" is
                    splitTask = inputTask.split("/by", 2);
                    System.out.println(splitTask[0] + splitTask[1]);
                    //Create new to do
                    Task inputDeadline = new Deadline(splitTask[0], splitTask[1]);
                    taskList.add(inputDeadline);
                    System.out.println("Got it. I've added this task: \n" + inputDeadline);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "todo":
                    //Replace "to do " with "" to get actual to do
                    inputTask = userText.replaceFirst("todo ", "");
                    //Create new to do
                    Task inputTodo = new Todo(inputTask);
                    taskList.add(inputTodo);
                    //Notify user
                    System.out.println("Got it. I've added this task: \n" + inputTodo);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "done":
                    //Kill off the word done. -1 to account for 0 based indexing
                    int completedIndex = -1 + Integer.parseInt(userText.replaceAll("[\\D]", ""));
                    //System.out.println("Usertext is now : " + completedIndex);
                    //Stuff for done
                    Task markDone = taskList.get(completedIndex);
                    markDone.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(markDone);
                    break;

                default:
                    System.out.println("YOU SHOULDNT BE HERE. WHY ARE YOU POPPING UP?");

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