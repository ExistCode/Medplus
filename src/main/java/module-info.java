module medplus {
    requires javafx.controls;
    requires javafx.fxml;

    opens medplus.controllers to javafx.fxml;
    opens medplus.tableModels;

    exports medplus;
}
