package medplus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class PrimaryController {

    @FXML
    private Button button;

    @FXML
    void SignIn(ActionEvent event) throws IOException {
        App.setRoot("secondary");

    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
