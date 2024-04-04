package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    @Test
    void testOpenFile_correctFile() {
        Files files = new Files();
        //Defines test username
        String testUsername = "workouts"; // Assuming 'workouts' is the username
        //Defines expected file path
        File expected = new File("src/" + testUsername + ".txt");
        //calls openFile with test username and stores result
        File actual = files.openFile(testUsername);

        assertEquals(expected.getAbsolutePath(), actual.getAbsolutePath(), "The opened file path should match the expected.");
    }
}
