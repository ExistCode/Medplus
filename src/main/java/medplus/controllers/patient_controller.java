package medplus.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.models.Patient;
import medplus.tableModels.PatientTableDataModel;

public class patient_controller {

    //

    @FXML
    private Text GenderText;
    @FXML
    private Text dateOfBirthText;

    @FXML
    private Text patientsNameText;

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
        String selectedRowId = patientsTable.getSelectionModel().getSelectedItem().getPatientId().toString();
        int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1))
                + 1;
        String newPatientIdFormatted = String.format("P%03d", selectedRowIdPlusOne);
        PatientData.deletePatientById(newPatientIdFormatted);

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
    public void initialize() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();

        TableColumn patientIdColumn = new TableColumn("Patient ID");
        TableColumn nameColumn = new TableColumn("Name");
        TableColumn genderColumn = new TableColumn("Gender");
        TableColumn dateOfBirthColumn = new TableColumn("Date of Birth");
        TableColumn ageColumn = new TableColumn("Age");
        TableColumn bloodTypeColumn = new TableColumn("Blood Type");
        TableColumn heightColumn = new TableColumn("Height");
        TableColumn weightColumn = new TableColumn("Weight");

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
                PatientTableDataModel selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {

                    try {
                        PatientData.initpatientData.setPatientName(selectedPatient.getName());
                        PatientData.initpatientData.setPatientGender(selectedPatient.getGender());
                        PatientData.initpatientData.setPatientDateOfBirth(selectedPatient.getDateOfBirth());
                        PatientData.initpatientData.setPatientBloodType(selectedPatient.getBloodType());
                        PatientData.initpatientData.setPatientHeight(selectedPatient.getHeight());
                        PatientData.initpatientData.setPatientWeight(selectedPatient.getWeight());

                        System.out.println(PatientData.initpatientData.getPatientName());
                        System.out.println(PatientData.initpatientData.getPatientGender());
                        System.out.println(PatientData.initpatientData.getPatientDateOfBirth());
                        System.out.println(PatientData.initpatientData.getPatientBloodType());
                        System.out.println(PatientData.initpatientData.getPatientHeight());
                        System.out.println(PatientData.initpatientData.getPatientWeight());
                        App.setRoot("patients_details_screen_analysis");

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        });

    }

}
