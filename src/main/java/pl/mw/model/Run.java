package pl.mw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Run extends Training {
    private double distance;

    public Run(LocalDate date, LocalTime duration, String description, double distance) {
        super("Run", date, duration, description);
        this.distance = distance;
    }

    @Override
    public String toString() {
        return super.toString() + ", distance: " + distance + " km";
    }
}
