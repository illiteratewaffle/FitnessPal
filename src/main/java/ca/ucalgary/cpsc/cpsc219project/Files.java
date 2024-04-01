package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

/**
 * Redundant class but want to show that we understand how inheritance and visibility modifiers work.
 * Static methods because there's only 1 file so we don't need to create Files object.
 * Abstract class: to not allow object type Files to be created
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
