package ca.ucalgary.cpsc.cpsc219project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FitnessPalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}