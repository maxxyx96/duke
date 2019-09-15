import java.util.*;
import java.text.*;

/**
 * This is the main class of Duke
 */
public class Duke {

    private Ui ui;

    /**
     * Duke's program gets run here.
     *
     */
    public void run() {

        TaskList taskList = new TaskList();


        //Tool to recognise date from string
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HHmm");

        ui = new Ui();
        ui.dukeWelcome();

        //Inputs
        Parser newInput = new Parser();
        String inputTask = "";

        //Get first keyword
        String userCommand = newInput.userCommand();

        while (!userCommand.equals("bye")) {

            switch (userCommand) {
                case "list":
                    if(taskList.isEmpty()){
                        System.out.println("List currently has nothing");
                    }
                    else {
                        taskList.printTaskList();
                    }
                    break;

                case "event":
                    try {
                        inputTask = newInput.removeWord("event");
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty!");
                        break;
                    }
                    if (inputTask.indexOf("/at") == -1) {
                        System.out.println("☹ OOPS!!! The event must be specified with /at <date and time>!");
                        break;
                    }

                    Task inputEvent = new Event(newInput.beforeAt(), newInput.afterAt());
                    taskList.addTask(inputEvent);
                    System.out.println("Got it. I've added this task: \n" + inputEvent);
                    System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "deadline":
                    try {
                        inputTask = newInput.removeWord("deadline");
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty!");
                        break;
                    }

                    if (!inputTask.contains("/by")) {
                        System.out.println("☹ OOPS!!! The due date must be specified with /by <due date>!");
                        break;
                    }

                    try {
                        Date dueDate = dateFormat.parse(newInput.afterBy());
                        Task inputDeadline = new Deadline(newInput.beforeBy(), dueDate);
                        taskList.addTask(inputDeadline);
                        System.out.println("Got it. I've added this task: \n" + inputDeadline);
                        System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                        Storage.saveTask(taskList.getTaskList());
                    }
                    catch (ParseException e)
                    {
                        System.out.println("☹ Please format deadline with: DD/MM/YYYY HHMM, eg: 02/12/2019 1800");
                    }

                    break;

                case "todo":
                    try {
                        inputTask = newInput.removeWord("todo");
                    } catch (Exception e) {
                        System.out.println("☹ OOPS!!! The description of todo cannot be empty!");
                        break;
                    }

                    Task inputTodo = new Todo(inputTask);
                    taskList.addTask(inputTodo);

                    System.out.println("Got it. I've added this task: \n" + inputTodo);
                    System.out.println("Now you have " + taskList.sizeOf() + " tasks in the list.");
                    Storage.saveTask(taskList.getTaskList());
                    break;

                case "done":
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
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
            new Duke().run();
    }
}
