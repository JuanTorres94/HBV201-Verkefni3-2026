package is.vidmot.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import is.vinnsla.Ferd;

public class FerdDialogController {
    @FXML
    private TextField nafnField;
    @FXML
    private TextField afangastadurField;
    @FXML
    private TextField dagsetningField;

    private Ferd ferd;
    private boolean confirmed = false;

    @FXML
    private void onBaetaVid(ActionEvent event) {
        if (validateInputs()) {
            ferd = new Ferd(nafnField.getText(), afangastadurField.getText(), dagsetningField.getText());
            confirmed = true;
            closeDialog(event);
        }
    }

    @FXML
    private void onHaettaVid(ActionEvent event) {
        confirmed = false;
        closeDialog(event);
    }

    private void closeDialog(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private boolean validateInputs() {
        return !nafnField.getText().trim().isEmpty() &&
                !afangastadurField.getText().trim().isEmpty() &&
                !dagsetningField.getText().trim().isEmpty();
    }

    public Ferd getFerd() {
        return ferd;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
