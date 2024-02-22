package pl.mw.data;

import pl.mw.model.Training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainingWriter {

    private final String fileName;
    private static final Logger logger = Logger.getLogger(TrainingWriter.class.getName());

    public TrainingWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeToTxtFile(List<Training> trainingList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Training training : trainingList) {
                writer.write(training.toString());
                writer.newLine();
            }
            logger.log(Level.INFO, "Training data has been successfully written to the file.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while writing to the file: " + e.getMessage(), e);
            logger.log(Level.SEVERE, "Please check if the file is accesible.");
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Invalid training data: " + e.getMessage(), e);
            logger.log(Level.SEVERE, "Please ensure all training data is valid.");
        } catch (SecurityException e) {
            logger.log(Level.SEVERE, "Security exception occurred: " + e.getMessage(), e);
            logger.log(Level.SEVERE, "Please check file permissions.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred: " + e.getMessage(), e);
        }
    }
}
