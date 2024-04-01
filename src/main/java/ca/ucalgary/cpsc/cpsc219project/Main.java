package ca.ucalgary.cpsc.cpsc219project;

public class Main {

    /**Main method program relies on. Homepage for actions
     *
     * for demo 3: use enumerate but this works too.
     *
     * @param args
     */
    //Constants that represent constants in the main menu
    private static final String VIEW = "1";
    private static final String ADD = "2";
    private static final String EXIT = "3";
    private static final String HELP = "4";
    //Controls main loop of the game
    static GameStatus gameOn = GameStatus.ON;

    /**
     * Serves as a entry point for the progrram
     * Provides a loop based menu for the workout log
     */
    public static void main(String[] args) {
        MenuOptions menuOptions = new MenuOptions();

        while(gameOn == GameStatus.ON) {
            //Display welcome message and options
            menuOptions.welcomeMessages();
            //Get the users choice
            String menuOption = menuOptions.getMenuOption();
            //Display message based on chosen option
            menuOptions.optionsMessages(menuOption);

            switch (menuOption) {
                case EXIT -> {
                    gameOn = GameStatus.OFF;
                }
                case HELP -> {
                    System.out.println();
                }
                case VIEW -> {
                    Read.readFile();

                    System.out.println();

                    Counter.displayCount();
                }
                case ADD -> {
                    //Creates new workout log entry
                    WorkoutLog workoutLog = WorkoutLog.createLog();
                    System.out.println();
                    //Writes new workout log into the file
                    Write.writeFile(workoutLog.toWriteFile());
                    System.out.println();
                }
                default -> {
                    //Error message for invalid input
                    System.err.println();
                }
            }
        }
    }
}
