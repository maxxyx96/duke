public class Todo extends Task {

    public Todo(String description) {
        super(description);

    }

    //To include [T] whatever into the string
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}