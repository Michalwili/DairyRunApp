package pl.mw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Stretching extends Training {
    public Stretching(LocalDate date, LocalTime duration, String description) {
        super(TrainingType.STRETCHING, date, duration, description);
    }
}
