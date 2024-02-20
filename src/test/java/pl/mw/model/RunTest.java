package pl.mw.model;


import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class RunTest {
    @Test
    public void testRunToString() {
        LocalDate date = LocalDate.of(2024, 2, 20);
        LocalTime duration = LocalTime.of(0, 30);
        String description = "Morning run";
        double distance = 5.5;

        Run run = new Run(date, duration, description, distance);

        String expected = "Training Type: Run, date: 2024-02-20, duration: 00:30, description: Morning run, distance: 5.5 km";
        assertEquals(expected, run.toString());

    }

}