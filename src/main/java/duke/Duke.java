package duke;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;

public class Duke {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/duke.png"));

    private Storage storage;
    private TaskList tasks;
    private UI ui;

    /**
     *  Constructs duke object.
     *  @param filePath Define file location.
     */
    public Duke() {
        //Creates User interface
        ui = new UI();
        //Reading data from file stated in filepath
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }
    /**
     *  This method shows the flow of 'duke'.
     */

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                System.out.println(getResponse(fullCommand));
                isExit = c.isExit();
                storage.save(tasks.getTaskList());
            } catch (DukeException e) {
                ui.displayError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
    /**
     *  This is the main method.
     *  @param args Arguments.
     */

    public static void main(String[] args) {
        new Duke().run();

    }
    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            String lineToPrint = c.execute(tasks, ui, storage);
            return lineToPrint;
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    public String getWelcome() {
        return "Hello! I'm Duke, What can I do for you ?";
    }
}
