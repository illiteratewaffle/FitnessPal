package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalViewController {

    private Stage stage;
    @FXML
    private TextField specificExercise;
    private String sortBy;

    @FXML
    protected void onSortByRecentClick(ActionEvent event) {

        sortBy = "RECENT";

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FitnessPalSorted.fxml"));
            Parent root = fxmlLoader.load();
            FitnessPalSortedController sortedController = fxmlLoader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);

            sortedController.loadTitle(sortBy);
            sortedController.loadLogs(sortBy);
            sortedController.calculateLogs();

            stage.setTitle("Sorting by Recently Added");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSortByExerciseClick(ActionEvent event) {

        sortBy = "EXERCISE";

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FitnessPalSorted.fxml"));
            Parent root = fxmlLoader.load();
            FitnessPalSortedController sortedController = fxmlLoader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);

            sortedController.loadTitle(sortBy);
            sortedController.loadLogs(sortBy);
            sortedController.calculateLogs();

            stage.setTitle("Sorting by Exercise");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSortByDateClick(ActionEvent event) {
        sortBy = "DATE";

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FitnessPalSorted.fxml"));
            Parent root = fxmlLoader.load();
            FitnessPalSortedController sortedController = fxmlLoader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);

            sortedController.loadTitle(sortBy);
            sortedController.loadLogs(sortBy);
            sortedController.calculateLogs();

            stage.setTitle("Sorting by Date");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSpecificExerciseClick(ActionEvent event) {
        String seeSpecificExercise;
        sortBy = "SPECIFIC";

        seeSpecificExercise = specificExercise.getText().toUpperCase();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FitnessPalSorted.fxml"));
            Parent root = fxmlLoader.load();
            FitnessPalSortedController sortedController = fxmlLoader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);

            sortedController.loadTitle(sortBy);
            sortedController.loadLogs(sortBy, seeSpecificExercise);
            sortedController.calculateLogs();

            stage.setTitle("Exercise: \"" + specificExercise.getText() + "\"");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
