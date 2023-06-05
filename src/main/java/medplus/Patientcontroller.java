package medplus;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Patientcontroller {
    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<?> patientsTable;

    @FXML
    private TextField searchButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients");

    }

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

    // String username = Username.getText();
    // String password = Password.getText();

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

}
