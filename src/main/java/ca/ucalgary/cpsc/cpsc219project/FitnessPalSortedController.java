package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FitnessPalSortedController {

    private Stage stage;
    @FXML
    private ScrollPane workouts;
    @FXML
    private Label sortType;
    @FXML
    private Label totalDays;
    @FXML
    private Label totalExercises;
    @FXML
    private Label totalSets;
    @FXML
    private Label totalReps;

    /**
     * Sets the heading of Sorted Menu to user's selection
     *
     * @param sortBy
     */
    public void loadTitle(String sortBy) {
        sortType.setText(sortBy);
    }

    /**
     * Loads sorted logs into ScrollPane.
     * One method for the 3 regular sort, other for seeing specific exercises.
     *
     * @param sortBy
     */
    public void loadLogs(String sortBy) {
        Read reader = new Read(sortBy);
        ArrayList<String> logsList = reader.sort(reader.getChoice());

        GridPane gridPane = new GridPane();
        makeLegend(gridPane);

        for (int numberOfWorkouts = 0; numberOfWorkouts < logsList.size(); numberOfWorkouts++) {
            String[] seperatedLogs = logsList.get(numberOfWorkouts).split(",");

            for (int i = 0; i < 4; i++) {
                Label label = new Label();
                label.setText(seperatedLogs[i] + "      ");
                gridPane.add(label, i, numberOfWorkouts + 2);
            }
        }
        workouts.setContent(gridPane);
    }
    public void loadLogs(String sortBy, String specific) {
        Read reader = new Read(sortBy, specific);
        ArrayList<String> logsList = reader.sort(reader.getChoice());

        GridPane gridPane = new GridPane();
        makeLegend(gridPane);

        for (int numberOfWorkouts = 0; numberOfWorkouts < logsList.size(); numberOfWorkouts++) {
            String[] seperatedLogs = logsList.get(numberOfWorkouts).split(",");

            for (int i = 0; i < 4; i++) {
                Label label = new Label();
                label.setText(seperatedLogs[i] + "      ");
                gridPane.add(label, i, numberOfWorkouts + 2);
            }
        }
        workouts.setContent(gridPane);
    }

    private void makeLegend(GridPane gridPane) {

        Label date = new Label();
        date.setText("DATE      ");
        gridPane.add(date, 0, 0);

        Label exercise = new Label();
        exercise.setText("EXERCISE      ");
        gridPane.add(exercise, 1, 0);

        Label sets = new Label();
        sets.setText("SETS      ");
        gridPane.add(sets, 2, 0);

        Label reps = new Label();
        reps.setText("REPS      ");
        gridPane.add(reps, 3, 0);

        for (int i = 0; i < 4; i++) {
            Label literallyNothing = new Label();
            literallyNothing.setText("  ");
            gridPane.add(literallyNothing, i, 1);
        }

    }

    /**
     * Calculating how many days/exercises/reps/sets user has done.
     */
    public void calculateLogs() {
        Read reader = new Read();
        Counter counter = new Counter(reader.getLines());
        ArrayList<String> calculationMessages = counter.countStats();
        totalDays.setText(calculationMessages.get(0));
        totalExercises.setText(calculationMessages.get(1));
        totalSets.setText(calculationMessages.get(2));
        totalReps.setText(calculationMessages.get(3));
    }

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

}
