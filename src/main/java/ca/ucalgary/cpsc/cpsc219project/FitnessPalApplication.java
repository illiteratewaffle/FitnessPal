package ca.ucalgary.cpsc.cpsc219project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessPalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessPalApplication.class.getResource("FitnessPalMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 240);

        stage.setTitle("FitnessPal");
        stage.setScene(scene);

        stage.show();
    }
}
