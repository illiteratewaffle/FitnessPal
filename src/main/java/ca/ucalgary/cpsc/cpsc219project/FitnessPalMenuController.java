package ca.ucalgary.cpsc.cpsc219project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalMenuController extends Application {



    @FXML
    protected void onAddWorkoutClick() {

    }


    @FXML
    protected void onViewWorkoutsClick() {
        System.out.println("open view workouts menu");
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessPalApplication.class.getResource("FitnessPalLogs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 240);

        stage.setTitle("Add Workout");
        stage.setScene(scene);

        stage.show();
    }
}