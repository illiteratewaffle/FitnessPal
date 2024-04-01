package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

/* Redundant class but want to show that we understand how inheritance and
visibility modifiers work.
*/
public abstract class Files {

    protected static final String PATH = "src/workouts.txt";

    /**Opens src/workouts.txt
     *
     * @return File
     */
    public static File openFile() {
        File file = new File(PATH);

        return file;
    }

}
