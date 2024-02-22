package pl.mw.data;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.mw.model.Gym;
import pl.mw.model.Run;
import pl.mw.model.Stretching;
import pl.mw.model.Training;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainingWriterTest {
    private final String fileName = "test_training_data.txt";
    private TrainingWriter trainingWriter;
    private final Logger logger = Logger.getLogger(TrainingWriter.class.getName());
    private Handler consoleHandler;

    @Before
    public void setUp() {
        trainingWriter = new TrainingWriter(fileName);

        consoleHandler = logger.getParent().getHandlers()[0];
        logger.removeHandler(consoleHandler);
    }

    @After
    public void tearDown() {
        logger.addHandler(consoleHandler);

        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteToTxtFile() throws IOException {
        List<Training> trainingList = new ArrayList<>();
        trainingList.add(new Run(LocalDate.now(), LocalTime.of(1, 30), "Morning Run", 5.0));
        trainingList.add(new Gym(LocalDate.now(), LocalTime.of(1, 0), "Gym Workout"));
        trainingList.add(new Stretching(LocalDate.now(), LocalTime.of(0, 30), "Evening Stretching"));

        trainingWriter.writeToTxtFile(trainingList);

        assertTrue(Files.exists(Path.of(fileName)));

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        assertEquals(3, lines.size());
        assertEquals("Training Type: RUN, date: " + LocalDate.now() + ", duration: 01:30, description: Morning Run, distance: 5.0 km", lines.get(0));
        assertEquals("Training Type: GYM, date: " + LocalDate.now() + ", duration: 01:00, description: Gym Workout", lines.get(1));
        assertEquals("Training Type: STRETCHING, date: " + LocalDate.now() + ", duration: 00:30, description: Evening Stretching", lines.get(2));
    }
}

