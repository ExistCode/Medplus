package medplus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Homecontroller {

    @FXML
    private Pane dashboard;
    @FXML
    private Label datetime;
    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;
    @FXML
    private Pane seeDetails;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("homescreen");
    }

    void setDate(String date) {
        datetime.setText(date);
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
    void seePatientsDetails(MouseEvent event) throws IOException {
        App.setRoot("patients_details");

    }
}
