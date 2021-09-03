import java.util.Scanner;
public class Duke {
    private static Task[] tasklist = new Task[100];
    private static int taskCount = 0;

    public static void addTask(Task s){
        tasklist[taskCount] = s;
        taskCount++;
    }
    public static void printLine(){
        System.out.println("_______________________________");
    }

    public static void checkException(String message){
        try{
            throw new DukeException(message);
        }
        catch (DukeException ex){
            System.out.println(ex.getMessage());
        }
        printLine();
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke" + "\n\t" + "What can I do for you?");
        printLine();
        Scanner myObj = new Scanner(System.in);
        String userInput;
        int INDEX = 0;

        while(myObj.hasNextLine()){
            userInput = myObj.nextLine();
            String[] split = userInput.split(" ");
            String first = split[0];
            if (userInput.equals("list")) {
                //Print list of tasks
                printLine();
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < INDEX; i++) {
                    System.out.println((i + 1) + ". " + tasklist[i].toString());
                }
                printLine();
            }
            else if (userInput.equals("bye")) {
                break;
            }
            else if (!first.equals("event") && !first.equals("deadline") &&!first.equals("todo")) {
                checkException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                break;
            }
            else if (first.equals("done")) {
                //Get task index to mark as done
                String second = split[1];
                tasklist[Integer.parseInt(second) - 1].markAsDone();
                printLine();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(tasklist[Integer.parseInt(second) - 1].getStatusIcon()+" " + tasklist[Integer.parseInt(second) - 1].description);
                printLine();
            }
            else {
                printLine();
                System.out.println("Got it. I've added this task: ");
                if (first.equals("todo")) {
                    //add to-do task
                    addTask(new ToDo(userInput));
                    System.out.println(tasklist[INDEX].toString());
                    INDEX++;
                }
                if (first.equals("deadline")) {
                    //add deadline task
                    String[] split02 = userInput.split("/by");
                    String firstD = split02[0];
                    String secondD = split02[1];
                    addTask(new Deadline(firstD,secondD));
                    System.out.println(tasklist[INDEX].toString());
                    INDEX++;
                }
                if (first.equals("event")) {
                    //add event task
                    String[] split03 = userInput.split("/at");
                    String firstE = split03[0];
                    String secondE = split03[1];
                    addTask(new Event(firstE,secondE));
                    System.out.println(tasklist[INDEX].toString());
                    INDEX++;
                }
                System.out.println("Now you have "+INDEX+" tasks in the list.");
                printLine();
            }
        }
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }
}
