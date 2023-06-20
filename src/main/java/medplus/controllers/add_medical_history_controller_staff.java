package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class add_medical_history_controller_staff {

    @FXML
    private Pane addAnalysisButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateAnalysisDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField summaryTextField;

    @FXML
    private TextField testInfoTextField;

    @FXML
    void backToStaffDetails(MouseEvent event) throws IOException {
        App.setRoot("staff_details_analysis_screen");
    }

}
