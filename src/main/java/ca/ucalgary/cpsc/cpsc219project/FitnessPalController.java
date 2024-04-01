package ca.ucalgary.cpsc.cpsc219project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FitnessPalController {

    @FXML
    protected void onAddWorkoutClick() {
        System.out.println("open add workout menu");
    }

    @FXML
    protected void onViewWorkoutsClick() {
        System.out.println("open view workouts menu");
    }
}