module medplus {
    requires javafx.controls;
    requires javafx.fxml;

    opens medplus.controllers to javafx.fxml;

    exports medplus;
}
