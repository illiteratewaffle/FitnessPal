package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalLogsController {

    //Controller for setting stage and GUI

    private Stage stage;
    @FXML
    private TextField Date;
    @FXML
    private TextField Exercise;
    @FXML
    private TextField Sets;
    @FXML
    private TextField Reps;
    @FXML
    private Label errorLabel;

    /**
     * When you press "Return to Menu"
     *
     * @param event
     */
    @FXML
    protected void onReturnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 480, 240);

            stage.setTitle("FitnessPal");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * When you click "Add Workout"
     *
     * @param event
     */
    @FXML
    protected void onAddClick(ActionEvent event) {
        try {
            errorLabel.setText("");

            String logDate = Date.getText();
            String logExercise = Exercise.getText().toUpperCase();
            String logSets = Sets.getText();
            String logReps = Reps.getText();

            logInput(logDate, logExercise, logSets, logReps);

        } catch (NumberFormatException e) {
            errorLabel.setText("Enter numbers only for Sets and/or Reps. (e.g. 3, 8, 12)");
        } catch (Exception e) {
            errorLabel.setText("bro you gotta enter something in first...");
        }
    }

    /**
     * Takes the information given in the text fields and writes it to file.
     * Check user input validity.
     *
     * @param Date
     * @param Exercise
     * @param Sets
     * @param Reps
     */
    private void logInput(String Date, String Exercise, String Sets, String Reps) {
        LogInput logInput = new LogInput();
        boolean validDate = logInput.inputDate(Date);
        boolean validExercise = logInput.inputExercise(Exercise);
        boolean validSets = logInput.inputSets(Sets);
        boolean validReps = logInput.inputReps(Reps);

        boolean okayToLog = true;

        if (!validDate) {
            errorLabel.setText("Invalid input. Input must be a valid day in the form yy/mm/dd.");
            okayToLog = false;
        }
        if (!validExercise) {
            errorLabel.setText("Invalid Input. Please enter an exercise name");
            okayToLog = false;
        }
        if (!validSets) {
            errorLabel.setText("Invalid input. Input must be a non-negative integer.");
            okayToLog = false;
        }
        if (!validReps) {
            errorLabel.setText("Invalid input. Input must be a non-negative integer.");
            okayToLog = false;
        }

        if (okayToLog) {
            int intSets = Integer.parseInt(Sets);
            int intReps = Integer.parseInt(Reps);

            WorkoutLog workoutLog = new WorkoutLog(Date, Exercise, intSets, intReps);
            Write.writeFile(workoutLog.toWriteFile());
        }
    }

}