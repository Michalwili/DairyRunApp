package pl.mw.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class GymTest {

    @Test
    public void testGymToString() {
        LocalDate date = LocalDate.of(2024, 2, 10);
        LocalTime duration = LocalTime.of(0, 45);
        String description = "Runner Gym";

        Gym gym = new Gym(date, duration, description);

        String expected = "Training Type: Gym, date: 2024-02-10, duration: 00:45, description: Runner Gym";
        assertEquals(expected, gym.toString());
    }

}