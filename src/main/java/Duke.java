import java.util.*;
import java.io.*;
import java.text.*;

public class Duke {

    public static void main(String[] args) {

        //array of Tasks generation
        ArrayList<Task> taskList = new ArrayList<>();
        taskList = Data.loadTask(taskList);
        //Input device
        Scanner newInput = new Scanner(System.in);

        //Tool to recognise date from string
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HHmm");

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

                    //Error Handling
                    if (inputTask.equals("") || inputTask.equals("event")) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                        break;
                    }
                    if (inputTask.indexOf("/at") == -1) {
                        System.out.println("☹ OOPS!!! The event must be specified with /at <date and time>!");
                        break;
                    }

                    //get the details before and after /at
                    splitTask = inputTask.split("/at", 2);
                    Task inputEvent = new Event(splitTask[0], splitTask[1]);
                    taskList.add(inputEvent);
                    System.out.println("Got it. I've added this task: \n" + inputEvent);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    Data.saveTask(taskList);
                    break;

                case "deadline":
                    //Replace "deadline " with "" to get actual deadline
                    inputTask = userText.replaceFirst("deadline ", "");
                    //Error handling
                    if (inputTask.equals("") || inputTask.equals("deadline")) {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                        break;
                    }
                    if (inputTask.indexOf("/by") == -1) {
                        System.out.println("☹ OOPS!!! The due date must be specified with /by <due date>!");
                        break;
                    }

                    //get the details before and after /by
                    splitTask = inputTask.split(" /by ", 2);
                    try {
                        Date dueDate = dateFormat.parse(splitTask[1]);
                        Task inputDeadline = new Deadline(splitTask[0], dueDate);
                        taskList.add(inputDeadline);
                        System.out.println("Got it. I've added this task: \n" + inputDeadline);
                        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                        Data.saveTask(taskList);
                    }
                    //If user dont put the date properly or horhhhh
                    catch (ParseException e)
                    {
                        System.out.println("☹ Please format deadline with: DD/MM/YYYY HHMM, eg: 02/12/2019 1800");
                    }

                    break;

                case "todo":
                    //Replace "to do " with "" to get actual to do
                    inputTask = userText.replaceFirst("todo ", "");

                    //Error handling
                    if (inputTask.equals("") || inputTask.equals("todo")) {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        break;
                    }
                    //Create new to do
                    Task inputTodo = new Todo(inputTask);
                    taskList.add(inputTodo);
                    //Notify user
                    System.out.println("Got it. I've added this task: \n" + inputTodo);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    Data.saveTask(taskList);
                    break;

                case "done":
                    //Kill off the word done. -1 to account for 0 based indexing
                    int completedIndex = -1 + Integer.parseInt(userText.replaceAll("[\\D]", ""));
                    //Stuff for done
                    Task markDone = taskList.get(completedIndex);
                    markDone.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(markDone);
                    Data.saveTask(taskList);
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

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
