package medplus.controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.MedicineData;
import medplus.data.PatientData;
import medplus.tableModels.MedicineTableDataModel;
import medplus.tableModels.PatientTableDataModel;

public class search_medicine_controller {

    @FXML
    private ImageView Analysis_btn;

    @FXML
    private Pane addButton;

    @FXML
    private Button analysisButton;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane deleteButton;

    @FXML
    private Button diagnosisButton;

    @FXML
    private Button medicineButton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Button procedureButton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    private Button treatmentButton;

    @FXML
    private Pane updateButton;

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
    void deleteRow(MouseEvent event) {
        medicineTable.getItems().removeAll(medicineTable.getSelectionModel().getSelectedItems());
        String selectedRowId = medicineTable.getSelectionModel().getSelectedItem().getMedicineId().toString();
        int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1))
                + 1;
        String newMedicineIdFormatted = String.format("M%03d", selectedRowIdPlusOne);
        MedicineData.deleteMedicineById(newMedicineIdFormatted);

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        MedicineTableDataModel selectedMedicine = medicineTable.getSelectionModel().getSelectedItem();
        if (selectedMedicine != null) {
            try {
                MedicineData.initMedicineData.setMedicineId(selectedMedicine.getMedicineId());
                MedicineData.initMedicineData.setPatientName(selectedMedicine.getPatientName());
                MedicineData.initMedicineData.setDoctorId(selectedMedicine.getDoctorId());
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

    @FXML
    public void initialize() {
        ObservableList<MedicineTableDataModel> medicineDataList = MedicineTableDataModel
                .convertMedicineDataToMedicineTableDataModel();

        TableColumn medicineIdColumn = new TableColumn("Medicine ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn doctorIdColumn = new TableColumn("Doctor ID");
        TableColumn medicineNameColumn = new TableColumn("Medicine Name");
        TableColumn amountColumn = new TableColumn("Amount");
        TableColumn doseDetailColumn = new TableColumn("Dose Detail");

        medicineTable.getColumns().addAll(medicineIdColumn, patientNameColumn, doctorIdColumn, medicineNameColumn,
                amountColumn, doseDetailColumn);

        // Set cell value factories for each TableColumn
        medicineIdColumn.setCellValueFactory(new PropertyValueFactory<>("medicineId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        medicineNameColumn.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        doseDetailColumn.setCellValueFactory(new PropertyValueFactory<>("doseDetail"));

        medicineTable.setItems(medicineDataList);

        medicineTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                MedicineTableDataModel selectedMedicine = medicineTable.getSelectionModel().getSelectedItem();
                if (selectedMedicine != null) {

                    MedicineData.initMedicineData.setPatientName(selectedMedicine.getPatientName());
                    MedicineData.initMedicineData.setDoctorId(selectedMedicine.getDoctorId());
                    MedicineData.initMedicineData.setMedicineName(selectedMedicine.getMedicineName());
                    MedicineData.initMedicineData.setAmount(selectedMedicine.getAmount());
                    MedicineData.initMedicineData.setDoseDetail(selectedMedicine.getDoseDetail());

                    System.out.println(MedicineData.initMedicineData.getPatientName());
                    System.out.println(MedicineData.initMedicineData.getDoctorId());
                    System.out.println(MedicineData.initMedicineData.getMedicineName());
                    System.out.println(MedicineData.initMedicineData.getAmount());
                    System.out.println(MedicineData.initMedicineData.getDoseDetail());
                }
            }

        });
    }
}
