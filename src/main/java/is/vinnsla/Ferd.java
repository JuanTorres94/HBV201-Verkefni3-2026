package is.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ferd {
    private final StringProperty nafn = new SimpleStringProperty();
    private final StringProperty afangastadur = new SimpleStringProperty();
    private final StringProperty dagsetning = new SimpleStringProperty();

    public Ferd(String nafn, String afangastadur, String dagsetning) {
        this.nafn.set(nafn);
        this.afangastadur.set(afangastadur);
        this.dagsetning.set(dagsetning);
    }

    public StringProperty nafnProperty() {
        return nafn;
    }

    public String getNafn() {
        return nafn.get();
    }

    public void setNafn(String nafn) {
        this.nafn.set(nafn);
    }

    public StringProperty afangastadurProperty() {
        return afangastadur;
    }

    public String getAfangastadur() {
        return afangastadur.get();
    }

    public void setAfangastadur(String afangastadur) {
        this.afangastadur.set(afangastadur);
    }

    public StringProperty dagsetningProperty() {
        return dagsetning;
    }

    public String getDagsetning() {
        return dagsetning.get();
    }

    public void setDagsetning(String dagsetning) {
        this.dagsetning.set(dagsetning);
    }

    @Override
    public String toString() {
        return nafn.get() + " - " + afangastadur.get() + " (" + dagsetning.get() + ")";
    }
}
