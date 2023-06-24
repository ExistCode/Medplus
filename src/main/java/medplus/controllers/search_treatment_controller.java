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
import medplus.data.TreatmentData;
import medplus.tableModels.TreatmentTableDataModel;

public class search_treatment_controller {

    @FXML
    private ImageView Analysis_btn;

    @FXML
    private TextField searchTreatmentText;

    @FXML
    private Button analysisButton;

    @FXML
    private Pane dashboardbutton;

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
    private Pane addButton;

    @FXML
    private Pane deleteButton;

    @FXML
    private Pane updateButton;

    @FXML
    private TableView<TreatmentTableDataModel> treatmentTable;

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
        App.setRoot("add_treatment_screen");
    }

    @FXML
    void deleteRow(MouseEvent event) {
        treatmentTable.getItems().removeAll(treatmentTable.getSelectionModel().getSelectedItems());
        String selectedRowId = treatmentTable.getSelectionModel().getSelectedItem().getTreatmentId().toString();
        int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1))
                + 1;
        String newTreatmentIdFormatted = String.format("T%03d", selectedRowIdPlusOne);
        TreatmentData.deleteTreatmentById(newTreatmentIdFormatted);

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        TreatmentTableDataModel selectedTreatment = treatmentTable.getSelectionModel().getSelectedItem();
        if (selectedTreatment != null) {
            try {
                TreatmentData.initTreatmentData.setTreatmentId(selectedTreatment.getTreatmentId());
                TreatmentData.initTreatmentData.setPatientName(selectedTreatment.getPatientName());
                TreatmentData.initTreatmentData.setStaffId(selectedTreatment.getStaffId());
                TreatmentData.initTreatmentData.setStartDate(selectedTreatment.getStartDate());
                TreatmentData.initTreatmentData.setEndDate(selectedTreatment.getEndDate());
                TreatmentData.initTreatmentData.setTreatmentInfo(selectedTreatment.getTreatmentInfo());
                App.setRoot("update_treatment_screen");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    @FXML
    public void initialize() {
        ObservableList<TreatmentTableDataModel> treatmentDataList = TreatmentTableDataModel
                .convertTreatmentDataToTreatmentTableDataModel();

        TableColumn treatmentIdColumn = new TableColumn("Treatment ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn startDateColumn = new TableColumn("Start Date");
        TableColumn endDateColumn = new TableColumn("End Date");
        TableColumn treatmentInfoColumn = new TableColumn("Treatment Info");

        treatmentTable.getColumns().addAll(treatmentIdColumn, patientNameColumn, staffIdColumn, startDateColumn,
                endDateColumn, treatmentInfoColumn);

        // Set cell value factories for each TableColumn
        treatmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        treatmentInfoColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentInfo"));
        treatmentTable.setItems(treatmentDataList);

        FilteredList<TreatmentTableDataModel> filteredData = new FilteredList<>(treatmentDataList, b -> true);
        searchTreatmentText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(TreatmentTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (TreatmentTableDataModel.getPatientName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (TreatmentTableDataModel.getTreatmentId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (TreatmentTableDataModel.getStaffId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (TreatmentTableDataModel.getStartDate().toString().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;
                } else if (TreatmentTableDataModel.getEndDate().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (TreatmentTableDataModel.getTreatementInfo().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<TreatmentTableDataModel> sortedTreatmentData = new SortedList<>(filteredData);
        sortedTreatmentData.comparatorProperty().bind(treatmentTable.comparatorProperty());
        treatmentTable.setItems(sortedTreatmentData);

        /*
         * treatmentTable.setOnMouseClicked(event -> {
         * if (event.getClickCount() == 2) {
         * TreatmentTableDataModel selectedTreatment =
         * treatmentTable.getSelectionModel().getSelectedItem();
         * if (selectedTreatment != null) {
         * 
         * TreatmentData.initTreatmentData.setPatientName(selectedTreatment.
         * getPatientName());
         * TreatmentData.initTreatmentData.setDoctorId(selectedTreatment.getDoctorId());
         * TreatmentData.initTreatmentData.setStartDate(selectedTreatment.getStartDate()
         * );
         * TreatmentData.initTreatmentData.setEndDate(selectedTreatment.getEndDate());
         * TreatmentData.initTreatmentData.setTreatmentInfo(selectedTreatment.
         * getTreatmentInfo());
         * 
         * System.out.println(TreatmentData.initTreatmentData.getPatientName());
         * System.out.println(TreatmentData.initTreatmentData.getDoctorId());
         * System.out.println(TreatmentData.initTreatmentData.getStartDate());
         * System.out.println(TreatmentData.initTreatmentData.getEndDate());
         * System.out.println(TreatmentData.initTreatmentData.getTreatmentInfo());
         * }
         * }
         * 
         * });
         * 
         * }
         */
    }
}
