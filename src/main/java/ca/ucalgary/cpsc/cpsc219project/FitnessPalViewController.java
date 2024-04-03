package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalViewController {

    private Stage stage;

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

            stage.setTitle("Sorting by Date");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
