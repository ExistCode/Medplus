package medplus.tableModels;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import medplus.App;
import medplus.data.ResponsibilitiesData;
import medplus.models.Responsibilities;

public class ResponsibilitiesTableDataModel {
    private SimpleStringProperty responsibilityId;
    private SimpleStringProperty responsibilityName;
    private SimpleStringProperty responsibilityDescription;
    private SimpleStringProperty staffId;

    public ResponsibilitiesTableDataModel(String responsibilityId, String responsibilityName,
            String responsibilityDescription, String staffId) {
        this.responsibilityId = new SimpleStringProperty(responsibilityId);
        this.responsibilityName = new SimpleStringProperty(responsibilityName);
        this.responsibilityDescription = new SimpleStringProperty(responsibilityDescription);
        this.staffId = new SimpleStringProperty(staffId);
    }

    public static ObservableList<ResponsibilitiesTableDataModel> convertResponsibilitiesDataToTableDataModel(
            String id) {
        List<Responsibilities> initialResponsibilitiesList = ResponsibilitiesData
                .fetchResponsibilitiesDataFromDatabasebyId(id);
        ObservableList<ResponsibilitiesTableDataModel> convertedList = FXCollections.observableArrayList();

        for (Responsibilities responsibility : initialResponsibilitiesList) {
            String responsibilityId = responsibility.getResponsibilityId();
            String responsibilityName = responsibility.getResponsibilityName();
            String responsibilityDescription = responsibility.getResponsibilityDescription();
            String staffId = responsibility.getStaffId();

            convertedList.add(
                    new ResponsibilitiesTableDataModel(responsibilityId, responsibilityName, responsibilityDescription,
                            staffId));
        }

        return convertedList;
    }

    public void detailsButtonAction(ActionEvent event) throws IOException {
        App.setRoot("responsibilities_details_screen");
    }

    public String getResponsibilityId() {
        return responsibilityId.get();
    }

    public SimpleStringProperty responsibilityIdProperty() {
        return responsibilityId;
    }

    public void setResponsibilityId(String responsibilityId) {
        this.responsibilityId.set(responsibilityId);
    }

    public String getResponsibilityName() {
        return responsibilityName.get();
    }

    public SimpleStringProperty responsibilityNameProperty() {
        return responsibilityName;
    }

    public void setResponsibilityName(String responsibilityName) {
        this.responsibilityName.set(responsibilityName);
    }

    public String getResponsibilityDescription() {
        return responsibilityDescription.get();
    }

    public SimpleStringProperty responsibilityDescriptionProperty() {
        return responsibilityDescription;
    }

    public void setResponsibilityDescription(String responsibilityDescription) {
        this.responsibilityDescription.set(responsibilityDescription);
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
}
