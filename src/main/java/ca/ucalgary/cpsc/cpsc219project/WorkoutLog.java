package ca.ucalgary.cpsc.cpsc219project;

public class WorkoutLog {
    private final String DATE;
    private final String EXERCISE;
    private final int SETS;
    private final int REPS;

    /**Create WorkoutLog object
     * Object has date, exercise, sets and reps bundled
     *
     * @param date
     * @param exercise
     * @param sets
     * @param reps
     */
    public WorkoutLog(String date, String exercise, int sets, int reps) {
        DATE = date;
        EXERCISE = exercise;
        SETS = sets;
        REPS = reps;
    }

    /**Creates a message to put into the file
     *
     * @return message to put into the file
     */
    public String toWriteFile(){
        return (DATE + ",\"" + EXERCISE + "\"," + SETS + "," + REPS + ",\n");
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
