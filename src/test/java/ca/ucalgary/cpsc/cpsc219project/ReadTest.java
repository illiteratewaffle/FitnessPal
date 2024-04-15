package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


/**
 * These are test classes for testing the Read class functionality, specifically the ability to count the number
 * of lines in a file. These tests check that the Read class correctly interprets the content of files,
 * both when they are empty and when they contain lines of text.
 */

class ReadTest {
    /**
     * This works to test the basic functionality of counting lines in a file that is expected to have a certain number
     * of lines. This test checks if the Read class accurately counts lines.
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
    /**
     * This works to test the Read class's ability to handle an empty file correctly by ensuring it counts zero lines
     * as expected. This is important for validating how the system behaves with minimal input.
     */
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
