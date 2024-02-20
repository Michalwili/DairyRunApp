package pl.mw.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.mw.model.Training;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TrainingWriter {

    public static void writeToTxtFile(List<Training> trainingList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Training training : trainingList) {
                writer.write(training.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
