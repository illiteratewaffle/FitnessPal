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
