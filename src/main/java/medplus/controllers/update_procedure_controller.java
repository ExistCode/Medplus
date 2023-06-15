package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class update_procedure_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private TextField doctorIDTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private ComboBox<?> procedureComboBox;

    @FXML
    private DatePicker procedureDatePicker;

    @FXML
    private TextField procedureDetailsTextField;

    @FXML
    private TextField procedureTimeTextField;

    @FXML
    private Pane updateProcedureButton;

    @FXML
    void backToSearch(MouseEvent event) throws IOException{
        App.setRoot("search_procedure_screen");
    }

}
