package ca.ucalgary.cpsc.cpsc219project;

public class WorkoutLog {
    private final String DATE;
    private final String EXERCISE;
    private final int SETS;
    private final int REPS;

    /**Self-explanatory. Parameters are from Main.createLog()
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

    /**Asks for user input and creates a workout log.
     * Displays what the user as entered.
     *
     * @return an object that contains what the user entered.
     */
    public static WorkoutLog createLog(){
        Input input = new Input();
        String date = input.inputDate();
        String exercise = input.inputExercise();
        int sets = input.inputSets();
        int reps = input.inputReps();
        WorkoutLog workoutLog = new WorkoutLog(date, exercise, sets, reps);

        System.out.println("This is what you've entered: ");
        workoutLog.display();

        return workoutLog;
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
