package medplus.controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.MedicineData;
import medplus.tableModels.AnalysisTableDataModel;
import medplus.tableModels.MedicineTableDataModel;

public class search_medicine_controller {

    @FXML
    private ImageView Analysis_btn;

    @FXML
    private Pane addButton;

    @FXML
    private Button analysisButton;

    @FXML
    private Pane dashboardButton;

    @FXML
    private Button diagnosisButton;

    @FXML
    private Button medicineButton;

    @FXML
    private Pane patientsButton;

    @FXML
    private Button procedureButton;

    @FXML
    private Pane searchButton;

    @FXML
    private Pane staffButton;

    @FXML
    private Button treatmentButton;

    @FXML
    private Pane updateButton;
    @FXML
    private TextField searchedAnalysisText;

    @FXML
    private TableView<MedicineTableDataModel> medicineTable;

    @FXML
    void changedToAnalysis(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

    @FXML
    void changedToMedicine(MouseEvent event) throws IOException {
        App.setRoot("search_medicine_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");
    }

    @FXML
    void changedToProcedure(MouseEvent event) throws IOException {
        App.setRoot("search_procedure_screen");
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
    void changedToTreatment(MouseEvent event) throws IOException {
        App.setRoot("search_treatment_screen");
    }

    @FXML
    void switchToAddScreen(MouseEvent event) throws IOException {
        App.setRoot("add_medicine_screen");
    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        // Retrieve the selected data and insert it into the empty object

        MedicineTableDataModel selectedMedicine = medicineTable.getSelectionModel().getSelectedItem();
        if (selectedMedicine != null) {
            try {
                MedicineData.initMedicineData.setMedicineId(selectedMedicine.getMedicineId());
                MedicineData.initMedicineData.setPatientName(selectedMedicine.getPatientName());
                MedicineData.initMedicineData.setStaffId(selectedMedicine.getStaffId());
                MedicineData.initMedicineData.setMedicineName(selectedMedicine.getMedicineName());
                MedicineData.initMedicineData.setAmount(selectedMedicine.getAmount());
                MedicineData.initMedicineData.setDoseDetail(selectedMedicine.getDoseDetail());

                App.setRoot("update_medicine_screen");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // Initialize the javafx controller and the table view content
    @FXML
    public void initialize() {
        ObservableList<MedicineTableDataModel> medicineDataList = MedicineTableDataModel
                .convertMedicineDataToMedicineTableDataModel();

        TableColumn medicineIdColumn = new TableColumn("Medicine ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn medicineNameColumn = new TableColumn("Medicine Name");
        TableColumn amountColumn = new TableColumn("Amount");
        TableColumn doseDetailColumn = new TableColumn("Dose Detail");

        medicineTable.getColumns().addAll(medicineIdColumn, patientNameColumn, staffIdColumn, medicineNameColumn,
                amountColumn, doseDetailColumn);

        // Set cell value factories for each TableColumn
        medicineIdColumn.setCellValueFactory(new PropertyValueFactory<>("medicineId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        medicineNameColumn.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        doseDetailColumn.setCellValueFactory(new PropertyValueFactory<>("doseDetail"));

        medicineTable.setItems(medicineDataList);

        FilteredList<MedicineTableDataModel> filteredData = new FilteredList<>(medicineDataList, b -> true);
        searchedAnalysisText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(MedicineTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (MedicineTableDataModel.getPatientName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (MedicineTableDataModel.getMedicineName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (MedicineTableDataModel.getMedicineId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (MedicineTableDataModel.getAmount().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (MedicineTableDataModel.getDoseDetail().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (MedicineTableDataModel.getStaffId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }

                else {
                    return false;
                }
            });
        });
        SortedList<MedicineTableDataModel> sortedMedicineData = new SortedList<>(filteredData);
        sortedMedicineData.comparatorProperty().bind(medicineTable.comparatorProperty());
        medicineTable.setItems(sortedMedicineData);
    }
}
