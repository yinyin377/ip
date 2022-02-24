package duke;

/*
 *  ListCommand.java
 *  Defines the 'List' action flow to list tasks.
 */
public class HelpCommand extends Command {
    /**
     *  Constructs List Command object.
     */
    public HelpCommand(){

    }

    /*
     * This method 'Executes' the command and
     *  display all tasks in the task list.
     * @param tasks Object of Task class.
     * @param ui Object of UI class - User Interface.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        String output = "\tHere are some tips to help you:" + "\n";
        //print all tips
        output = output + "\t Command: list \n \t \t  To list all tasks you have.\n";
        output = output + "\t Command: delete <index> \n \t \t  To delete task specified.\n";
        output = output + "\t Command: todo <title of task> \n \t \t  To add a To Do task.\n";
        output = output + "\t Command: event <title of task> /at <YYYY-MM-DD HH:MM> \n \t \t  To add an event task.\n";
        output = output + "\t Command: deadline <title of task> /by <YYYY-MM-DD HH:MM> \n \t \t"
                + " To add an deadline task.\n";
        return output;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after list command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}