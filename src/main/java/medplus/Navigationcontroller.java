package medplus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Navigationcontroller {

    @FXML
    private Button button;
    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("homescreen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients");

    }

    @FXML
    void changedToSearch(MouseEvent event) throws IOException {
        App.setRoot("search");
    }

    @FXML
    void changedToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff");
    }

    @FXML
    void SignIn(ActionEvent event) throws IOException {
        App.setRoot("homescreen");
    }
}
