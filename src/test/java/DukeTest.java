import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DukeTest {
    @Test
    public void dummyTest(){
        assertEquals(2,2);
    }

    @Test
    public void todoTest() {
        assertEquals("[T][✗]Testing Duke todo", new Todo("Testing Duke todo").toString() );
    }
    @Test
    public void eventTest() {
        assertEquals("[T][✗]Testing Duke event", new Todo("Testing Duke event").toString() );
    }

}