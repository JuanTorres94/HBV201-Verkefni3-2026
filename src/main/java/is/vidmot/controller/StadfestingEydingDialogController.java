package is.vidmot.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class StadfestingEydingDialogController {
    private boolean confirmed = false;

    @FXML
    private void onConfirm(ActionEvent event) {
        confirmed = true;
        closeDialog(event);
    }

    @FXML
    private void onCancel(ActionEvent event) {
        confirmed = false;
        closeDialog(event);
    }

    private void closeDialog(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}