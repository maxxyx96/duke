import java.util.ArrayList;

/**
 *  Contains the task list and functions that involves the
 *  manipulation of the taskList such as adding and deleting of tasks.
 */
public class TaskList {

    protected ArrayList<Task> taskList;
    public ArrayList<Task> searchList;
    protected int counter;

    public TaskList() {
        this.taskList = Storage.loadTask();
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void doneTask(int index) {
        taskList.get(index).markAsDone();
    }

    public void delTask(int index) {
        taskList.remove(index);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public int sizeOf() {
        return taskList.size();
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public void printTaskList() {
        counter = 1;
        for (Task currentTask : taskList) {
            System.out.print(counter + ". ");
            System.out.println(currentTask);
            counter += 1;
        }
    }

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
