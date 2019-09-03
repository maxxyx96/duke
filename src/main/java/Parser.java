import java.util.Scanner;

public class Parser {

    public Scanner scan = new Scanner(System.in);
    private String command;

    public Parser() {
        this.command = scan.nextLine();
    }

    public void newScan() {
        this.command = scan.nextLine();
    }

    public String userCommand() {
        return this.command.contains(" ") ? this.command.split(" ")[0] : this.command;
    }

    public String removeFirstWord() {
        String[] tempStringList = this.command.split(" ", 2);
        return tempStringList[1];
    }

    public int getIndex() {
        return -1 + Integer.parseInt(this.command.replaceAll("[\\D]", ""));
    }

    public String beforeBy() {
        String[] tempStringList = this.command.split("/by", 2);
        return tempStringList[0];
    }
    public String afterBy() {
        String[] tempStringList = this.command.split("/by", 2);
        return tempStringList[1];
    }

    public String beforeAt() {
        String[] tempStringList = this.command.split("/at", 2);
        return tempStringList[0];
    }
    public String afterAt() {
        String[] tempStringList = this.command.split("/at", 2);
        return tempStringList[1];
    }
}
