import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Todo extends Task implements Serializable {

    public Todo(String description) {
        super(description);

    }

    //To include [T] whatever into the string
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}