package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;
import java.io.IOException;

/**
 * Redundant class but want to show that we understand how inheritance and visibility modifiers work.
 */
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
            file = new File(testPathName);
            if (file.createNewFile()) {
                System.out.println(file.getName() + " was created" );

            } else {
                System.out.println("file already exists" );

            }

            this.path = testPathName;

        } catch (IOException e) {
            System.out.println("An error occurred." );
        }

        return file;
    }

}
