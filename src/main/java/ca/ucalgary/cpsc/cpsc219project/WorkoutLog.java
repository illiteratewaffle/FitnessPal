package ca.ucalgary.cpsc.cpsc219project;

public class WorkoutLog {
    private final String DATE;
    private final String EXERCISE;
    private final int SETS;
    private final int REPS;

    /**Asks for user input and creates a workout log.
     * Displays what the user as entered.
     */
    public WorkoutLog(){
        LogInput logInput = new LogInput();
        this.DATE = logInput.inputDate();
        this.EXERCISE = logInput.inputExercise();
        this.SETS = logInput.inputSets();
        this.REPS = logInput.inputReps();

        System.out.println("This is what you've entered: ");
        display();
    };

    /**For use in Counter.java (overloading)
     *
     * @param date
     * @param exercise
     * @param sets
     * @param reps
     */
    public WorkoutLog(String date, String exercise, int sets, int reps) {
        this.DATE = date;
        this.EXERCISE = exercise;
        this.SETS = sets;
        this.REPS = reps;
    }

    /**Creates a message to put into the file
     *
     * @return message to put into the file
     */
    public String toWriteFile(){
        return (DATE + ",\"" + EXERCISE + "\"," + SETS + "," + REPS + ",\n");
    }

    /**Repeats back what the user has entered.
     *
     */
    public void display() {
        String dateMessage = "Date: " + this.DATE;
        String exerciseMessage = "Exercise: " + this.EXERCISE;
        String setsMessage = "Sets: " + this.SETS;
        String repsMessage = "Reps: " + this.REPS;

        System.out.println(dateMessage);
        System.out.println(exerciseMessage);
        System.out.println(setsMessage);
        System.out.println(repsMessage);
    }

    public String getDATE() {
        return DATE;
    }

    public String getEXERCISE() {
        return EXERCISE;
    }

    public int getSETS() {
        return SETS;
    }

    public int getREPS() {
        return REPS;
    }

}
