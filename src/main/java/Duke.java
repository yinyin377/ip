public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        showLine();
        System.out.println("Hello! I'm Duke" + "\n" + "What can I do for you?");
        showLine();
        showFarewell();
    }

    public static void showLine() {
        System.out.println("_____________________________________________________________");
    }

    public static void showFarewell() {
        System.out.println("Bye. Hope to see you again soon!");
        showLine();
    }
}
