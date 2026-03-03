package is.vidmot.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Custom component to display trip details.
 * Wraps ferd-spjald.fxml and exposes properties for data binding.
 */
public class FerdSpjald extends VBox {
    @FXML
    private TextField fxHeiti;
    @FXML
    private TextField fxAfangastadur;
    @FXML
    private TextField fxDagsetning;

    private final StringProperty heiti = new SimpleStringProperty();
    private final StringProperty afangastadur = new SimpleStringProperty();
    private final StringProperty dagsetning = new SimpleStringProperty();

    /**
     * Constructor that loads the FXML file.
     */
    public FerdSpjald() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/is/vidmot/ferd-spjald.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bindTextFields();
    }

    /**
     * Bind TextFields to the properties so they stay in sync.
     */
    private void bindTextFields() {
        fxHeiti.textProperty().bindBidirectional(heiti);
        fxAfangastadur.textProperty().bindBidirectional(afangastadur);
        fxDagsetning.textProperty().bindBidirectional(dagsetning);
    }

    // Property getters for binding from other controllers
    public StringProperty nafnProperty() {
        return heiti;
    }

    public StringProperty afangastadurProperty() {
        return afangastadur;
    }

    public StringProperty dagsetningProperty() {
        return dagsetning;
    }

    // Value getters
    public String getNafn() {
        return heiti.get();
    }

    public String getAfangastadur() {
        return afangastadur.get();
    }

    public String getDagsetning() {
        return dagsetning.get();
    }

    // Value setters
    public void setNafn(String value) {
        heiti.set(value);
    }

    public void setAfangastadur(String value) {
        afangastadur.set(value);
    }

    public void setDagsetning(String value) {
        dagsetning.set(value);
    }
}
