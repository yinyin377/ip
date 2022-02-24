package duke;

/*
 *  Storage.java
 *  Defines method to load and save tasks.
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Storage {
    private String filePath;
    private BufferedReader reader;

    /*
     * Constructs Storage object
     * @param filePath Define file location.
     */
    Storage() {
        try {
            reader = new BufferedReader(new FileReader("data/tasks.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /** This method loads task list with tasks in file.
     * @return tasks Task object.
     * @throws DukeException Exception handled.
     */
    public ArrayList<Task> load() throws DukeException {
        //initialize Array list as tasks.
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            String line;
            //reads all task written in the file
            while ((line = reader.readLine()) != null) {
                String[] readData = line.split(" \\| ");
                switch (readData[0]) {
                case "D":
                    new Deadline(readData[1], readData[2], readData[3]);
                    break;
                case "E":
                    new Event(readData[1], readData[2], readData[3]);
                    break;
                default:
                    new ToDo(readData[1], readData[2]);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            //prints exception message.
            System.out.println(e.getMessage());
        }
        return tasks;
    }

    /**
     *  This method save task list with tasks in file.
     * @param tasks Task stored in array list.
     */
    public void save(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/tasks.txt"));
            //writes all tasks into file
            for (Task task : tasks) {
                char type = task.getTaskType();
                String status = (task.getStatus() ? "1" : "0");
                String description = task.getDescription();
                String last = "";
                if (type == 'E') {
                    Event event = (Event) task;
                    last = event.getLast();
                } else if (type == 'D') {
                    Deadline deadline = (Deadline) task;
                    last = deadline.getLast();
                }
                writer.write(type + " | " + status + " | " + description + " | " + last);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            //prints exception message.
            System.out.println(e.getMessage());
        }
    }
}