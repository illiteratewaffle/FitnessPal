package ca.ucalgary.cpsc.cpsc219project;

import java.io.*;

public class Write extends Files {

    /**Writes workout in file
     * Includes error/exception handling.
     * This starts writing content at the end instead of the start. Appends instead of overrides.
     *
     * @param log is the workout information to be written to file.
     */
    public static void writeFile(String log) {
        try {
            File file = openFile();
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
