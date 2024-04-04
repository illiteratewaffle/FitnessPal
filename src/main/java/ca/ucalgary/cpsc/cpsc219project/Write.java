package ca.ucalgary.cpsc.cpsc219project;

import java.io.*;

public class Write extends Files {

    protected String username;

    /**Writes workout in file.
     * Includes error/exception handling.
     * This starts writing content at the end instead of the start. Appends instead of overrides.
     *
     * @param log is the workout information to be written to file.
     */
    public void writeFile(String log) {
        Files files = new Files();
        this.username = FitnessPalLoginController.getUsername();

        try {
            File file = files.openFile(username); // does not include .txt extension
            FileWriter file_writer = new FileWriter(file, true);
            BufferedWriter buffered_writer = new BufferedWriter(file_writer);

            if (log != null) {
                buffered_writer.write(log);
            }

            buffered_writer.flush();
        } catch (FileNotFoundException e){
            System.out.println("File invalid.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("File invalid.");
            throw new RuntimeException(e);
        }
    }
}
