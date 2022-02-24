package duke;

/*  Recommit to correct naming.
 *  FindCommand.java
 *  Defines the 'Find' action to search tasks using keywords.
 */
public class FindCommand extends Command{
    private String keyWord;
    /*
     *  Constructs Find Command object.
     */
    public FindCommand(String keyWord){
        this.keyWord = keyWord;
    }

    /*
     * This method 'Executes' the command and
     *  display searched tasks in the task list.
     * @param tasks Object of Task class.
     * @param ui Object of UI class - User Interface.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        String output = "\tHere are the matching tasks in your list:";
        //print all tasks in task list
        for (int i = 1; i < tasks.getTaskSize() + 1; i++) {
            Task task = tasks.getTaskList().get(i - 1);
            String description = task.getDescription();
            if (description.contains(keyWord)) {
                output = output + "\t" + String.format(i + "." + task, task.getStatusIcon());
            }
        }
        return null;
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
