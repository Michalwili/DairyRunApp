package pl.mw.input;

import java.time.DateTimeException;
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
        boolean validInput = false;
        Training training = null;
        while (!validInput) {
            try {
                System.out.println("Enter the type of training: (Run/Gym/Stretching) or 'quit' to exit:  ");
                String trainingType = scanner.nextLine();
                if (!isValidAction(trainingType)) {
                    System.out.println("Invalid action. Please enter 'Run', 'Gym', 'Stretching' or 'quit' ");
                    continue;
                }
                if (trainingType.equalsIgnoreCase("quit")) {
                    return null;
                }
                System.out.println("Enter the date (YYYY-MM-DD): ");
                LocalDate date = parseLocalDate(scanner.nextLine());

                System.out.println("Enter the duration (HH:MM): ");
                LocalTime duration = parseLocalTime(scanner.nextLine());

                System.out.println("Enter the description: ");
                String description = scanner.nextLine();

                if (trainingType.equalsIgnoreCase("Run")) {
                    System.out.println("Enter the distance (in kilometers): ");
                    double distance = parseDouble(scanner.nextLine());
                    return new Run(date, duration, description, distance);
                } else if (trainingType.equalsIgnoreCase("Gym")) {
                    return new Gym(date, duration, description);
                } else if (trainingType.equalsIgnoreCase("Stretching")) {
                    return new Stretching(date, duration, description);
                } else {
                    throw new IllegalArgumentException("Invalid training type: " + trainingType);
                }
            } catch (DateTimeException e) {
                System.out.println("Invalid date/time format. Please enter a valid date/time format.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid distance format. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return training;
    }

    private double parseDouble(String input) {
        return Double.parseDouble(input);
    }

    private LocalTime parseLocalTime(String input) {
        return LocalTime.parse(input);
    }

    private LocalDate parseLocalDate(String input) {
        return LocalDate.parse(input);
    }

    private boolean isValidAction(String action) {
        return action.equalsIgnoreCase("Run") || action.equalsIgnoreCase("Gym") || action.equalsIgnoreCase("Stretching") || action.equalsIgnoreCase("quit");
     }
}
