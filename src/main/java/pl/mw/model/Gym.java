package pl.mw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Gym extends Training {
    public Gym(LocalDate date, LocalTime duration, String description) {
        super("Gym", date, duration, description);
    }
}
