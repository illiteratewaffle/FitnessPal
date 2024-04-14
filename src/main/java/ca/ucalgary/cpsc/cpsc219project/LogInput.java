package ca.ucalgary.cpsc.cpsc219project;


// Renamed from "Input" to "LogInput" to make inputs for Menu Options and Workout Logs distinct.
public class LogInput {
    //Works to store workout info and year etc
    private String date;
    private String exercise;
    private int reps;
    private int sets;
    private int currentYear;


    /**Constructor for Input
     *Initializes variable with default values
     */
    public LogInput() {
        this.date = null;
        this.exercise = null;
        this.sets = 0;
        this.reps = 0;
        this.currentYear = 24;
    }

    /**Gets user input for date.
     * Includes error checking. Will reprompt for input if initial input is invalid.
     *Expected format is yy/mm/dd 
     * @return date from user input
     */
    public boolean inputDate(String logDate) {
        int i;
        char check = 'b';
        boolean validFormat = true;
        boolean validDate = false;
        String inputDate = logDate;



        validFormat = true;
        validDate = false;

        System.out.println("Enter workout date (yy/mm/dd, ie. \"24/02/24\"): ");
        for(i = 0; i < inputDate.length(); i++){
            check = inputDate.charAt(i);
            if ((!Character.isDigit(check)) && !((i == 2) || (i == 5))) {
                System.err.println("Invalid input. Input must be in the form yy/mm/dd.");
                validFormat = false;
                break;
            } else if (inputDate.length() != 8) {
                System.err.println("Invalid input. Input must be in the form yy/mm/dd.");
                validFormat = false;
                break;
            }
        }
        //Validates year, month and day
        if (validFormat) {
            String inputYear = String.valueOf(inputDate.charAt(0)) + String.valueOf(inputDate.charAt(1));
            int valueYear = Integer.valueOf(inputYear);

            String inputMonth = String.valueOf(inputDate.charAt(3)) + String.valueOf(inputDate.charAt(4));
            int valueMonth = Integer.valueOf(inputMonth);

            String inputDay = String.valueOf(inputDate.charAt(6)) + String.valueOf(inputDate.charAt(7));
            int valueDay = Integer.valueOf(inputDay);

            if ((valueYear < 0) || (valueYear > currentYear) || (valueMonth > 12) || (valueMonth <= 0) || (valueDay <= 0) || (valueDay > 31)) {
                System.err.println("Invalid date! Please enter a valid date");
            } else {
                validDate = true;
            }
        }

        return (validFormat && validDate);
    }

    /**Gets user input for exercise name.
     * Includes error checking. Will reprompt for input if initial input is invalid.
     *
     * @return exercise from user input
     */
    public boolean inputExercise(String logExercise){
        System.out.println("Enter workout name (ie. \"Bench Press\", \"Deadlift\", \"Squat\", etc.): ");

        return !logExercise.isEmpty();
    }

    /**Gets user input for sets
     * Includes error checking. Will reprompt for input if initial input is invalid.
     *
     * @return sets
     */
    public boolean inputSets(String logSets) {
        String stringSets = logSets;
        char check = 'b';
        boolean validSets = true;

        System.out.println("Enter amount of sets (ie. 3, 4, 5, etc.): ");
        for (int i = 0; i < stringSets.length(); i++) {
            check = stringSets.charAt(i);
            if (!Character.isDigit(check)) {
                System.out.println("Invalid input. Input must be a non-negative integer.");
                validSets = false;
                break;
            }
        }

        return validSets;
    }

    /**Gets user input for reps
     * Includes error checking. Will reprompt for input if initial input is invalid.
     *
     * @return reps
     */
    public boolean inputReps(String logReps){
        String stringReps = logReps;
        char check = 'b';
        boolean validReps = true;

        System.out.println("Enter amount of reps (ie. 6, 8, 12, etc.): ");
        for(int i = 0; i < stringReps.length(); i++){
            check = stringReps.charAt(i);
            if (!Character.isDigit(check)) {
                System.out.println("Invalid input. Input must be a non-negative integer.");
                validReps = false;
                break;
            }
        }

        return validReps;
    }

}
