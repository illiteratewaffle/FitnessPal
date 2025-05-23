package ca.ucalgary.cpsc.cpsc219project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// I (Harry) learned how to switch windows: https://www.youtube.com/watch?v=hcM-R-YOKkQ
public class FitnessPalMenuController {

    private Stage stage;
    @FXML
    private Label helpMessage;

    /**
     * When you press "Add Workout"
     *
     * @param event
     */
    @FXML
    protected void onAddWorkoutClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalLogs.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Add Workout");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * When you press "View Workouts"
     *
     * @param event
     */
    @FXML
    protected void onViewWorkoutsClick(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 480, 240);

            stage.setTitle("View Workouts");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onHelpClick() {
        helpMessage.setText("This is a program that helps you track your workout progress. ");
    }

    @FXML
    protected void logout(ActionEvent event) {
        try {
            FitnessPalLoginController.logoutUsername();

            Parent root = FXMLLoader.load(getClass().getResource("FitnessPalLogin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 480, 240);

            stage.setTitle("FitnessPal User Logged Out");
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}