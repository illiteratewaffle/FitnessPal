package ca.ucalgary.cpsc.cpsc219project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalMenuController extends Application {

    @FXML
    protected void onAddWorkoutClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FitnessPalApplication.class.getResource("FitnessPalLogs.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();

            stage.setTitle("Add Workout");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    protected void onViewWorkoutsClick() {
        System.out.println("open view workouts menu");
    }

}