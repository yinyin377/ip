import java.util.Arrays;
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
        String[] strArray = new String[100];
        int count = 0;
        while (!toExit) {
            try {
                String command = readCommand(scan);
                if(command.equals("list")){
                    showLine();
                    int index = 0;
                    for (String num: strArray) {
                        if(num !=null){
                            index++;
                            System.out.println("\t"+index+". "+num);
                        }
                    }
                }
                else if (command.equals("bye")){
                    toExit = true;
                }
                else{
                    showLine();
                    count++;
                    strArray[count]=command;
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


}
