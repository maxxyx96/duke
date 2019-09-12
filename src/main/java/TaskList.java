import java.util.ArrayList;

/**
 *  Contains the task list and functions that involves the
 *  manipulation of the taskList such as adding and deleting of tasks.
 */
public class TaskList {

    protected ArrayList<Task> taskList;
    public ArrayList<Task> searchList;
    protected int counter;

    /**
     * Creates the task list from either a new file
     * or a file that contains existing tasks.
     */
    public TaskList() {
        this.taskList = Storage.loadTask();
    }

    /**
     * Gets the task list
     * @return returns the task list
     */
    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Adds the task into the task list
     * @param task task that is to be added into task list
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Marks the task specified in the index
     * as done.
     *
     * @param index index of the task that is done
     */
    public void doneTask(int index) {
        taskList.get(index).markAsDone();
    }

    /**
     * Removes the task at the specified index
     * @param index index of the task to be removed
     */
    public void delTask(int index) {
        taskList.remove(index);
    }

    /**
     * Gets the task at the specified index
     * @param index index of the task to be obtained
     * @return returns the task in the specified index
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Checks the size of the task list
     * @return returns the size of the task list
     */
    public int sizeOf() {
        return taskList.size();
    }

    /**
     * Checks if a task list is empty
     *
     * @return returns 1 if empty and 0 otherwise
     */
    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    /**
     * Prints out the numbered task list
     */
    public void printTaskList() {
        counter = 1;
        for (Task currentTask : taskList) {
            System.out.print(counter + ". ");
            System.out.println(currentTask);
            counter += 1;
        }
    }

    /**
     * Prints out the tasks that contains the keyword inside of
     * the task list.
     *
     * @param keyWord The keyword that is required to be found in the tasks
     */
    public void searchList(String keyWord) {
        counter = 1;
        searchList = new ArrayList<Task>();
        for (Task searchTask : taskList) {
            if (searchTask.description.contains(keyWord)) {
                //store it inside a new array list
                searchList.add(searchTask);
            }
        }
        if (searchList.size() == 0) {
            System.out.println("☹ OOPS!!! Nothing matches your search!");
        }
        else {
            System.out.println("Here are the matching tasks in your list:");
            for (Task currentTask : searchList) {
                System.out.print(counter + ". ");
                System.out.println(currentTask);
                counter += 1;
            }
        }
    }
}
