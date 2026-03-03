package is.vidmot.controller;

import javafx.fxml.FXML;
import is.vidmot.view.FerdSpjald;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;

/**
 * Controller for displaying details of a single trip.
 */
public class FerdController implements GognInterface {
    @FXML
    private FerdSpjald fxFerdSpjald;

    /**
     * Receives a trip and binds its data to the FerdSpjald component.
     */
    @Override
    public void setGogn(Ferd ferd) {
        if (ferd != null) {
            fxFerdSpjald.nafnProperty().bind(ferd.nafnProperty());
            fxFerdSpjald.afangastadurProperty().bind(ferd.afangastadurProperty());
            fxFerdSpjald.dagsetningProperty().bind(ferd.dagsetningProperty());
        }
    }

    @FXML
    private void onTilBaka() {
        try {
            ViewSwitcher.switchTo(View.ADAL, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
