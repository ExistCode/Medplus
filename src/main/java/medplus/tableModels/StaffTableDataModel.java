package medplus.tableModels;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import medplus.data.StaffData;
import medplus.models.Staff;

public class StaffTableDataModel {
    private SimpleStringProperty staffId;
    private SimpleStringProperty name;
    private SimpleStringProperty jobTitle;
    private SimpleStringProperty department;
    private SimpleStringProperty email;
    private SimpleStringProperty contactNumber;

    public StaffTableDataModel(String staffId, String name, String jobTitle, String department, String email,
            String contactNumber) {
        this.staffId = new SimpleStringProperty(staffId);
        this.name = new SimpleStringProperty(name);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.department = new SimpleStringProperty(department);
        this.email = new SimpleStringProperty(email);
        this.contactNumber = new SimpleStringProperty(contactNumber);
    }

    public static ObservableList<StaffTableDataModel> convertStaffDataToStaffTableDataModel() {
        List<Staff> initialStaffList = StaffData.fetchStaffDataFromDatabase();
        ObservableList<StaffTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialStaffList.size(); i++) {
            String staffId = initialStaffList.get(i).getStaffId();
            String name = initialStaffList.get(i).getName();
            String jobTitle = initialStaffList.get(i).getStaffJobTitle();
            String department = initialStaffList.get(i).getStaffDepartment();
            String email = initialStaffList.get(i).getStaffEmail();
            String contactNumber = initialStaffList.get(i).getStaffContactNumber();

            convertedList.add(new StaffTableDataModel(staffId, name, jobTitle, department, email, contactNumber));
        }

        return convertedList;
    }

    public void detailsButtonAction(ActionEvent event) throws IOException {
        // App.setRoot("staff_details_screen");
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public SimpleStringProperty jobTitleProperty() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public String getDepartment() {
        return department.get();
    }

    public SimpleStringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public SimpleStringProperty contactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }
}
