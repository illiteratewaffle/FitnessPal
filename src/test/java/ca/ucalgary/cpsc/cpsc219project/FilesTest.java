package ca.ucalgary.cpsc.cpsc219project;

import java.io.File;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    @Test
    void testOpenFile_correctFile() {
        File expected = new File("src/workouts.txt");

        File toCheck = Files.openFile();

        assertEquals(toCheck, expected, "Expected: toCheck == expected");
    }
}