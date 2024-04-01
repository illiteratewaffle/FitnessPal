module ca.ucalgary.cpsc.cpsc219project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ca.ucalgary.cpsc.cpsc219project to javafx.fxml;
    exports ca.ucalgary.cpsc.cpsc219project;
}