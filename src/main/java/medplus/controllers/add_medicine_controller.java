package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class add_medicine_controller {

    @FXML
    private Pane addMedicineButton;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField doseInfoTextField;

    @FXML
    private TextField medAmountTextField;

    @FXML
    private TextField medNameTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_medicine_screen");

    }

}
