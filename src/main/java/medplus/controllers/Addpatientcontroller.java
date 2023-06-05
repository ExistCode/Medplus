package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class Addpatientcontroller {

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

}
