package pl.mw.input;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import pl.mw.model.Gym;
import pl.mw.model.Run;
import pl.mw.model.Stretching;
import pl.mw.model.Training;


public class UserInputManager {
    private final Scanner scanner;

    public UserInputManager() {
        this.scanner = new Scanner(System.in);
    }

    public Training nextTraining() {
        System.out.println("Enter the type of training: (Run/Gym/Stretching) or 'quit' to exit:  ");
        String trainingType = scanner.nextLine();
        if (!isValidAction(trainingType)) {
            System.out.println("Invalid action. Please enter 'Run', 'Gym', 'Stretching' or 'quit' ");
            return nextTraining();
        }
        if (trainingType.equalsIgnoreCase("quit")) {
            return null;
        }
        System.out.println("Enter the date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the duration (HH:MM): ");
        LocalTime duration = LocalTime.parse(scanner.nextLine());

        System.out.println("Enter the description: ");
        String description = scanner.nextLine();

        if (trainingType.equalsIgnoreCase("Run")) {
            System.out.println("Enter the distance (in kilometers): ");
            double distance = Double.parseDouble(scanner.nextLine());
            return new Run(date, duration, description, distance);
        } else if (trainingType.equalsIgnoreCase("Gym")) {
            return new Gym(date, duration, description);
        } else if (trainingType.equalsIgnoreCase("Stretching")) {
            return new Stretching(date, duration, description);
        } else {
            throw new IllegalArgumentException("Invalid training type: " + trainingType);
        }
    }

    private boolean isValidAction(String action) {
        return action.equalsIgnoreCase("Run") || action.equalsIgnoreCase("Gym") || action.equalsIgnoreCase("Stretching") || action.equalsIgnoreCase("quit");
     }
}
