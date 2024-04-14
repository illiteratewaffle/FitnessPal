package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Test cases for Files class

class FilesTest {

    @Test
    void testOpenFile_correctFile() {
        Files files = new Files();
        //Defines test username
        String testUsername = "workouts";
        File expected = new File("src/" + testUsername + ".txt");
        //calls openFile with test username and stores result

        File actual = files.openFile(testUsername);
        assertEquals(expected.getAbsolutePath(), actual.getAbsolutePath(), "The opened file path should match the expected.");
    }
}
