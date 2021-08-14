import java.util.ArrayList;
import java.util.List;
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
        Task task;
        List<Task> list = new ArrayList<>();
        int count = 0;
        while (!toExit) {
            try {
                String command = readCommand(scan);
                if(command.equals("list")){
                    showLine();
                    System.out.println("\tHere are the tasks in your list:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("\t"+ (i+1) + ". " + list.get(i).toString());
                    }
                }
                else if (command.contains("done")){
                    String num = command.substring(5);
                    int intNum = Integer.parseInt(num);
                    Task doneTask = list.get(intNum - 1);
                    doneTask.markAsDone();
                    System.out.println("\tNice! I've marked this task as done: ");
                    System.out.println("\t" + list.get(intNum - 1).toString());
                }
                else if (command.equals("bye")){
                    toExit = true;
                }
                else{
                    showLine();
                    task = new Task(command);
                    list.add(count, task);
                    count++;
                    System.out.println("\tadded: "+command);
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

    public static void showDone() {
        System.out.println("\tNice! I've marked this task as done: ");
        showLine();
    }


}
