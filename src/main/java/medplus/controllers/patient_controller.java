package medplus.controllers;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.tableModels.PatientTableDataModel;

public class patient_controller {

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
    private TextField searchField;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsButton;

    @FXML
    private Pane searchButton;

    @FXML
    private Pane staffButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients_screen");
    }

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

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
        initializePatientTableData();
        searchPatient();

        patientsTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                PatientTableDataModel selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {

                    try {
                        PatientData.initPatientData.setPatientId(selectedPatient.getPatientId());
                        PatientData.initPatientData.setName(selectedPatient.getName());
                        PatientData.initPatientData.setPatientGender(selectedPatient.getGender());
                        PatientData.initPatientData.setDateOfBirth(selectedPatient.getDateOfBirth());
                        PatientData.initPatientData.setPatientBloodType(selectedPatient.getBloodType());
                        PatientData.initPatientData.setPatientHeight(selectedPatient.getHeight());
                        PatientData.initPatientData.setPatientWeight(selectedPatient.getWeight());
                        App.setRoot("patients_details_screen_analysis");

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        });

    }

    @FXML
    public void initializePatientTableData() {
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
    }

    @FXML
    public void searchPatient() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();

        FilteredList<PatientTableDataModel> filteredData = new FilteredList<>(patientDataList, b -> true);
        searchField.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(PatientTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (PatientTableDataModel.getPatientId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (PatientTableDataModel.getName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (PatientTableDataModel.getGender().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Integer.toString(PatientTableDataModel.getAge()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (PatientTableDataModel.getBloodType().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Double.toString(PatientTableDataModel.getHeight()).toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                } else if (Double.toString(PatientTableDataModel.getWeight()).toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<PatientTableDataModel> sortedPatientData = new SortedList<>(
                filteredData);
        sortedPatientData.comparatorProperty().bind(patientsTable.comparatorProperty());
        patientsTable.setItems(sortedPatientData);
    }
}
