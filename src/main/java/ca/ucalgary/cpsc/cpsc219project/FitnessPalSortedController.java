package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
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
     * Loads sorted logs into ScrollPane
     *
     * @param sortBy
     */
    public void loadLogs(String sortBy) {
        Read reader = new Read(sortBy);
        ArrayList<String> logsList = reader.sort(reader.getChoice());
        VBox vbox = new VBox();

        for (int i = 0; i < logsList.size(); i++) {
            Label label = new Label();
            label.setText(logsList.get(i));
            vbox.getChildren().add(label);
        }
        workouts.setContent(vbox);
    }

    public void calculateLogs() {
        Read reader = new Read();
        Counter counter = new Counter(reader.getLines());
        ArrayList<String> calculationMessages = counter.displayCount();
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
