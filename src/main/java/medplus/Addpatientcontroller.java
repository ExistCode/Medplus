package medplus;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Addpatientcontroller {
    @FXML
    private MenuButton BloodTypeButton;
    @FXML
    private MenuItem aminus;

    @FXML
    private Pane addPatientButton;

    @FXML
    private ImageView backButton;

    @FXML
    void addPatient(MouseEvent event) throws IOException {
        App.setRoot("homescreen");

    }

    @FXML
    void backToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients");

    }

    @FXML
    void getSelected(ActionEvent event) {
        BloodTypeButton.setText("kontol");

    }
}
