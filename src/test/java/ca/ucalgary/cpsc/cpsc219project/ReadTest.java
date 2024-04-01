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
        String testFileDirectory = "src/testFileBasic.txt";
        ;
        int correctResult = 4;

        new Read(testFileDirectory);
        int testResult = Read.countLines();

        assertEquals(correctResult, testResult, "testFileBasic.txt has four lines" +
                " result should have been four, with test passing.");

        /**
         * Tests the countLines method in the Read class with an empty file.
         * The test file is expected to have zero lines.
         * This test checks that countLines correctly identifies an empty file.
         */

    }

    @Test
    void test_Read_noLinesFile() {
        String testFileDirectory = "src/testFileEmpty.txt";
        int correctResult = 0;

        new Read(testFileDirectory);
        int testResult = Read.countLines();

        assertEquals(correctResult, testResult, "testFileEmpty.txt has zero lines" +
                " result should have been zero, with test passing.");

    }
}

