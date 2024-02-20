package pl.mw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Training {
    protected String trainingType;
    protected LocalDate date;
    protected LocalTime duration;
    protected String description;


    public Training(String trainingType, LocalDate date, LocalTime duration, String description) {
        this.trainingType = trainingType;
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Training Type: " + trainingType  +
                ", date: " + date  +
                ", duration: " + duration  +
                ", description: " + description;
    }
}
