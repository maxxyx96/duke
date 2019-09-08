import java.util.*;
import java.text.*;

/**
 * This is the main class of Duke where the program will start running from
 */
public class Duke {

    private Ui ui;

    /**
     * The method run is used to run most of duke's programs.
     *
     * @return None
     */
    public void run() {
        //array of Tasks generation
        //ArrayList<Task> taskList = new ArrayList<>();
        TaskList taskList = new TaskList();
        //taskList = Storage.loadTask(taskList);

        //Tool to recognise date from string
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HHmm");

        ui = new Ui();
        ui.dukeWelcome();

        //Input device
        Parser newInput = new Parser();

        //Input declaration
        String userText = "";
        String inputTask = "";
        String[] splitTask;

        //Get first keyword
        String userCommand = newInput.userCommand();

        while (!userCommand.equals("bye")) {

            //Switch will contain list, done, default will add to list.
            switch (userCommand) {
                case "list":
                    int number = 1;
                    //Outputs the list if its non-empty
                    if(taskList.isEmpty()){
                        System.out.println("List currently has nothing");
                    }
                    else {
                        taskList.printTaskList();
                    }
                    break;

                case "event":
                    //Replace "event " with "" to get actual event
                    inputTask = newInput.removeWord("event");

                    //Error Handling
                    if (inputTask.equals("")) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                        break;
                    }
                    if (inputTask.indexOf("/at") == -1) {
                        System.out.println("☹ OOPS!!! The event must be specified with /at <date and time>!");
                        break;
                    }

                    //get the details before and after /at
                    Task inputEvent = new Event(newInput.beforeAt(), newInput.afterAt());
                    taskList.addTask(inputEvent);
                    System.out.println("Got it. I've added this task: \n" + inputEvent);
                    System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "deadline":
                    //Replace "deadline " with "" to get actual deadline
                    inputTask = newInput.removeWord("deadline");
                    //Error handling
                    if (inputTask.equals("")) {
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
                        Date dueDate = dateFormat.parse(newInput.afterBy());
                        Task inputDeadline = new Deadline(newInput.beforeBy(), dueDate);
                        taskList.addTask(inputDeadline);
                        System.out.println("Got it. I've added this task: \n" + inputDeadline);
                        System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                        Storage.saveTask(taskList.getTaskList());
                    }
                    //If user dont put the date properly or horhhhh
                    catch (ParseException e)
                    {
                        System.out.println("☹ Please format deadline with: DD/MM/YYYY HHMM, eg: 02/12/2019 1800");
                    }

                    break;

                case "todo":
                    //Replace "to do " with "" to get actual to do
                    inputTask = newInput.removeWord("todo");

                    //Error handling
                    if (inputTask.equals("") || inputTask.equals(" ")) {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        break;
                    }
                    //Create new to do
                    Task inputTodo = new Todo(inputTask);
                    taskList.addTask(inputTodo);
                    //Notify user
                    System.out.println("Got it. I've added this task: \n" + inputTodo);
                    System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "done":
                    //Kill off the word done. -1 to account for 0 based indexing
                    int completedIndex = newInput.getIndex();

                    if (completedIndex >= taskList.sizeOf() || taskList.sizeOf() == 0) {
                        System.out.println("Index is out of bounds!");
                        break;
                    }
                    Task markDone = taskList.getTask(completedIndex);
                    markDone.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(markDone);
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "delete":
                    //Kill off the word delete. -1 to account for 0 based indexing
                    int deleteIndex = newInput.getIndex();
                    if (deleteIndex > taskList.sizeOf() || taskList.sizeOf() == 0) {
                        System.out.println("Index is out of bounds!");
                        break;
                    }
                    Task markDelete = taskList.getTask(deleteIndex);
                    System.out.println("Noted. I've removed this task: \n" + markDelete);
                    taskList.delTask(deleteIndex);
                    System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "find":
                    inputTask = newInput.removeWord("find ");
                    if (inputTask.equals("") || inputTask.equals(" ")) {
                        System.out.println("☹ OOPS!!! You cant find an empty task!");
                        break;
                    }
                    taskList.searchList(inputTask);
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

            }

            //Prepare for next input
            newInput = new Parser();
            userCommand = newInput.userCommand();
        }

        ui.dukeGoodbye();
    }

    /**
     * This is the main method which runs Duke
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
            new Duke().run();
    }
}
