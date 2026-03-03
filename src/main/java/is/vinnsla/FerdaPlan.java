package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FerdaPlan {
    private static FerdaPlan instance;
    private final ObservableList<Ferd> ferdir;

    private FerdaPlan() {
        ferdir = FXCollections.observableArrayList();
        initializeSampleTrips();
    }

    public static FerdaPlan getInstance() {
        if (instance == null) {
            instance = new FerdaPlan();
        }
        return instance;
    }

    private void initializeSampleTrips() {
        ferdir.add(new Ferd("Akranes útilegumenn", "Akranesborg", "15.01.2025"));
        ferdir.add(new Ferd("Snæfellsjökull leiðangur", "Stykkishólmur", "22.02.2025"));
        ferdir.add(new Ferd("Mývatn rannsóknir", "Mývatn", "10.03.2025"));
    }

    public ObservableList<Ferd> getFerdir() {
        return ferdir;
    }
}
