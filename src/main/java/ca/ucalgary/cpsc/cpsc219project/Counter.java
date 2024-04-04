package ca.ucalgary.cpsc.cpsc219project;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class counts stats from a workout log, such as the number of exercising days, 
 * total exercises, sets, and reps performed.
 */

public class Counter extends Files {
    private final int LINES;
    private int countDates; //unique dates only
    private int countExercises;
    private int countSets;
    private int countReps;
    private String username;
    private Files files = new Files();
     
    public Counter(int lines){

        this.username = FitnessPalLoginController.getUsername();

        this.LINES = lines;

        ArrayList<WorkoutLog> workouts = getInformation();

        this.countDates = countDates(workouts);
        this.countExercises = countExercises(workouts);
        this.countSets = countSets(workouts);
        this.countReps = countReps(workouts);

    }

    /**
     * Self explanatory
     * Counts how many days you've exercised in total (does not count duplicate dates)
     * Counts how many exercises you've done in total
     * Counts how many sets you've done in total
     * Counts how many reps you've done in total
     */
    public ArrayList<String> countStats() {

        ArrayList<String> calculationMessages = new ArrayList<>();

         // Preparing messages to display the counted statistics
        String daysMessage = "Total Days of Exercising: " + countDates;
        String exercisesMessage = "Total Exercises Done: " + countExercises;
        String setsMessage = "Total Sets Done: " + countSets;
        String repsMessage = "Total Reps Done: " + countReps;

        calculationMessages.add(daysMessage);
        calculationMessages.add(exercisesMessage);
        calculationMessages.add(setsMessage);
        calculationMessages.add(repsMessage);

        System.out.println("Your Statistics:");
        System.out.println(daysMessage);
        System.out.println(exercisesMessage);
        System.out.println(setsMessage);
        System.out.println(repsMessage);

        System.out.println("Great job!");

        return calculationMessages;
    }

    /**
     * Inspects the files, creates new WorkoutLog objects for the counters to count.
     * Includes error/exception handling.
     * @return ArrayList of WorkoutLog objects to be sorted/counted
     */
    public ArrayList<WorkoutLog> getInformation() {

        ArrayList<WorkoutLog> workouts = new ArrayList<WorkoutLog>();

        try {
            File file = files.openFile(username);
            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String fileLine = buffered_reader.readLine();

            for (int i = 0; i < LINES; i++) {
                String[] splitLine = fileLine.split(",");

                String date = splitLine[0];
                String exercise = splitLine[1];
                int sets = Integer.parseInt(splitLine[2]);
                int reps = Integer.parseInt(splitLine[3]);

                WorkoutLog line = new WorkoutLog(date, exercise, sets, reps);

                workouts.add(line);

                fileLine = buffered_reader.readLine();

            }

            buffered_reader.close();
        } catch (FileNotFoundException e){
            System.out.println("File invalid.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("File invalid.");
            throw new RuntimeException(e);
        }

        return workouts;
    }

    /**
     *
     * @param workouts ArrayList of WorkoutLog objects to be sorted/counted
     * @return Counts how many days you've exercised in total (does not count duplicate dates)
     */
    public int countDates(ArrayList<WorkoutLog> workouts) {
        HashSet<String> dates = new HashSet<String>();
        for (int i = 0; i < LINES; i++) {
            dates.add(workouts.get(i).getDATE());
        }

        int numberDates = dates.size();

        return numberDates;
    }

    /**
     *
     * @param workouts ArrayList of WorkoutLog objects to be sorted/counted
     * @return Counts how many exercises you've done in total (counts duplicate)
     */
    public int countExercises(ArrayList<WorkoutLog> workouts) {
        String[] exercises = new String[LINES];
        for (int i = 0; i < LINES; i++) {
            exercises[i] = (workouts.get(i).getEXERCISE());
        }

        int numberExercises = exercises.length;

        return numberExercises;
    }

    /**
     *
     * @param workouts ArrayList of WorkoutLog objects to be sorted/counted
     * @return Counts how many sets you've done in total (addition)
     */
    public int countSets(ArrayList<WorkoutLog> workouts){
        int numberSets = 0;
        for (int i = 0; i < LINES; i++) {
            numberSets += (workouts.get(i).getSETS());
        }

        return numberSets;
    }

    /**
     *
     * @param workouts ArrayList of WorkoutLog objects to be sorted/counted
     * @return Counts how many reps you've done in total (addition)
     */
    public int countReps(ArrayList<WorkoutLog> workouts){
        int numberReps = 0;
        for (int i = 0; i < LINES; i++) {
            numberReps += (workouts.get(i).getREPS());
        }

        return numberReps;
    }

}
