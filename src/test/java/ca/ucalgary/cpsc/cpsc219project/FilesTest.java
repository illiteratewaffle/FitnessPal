package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    @Test
    void testOpenFile_correctFile() {
        Files files = new Files();
        String testUsername = "workouts"; // Assuming 'workouts' is the username
        File expected = new File("src/" + testUsername + ".txt");

        File actual = files.openFile(testUsername);

        assertEquals(expected.getAbsolutePath(), actual.getAbsolutePath(), "The opened file path should match the expected.");
    }
}
