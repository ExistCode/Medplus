package medplus.controllers;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.tableModels.PatientTableDataModel;

public class patient_controller {

    //
    @FXML
    private Pane analysisButton;

    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<PatientTableDataModel> patientsTable;

    @FXML
    private TextField searchButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients_screen");
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
    private Pane deleteButton;
    @FXML
    private Pane updateButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen");

    }

    @FXML
    void deleteRow(MouseEvent event) {
        patientsTable.getItems().removeAll(patientsTable.getSelectionModel().getSelectedItems());

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        App.setRoot("update_patients_screen");
    }

    @FXML
    void changedToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    void changedToAnalysis(MouseEvent event) {

    }

    @FXML
    void changedToDiagnosis(MouseEvent event) {

    }

    @FXML
    void changedToTreatment(MouseEvent event) {

    }

    @FXML
    public void initialize() {

        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        Button[] detailsButton = new Button[patientDataList.size()];
        TableColumn patientIdColumn = new TableColumn("Patient ID");
        TableColumn nameColumn = new TableColumn("Name");
        TableColumn genderColumn = new TableColumn("Gender");
        TableColumn dateOfBirthColumn = new TableColumn("Date of Birth");
        TableColumn ageColumn = new TableColumn("Age");
        TableColumn bloodTypeColumn = new TableColumn("Blood Type");
        TableColumn heightColumn = new TableColumn("Height");
        TableColumn weightColumn = new TableColumn("Weight");

        // for (int i = 0; i < detailsButton.length; i++) {
        // detailsButton[i] = new Button();

        // detailsButton[i].setOnAction(e -> {
        // try {
        // detailsButtonAction(e);
        // System.out.println("keklik");
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // }
        // });
        // }

        patientsTable.getColumns().addAll(patientIdColumn, nameColumn, genderColumn,
                dateOfBirthColumn, ageColumn, bloodTypeColumn, heightColumn, weightColumn);

        // Set cell value factories for each TableColumn
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        bloodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("bloodType"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        patientsTable.setItems(patientDataList);
        patientsTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    PatientTableDataModel selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
                    if (selectedPatient != null) {
                        App.setRoot("patients_details_screen");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // patientsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
        // public void handle(MouseEvent event) {
        // if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
        // System.out.println(patientsTable.getSelectionModel().getSelectedItem());
        // }
        // }
        // });
    }

    // public void detailsButtonAction(MouseEvent event) throws IOException {
    // App.setRoot("patients_details_screen");
    // }

    // ...

    @FXML
    private void deleteRowFromTable(ActionEvent event) {

    }

}
