import java.util.Locale;
import java.util.Scanner;
public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        showLine();
        System.out.println("\tHello! I'm Duke" + "\n\t" + "What can I do for you?");
        showLine();
        boolean toExit = false;
        Scanner scan = new Scanner(System.in);
        while (!toExit) {
            try {
                String command = readCommand(scan);
                if (!command.equals("bye")){
                    showLine();
                    System.out.println("\t"+command);
                }
                else{
                    toExit = true;
                }
            }
            finally {
                showLine();
            }
        }
        showFarewell();
    }

    private static String readCommand(Scanner scan) {
        return scan.nextLine();
    }

    public static void showLine() {
        System.out.println("\t_____________________________________________________________");
    }

    public static void showFarewell() {
        System.out.println("\tBye. Hope to see you again soon!");
        showLine();
    }

}
