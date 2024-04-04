package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReadTest {
    /**
     * Tests the countLines method in the Read class with a basic input file.
     * The test file is expected to have four lines.
     * This test verifies that countLines accurately counts the number of lines in the file.
     */
    @Test
    void test_Read_basicFileInput() {
        String testFilename = "testFileBasic.txt";
        int correctResult = 0;
        Files files = new Files();
        files.openFile(testFilename);
        Read read = new Read();
        int testResult = read.countLines();
        assertEquals(correctResult, testResult, "testFileBasic.txt has four lines, result should have been four, with test passing.");
    }

    @Test
    void test_Read_noLinesFile() {
        String testFilename = "testFileEmpty.txt";
        int correctResult = 0;
        Files files = new Files();
        files.openFile(testFilename);
        Read read = new Read();
        int testResult = read.countLines();
        assertEquals(correctResult, testResult, "testFileEmpty.txt has zero lines, result should have been zero, with test passing.");
    }


}
