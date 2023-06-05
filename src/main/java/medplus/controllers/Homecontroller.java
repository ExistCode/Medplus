package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;

public class Homecontroller {

    // System.out.println("Current Date = " + strDate);

    @FXML
    private Pane dashboard;
    @FXML
    private Text datetime;
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

    @FXML
    public void initialize() {
        Format f = new SimpleDateFormat("dd MMM yy");
        String strDate = f.format(new Date());
        datetime.setText(strDate);
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
