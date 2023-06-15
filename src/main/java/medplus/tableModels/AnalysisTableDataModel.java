package medplus.tableModels;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import medplus.App;
import medplus.data.AnalysisData;
import medplus.data.PatientData;
import medplus.models.Analysis;
import medplus.models.Patient;

public class AnalysisTableDataModel {
    private SimpleStringProperty analysisId;
    private SimpleStringProperty patientName;
    private SimpleStringProperty staffId;
    private SimpleStringProperty typeOfTest;
    private SimpleStringProperty resultSummary;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleStringProperty testInformation;

    public AnalysisTableDataModel(String analysisId, String patientName, String staffId, String typeOfTest, String resultSummary, LocalDate date, String testInformation) {
        this.analysisId = new SimpleStringProperty(analysisId);
        this.patientName = new SimpleStringProperty(patientName);
        this.staffId = new SimpleStringProperty(staffId);
        this.typeOfTest = new SimpleStringProperty(typeOfTest);
        this.resultSummary = new SimpleStringProperty(resultSummary);
        this.date = new SimpleObjectProperty<>(date);
        this.testInformation = new SimpleStringProperty(testInformation);
    }

    public static ObservableList<AnalysisTableDataModel> convertAnalysisDataToAnalysisTableDataModel() {
        List<Analysis> initialAnalysisList = AnalysisData.fetchAnalysisDataFromDatabase();
        ObservableList<AnalysisTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialAnalysisList.size(); i++) {
            String analysisId = initialAnalysisList.get(i).getAnalysisId();
            String patientName = initialAnalysisList.get(i).getPatientName();
            String staffId = initialAnalysisList.get(i).getStaffId();
            String typeOfTest = initialAnalysisList.get(i).getTypeOfTest();
            String resultSummary = initialAnalysisList.get(i).getResultSummary();
            LocalDate date = initialAnalysisList.get(i).getDate();
            String testInformation = initialAnalysisList.get(i).getTestInformation();


            convertedList.add(
                    new AnalysisTableDataModel(analysisId, patientName, staffId, typeOfTest, resultSummary, date, testInformation));
        }

        return convertedList;
    }

    public String getAnalysisId() {
        return analysisId.get();
    }

    public SimpleStringProperty analysisIdProperty() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId.set(analysisId);
    }

    public String getPatientName() {
        return patientName.get();
    }

    public SimpleStringProperty nameProperty() {
        return patientName;
    }

    public void setName(String patientName) {
        this.patientName.set(patientName);
    }

    public String getStaffId() {
        return staffId.get();
    }

    public SimpleStringProperty staffIdProperty() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId.set(staffId);
    }

    public String getTypeOfTest() {
        return typeOfTest.get();
    }

    public SimpleStringProperty typeOfTestProperty() {
        return typeOfTest;
    }

    public void setTypeOfTest(String typeOfTest) {
        this.typeOfTest.set(typeOfTest);
    }

    public String getResultSummary() {
        return resultSummary.get();
    }

    public SimpleStringProperty ResultSummaryProperty() {
        return resultSummary;
    }

    public void setResultSummary(String resultSummary) {
        this.resultSummary.set(resultSummary);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getTestInformation() {
        return testInformation.get();
    }

    public SimpleStringProperty bloodTypeProperty() {
        return testInformation;
    }

    public void setBloodType(String testInformation) {
        this.testInformation.set(testInformation);
    }
}

