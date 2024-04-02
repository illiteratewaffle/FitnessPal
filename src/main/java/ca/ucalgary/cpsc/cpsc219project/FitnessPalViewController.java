package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalViewController {

    private Stage stage;
    private Button Recent;
    private Button Exercise;
    private Button Date;

    @FXML
    protected void onSortByRecentClick(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalSorted.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Sorting by Recently Added");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void onSortByExerciseClick(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalSorted.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Sorting by Exercise");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void onSortByDateClick(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalSorted.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Sorting by Date");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void openSortedMenu() {

    }

}
