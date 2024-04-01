package ca.ucalgary.cpsc.cpsc219project;

import java.util.Scanner;

public class MenuOptions {
    private String menuOption;
    private final String VIEW = "1";
    private final String ADD = "2";
    private final String EXIT = "3";
    private final String HELP = "4";
    private final Scanner scanner = new Scanner(System.in);

    public MenuOptions() {
        this.menuOption = null;
    }

    public void welcomeMessages() {
        System.out.println("-------------------\nHOME PAGE\n-------------------\nHello and welcome to your FitnessPal");
        System.out.println("\nPlease select from one of the following options:\n" +
                "1) View your workout logs\n" +
                "2) Add new logs\n" +
                "3) Exit program\n" +
                "4) Help");
    }

    public void optionsMessages(String menuOption) {
        switch (menuOption) {
            case EXIT -> {
                System.out.println("EXITING PROGRAM");
            }
            case HELP -> {
                // Help message
                System.out.println("This is a workout log program that helps you track your workout progress. " +
                        "please choose one of the options, to either add to the workout log or view it! :)");
            }
            case VIEW -> {
                // Displaying
                System.out.println("Displaying your workouts...");
            }
            case ADD -> {
                //Writing
                System.out.println("Adding a workout...");
            }
            default -> {
                System.err.println("Invalid input. Please enter a valid input");
            }
        }
    }

    public String getMenuOption(){
        String userOptionChoice = scanner.nextLine();

        switch (userOptionChoice) {
            case VIEW -> this.menuOption = VIEW;
            case ADD -> this.menuOption = ADD;
            case EXIT -> this.menuOption = EXIT;
            case HELP -> this.menuOption = HELP;
            default -> this.menuOption = "null";
        }

        return menuOption;
    }

}
