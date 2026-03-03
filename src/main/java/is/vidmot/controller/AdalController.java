package is.vidmot.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;
import is.vinnsla.FerdaPlan;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.io.IOException;

public class AdalController {
    @FXML
    private ListView<Ferd> ferdaListView;
    @FXML
    private Button skodaButton;
    @FXML
    private Button eydaButton;

    private FerdaPlan ferdaPlan;

    @FXML
    public void initialize() {
        ferdaPlan = FerdaPlan.getInstance();
        ferdaListView.setItems(ferdaPlan.getFerdir());
        bindButtonStates();
    }

    private void bindButtonStates() {
        skodaButton.disableProperty().bind(ferdaListView.getSelectionModel().selectedItemProperty().isNull());
        eydaButton.disableProperty().bind(ferdaListView.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    private void onSkoda() {
        Ferd selectedFerd = ferdaListView.getSelectionModel().getSelectedItem();
        if (selectedFerd != null) {
            System.out.println("Selected Ferd: " + selectedFerd);
            try {
                ViewSwitcher.switchTo(View.FERD, false, selectedFerd);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No item selected!");
        }
    }

    @FXML
    private void onBaetaVid() {
        Ferd newFerd = FerdDialogWrapper.showAddFerdDialog((Stage) ferdaListView.getScene().getWindow());
        if (newFerd != null) {
            ferdaPlan.getFerdir().add(newFerd);
        }
    }

    @FXML
    private void onEyda() {
        Ferd selectedFerd = ferdaListView.getSelectionModel().getSelectedItem();
        if (selectedFerd != null) {
            showDeleteConfirmationDialog(selectedFerd);
        }
    }

    private void showDeleteConfirmationDialog(Ferd selectedFerd) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/is/vidmot/stadfestingEyda-dialog.fxml"));
            Parent root = loader.load();
            StadfestingEydingDialogController controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Staðfesta eyðingu");
            dialogStage.setScene(new Scene(root, 300, 150));
            dialogStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            dialogStage.showAndWait();

            if (controller.isConfirmed()) {
                ferdaPlan.getFerdir().remove(selectedFerd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
