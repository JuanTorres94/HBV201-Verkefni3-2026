package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import is.vidmot.switcher.ViewSwitcher;

import java.io.IOException;

public class FerdaplanApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewSwitcher.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(FerdaplanApp.class.getResource("adal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ferðaplan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
