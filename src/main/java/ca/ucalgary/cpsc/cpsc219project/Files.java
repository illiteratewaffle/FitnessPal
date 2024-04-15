package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;
import java.io.IOException;

/**
 * Redundant class but want to show that we understand how inheritance and visibility modifiers work.
 * This class provides basic file handling operations.It works to demonstrate
 * understanding of inheritance and visibility modifiers in a simple file management context.
 **/
public class Files {

    protected String path;

    public Files() {
        this.path = null;
    }

    /**Opens src/workouts.txt
     *
     * @return File
     */
    public File openFile(String username) {
        //this.username = username;

        String testPathName = "src/" +username + ".txt";
        File file = null;

        try {
            //Attempts to create a new file
            file = new File(testPathName);
            //creates a new file if a file already exists this is ignored
            if (file.createNewFile()) {
                System.out.println(file.getName() + " was created" );

            } else {
                System.out.println("file already exists" );

            }
            //Updates pathh variable with the current file path
            this.path = testPathName;

        } catch (IOException e) {
            System.out.println("An error occurred." );
        }

        return file;
    }

}
