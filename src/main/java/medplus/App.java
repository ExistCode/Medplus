package medplus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import medplus.data.PatientData;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("login_screen"), 1280, 720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {

        // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml +
        // ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));

        // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml +
        // ".fxml"));

        // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml +
        // ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        PatientData.main(null);
        launch();

    }

}