package ca.ucalgary.cpsc.cpsc219project;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**Lets user see their workouts. Outputs in Main class
 *
 */
public class Read extends Files {

    // class variables
    private String choice;

    private int lines;

    private static String testFileDirectory;


    /**
     *
     * Read constructor
     */
    public Read(String sortBy) {
        this.choice = sortBy;
        this.lines = countLines();
    }

    /**
     * Counts how many lines are in the file
     * Static method because the file is independent
     *
     * @return number of lines in the file
     */
    public int countLines(){
        int lines = 0;
        try {
            File file = openFile();

            if (testFileDirectory != null ){
                file = new File(testFileDirectory);
            }

            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String fileLine = buffered_reader.readLine();
            while (fileLine != null) {
                lines++;
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

        return lines;
    }

    /**User chooses how they want to sort their exercises
     * Includes error checking. Will reprompt for input if initial input is invalid.
     *
     * @return user's choice
     */
    private String chooseSort() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        //String choiceUppercase;
        boolean valid;
        do {
            System.out.println("Choose how you want your workouts to be sorted with the options below");
            System.out.println("Type \"Recent\" to sort by recent");
            System.out.println("Type \"Date\" to sort by chronological order");
            System.out.println("Type \"Exercise\" to sort by alphabetical order");

            choice = scanner.nextLine();
            choice = choice.toUpperCase();
            //System.out.println(choice);

            switch (choice) {
                case "RECENT", "EXERCISE", "DATE":
                    valid = true;
                    break;

                default:
                    System.out.println("Invalid input.");
                    valid = false;
                    break;
            }
        } while (!valid);

        return choice;
    }

    /**
     * User has the option to choose how the file is read.
     * - By Recently Added,
     * - By Date , or
     * - By Exercise (alphabetical order)
     */
    public ArrayList<String> sort(String choice) {
        ArrayList<String> logsList = new ArrayList<>();

        try {
            File file = openFile();
            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            logsList = new ArrayList<>();

            switch (choice) {
                case "RECENT":
                    logsList = sortByRecent(buffered_reader);
                    break;
                case "EXERCISE":
                    logsList = sortByExercise(buffered_reader);
                    break;
                case "DATE":
                    logsList = sortByDate(buffered_reader);
                    break;
            }

            buffered_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File invalid.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("File invalid.");
            throw new RuntimeException(e);
        }

        return logsList;
    }

    /**
     * The text in the file is sorted by recently added by default.
     * This reads the file and outputs exactly what the file says.
     * Outputs into the terminal, does not modify file.
     */
    private ArrayList<String> sortByRecent(BufferedReader buffered_reader) throws IOException {
        ArrayList<String> logsList = new ArrayList<>();
        String fileLine = buffered_reader.readLine();

        while (fileLine != null) {
            logsList.add(fileLine);
            System.out.println(fileLine);
            fileLine = buffered_reader.readLine();
        }

        buffered_reader.close();

        return logsList;
    }

    /**
     * This function outputs the workouts in the file in chronological order.
     * Opens file, puts all the lines from that file into an ArrayList
     * Sorts the ArrayList using java.util.Collections
     * Prints the file in chronological order.
     */
    private ArrayList<String> sortByDate(BufferedReader buffered_reader) throws IOException {
        ArrayList<String> logsList = new ArrayList<>();
        ArrayList<String> sortedByDate = new ArrayList<>();

        String aLine;
        while((aLine = buffered_reader.readLine()) != null){
            sortedByDate.add(aLine);
        }

        Collections.sort(sortedByDate);

        for(String printLine : sortedByDate){
            logsList.add(printLine);
            System.out.println(printLine);
        }

        return logsList;
    }

    /**
     * This function outputs the workouts in the file in alphabetical order in terms of exercise name.
     * (apparently sorting by alphabetical order by the second word in a string is way harder than sorting by its first word)
     *
     * Must make a HashMap (keys: date, values: exercises),
     * Then make an ArrayList with exercise,
     * Then alphabetically sort the ArrayList,
     * Then with the sorted ArrayList, map each value to it's key.
     *
     * Looked up string methods, how to split a string at the first space:
     * https://www.geeksforgeeks.org/split-string-java-examples/
     */
    private ArrayList<String> sortByExercise(BufferedReader buffered_reader) throws IOException {
        ArrayList<String> logsList = new ArrayList<>();
        ArrayList<String> sortedByExercise = new ArrayList<>();

        String aLine;
        while((aLine = buffered_reader.readLine()) != null){
            sortedByExercise.add(aLine);
        }

        HashMap<String, String> unsortedDateAndExercise = new HashMap<>();

        for (String sortLines : sortedByExercise){
            String[] splitAtSpace = sortLines.split(",", 2);
            unsortedDateAndExercise.put(splitAtSpace[1], splitAtSpace[0]);
        }

        ArrayList<String> sortedExercises = new ArrayList<>(unsortedDateAndExercise.keySet());
        Collections.sort(sortedExercises);
        ArrayList<String> sortedDateAndExercise = new ArrayList<>();
        for(String key : sortedExercises){
            sortedDateAndExercise.add(unsortedDateAndExercise.get(key) + "," + key);
        }

        for(int i = 0; i < sortedDateAndExercise.size(); i++){
            System.out.println(sortedDateAndExercise.get(i));
            logsList.add(sortedDateAndExercise.get(i));
        }

        return logsList;
    }

    public String getChoice() {
        return choice;
    }

    protected int getLines() {
        return lines;
    }
}
