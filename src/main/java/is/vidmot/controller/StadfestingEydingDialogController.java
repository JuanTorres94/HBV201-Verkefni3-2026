package is.vidmot.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class StadfestingEydingDialogController {
    private boolean confirmed = false;

    @FXML
    private void onConfirm(ActionEvent event) {
        confirmed = true;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancel(ActionEvent event) {
        confirmed = false;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}