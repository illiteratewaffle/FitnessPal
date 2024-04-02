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
            String logExercise = Exercise.getText();
            String logSets = Sets.getText();
            String logReps = Reps.getText();

            logInput(logDate, logExercise, logSets, logReps);

        } catch (NumberFormatException e) {
            errorLabel.setText("Enter numbers only for Sets and/or Reps. (e.g. 3, 8, 12)");
        } catch (Exception e) {
            System.out.println("strange... an error occurred.");
        }
    }

    /**
     * Takes the information given in the text fields and writes it to file.
     *
     * @param Date
     * @param Exercise
     * @param Sets
     * @param Reps
     */
    private void logInput(String Date, String Exercise, String Sets, String Reps) {
        LogInput logInput = new LogInput();
        String logDate = logInput.inputDate(Date);
        String logExercise = logInput.inputExercise(Exercise);
        int logSets = logInput.inputSets(Sets);
        int logReps = logInput.inputReps(Reps);

        // everything works but todo: make sure user gets error message on gui

        WorkoutLog workoutLog = new WorkoutLog(logDate, logExercise, logSets, logReps);
        Write.writeFile(workoutLog.toWriteFile());
    }

}