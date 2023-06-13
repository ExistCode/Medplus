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

public class update_analysis_controller {

    @FXML
    private TextField ResultsTextField;

    @FXML
    private ComboBox<?> analysisTypeComboBox;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateAnalysisDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField testInformationTextField;

    @FXML
    private Pane updateAnalysisButton;

    @FXML
    void backToSearch(MouseEvent event) throws IOException{
        App.setRoot("search_home_screen");
    }

}
