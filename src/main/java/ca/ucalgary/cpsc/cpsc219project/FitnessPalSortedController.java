package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalSortedController {

    private Stage stage;

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
