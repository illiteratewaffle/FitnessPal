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

public class FitnessPalLoginController{

    private static String username;

    @FXML
    private TextField usernameText;

    @FXML
    protected void loginClick(ActionEvent event) {
        try {

            if (usernameText.getText() != null) {
                username = usernameText.getText();
                System.out.println("username: " + username); //debugging purposes
            }

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FitnessPalMenu.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 480, 240);

            stage.setTitle("FitnessPal User Logged In");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUsername() {
        return username;
    }

    public static void logoutUsername() {
        FitnessPalLoginController.username = null;
    }

}
