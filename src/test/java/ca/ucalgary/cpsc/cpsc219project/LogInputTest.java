package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInputTest {

    @Test
    void testInputDate_correct() {
        LogInput testLogInput = new LogInput();
        String input = "12/12/12";
        // Call the method with the string input
        assertTrue(testLogInput.inputDate(input), "The input date should be valid.");
    }

    @Test
    void testInputDate_incorrect() {
        LogInput testLogInput = new LogInput();
        String input = "121212";
        // Call the method with the string input
        assertFalse(testLogInput.inputDate(input), "The input date should be invalid.");
    }

    @Test
    void testInputDate_nothing() {
        LogInput testLogInput = new LogInput();
        String expected = "12/12/12";

        System.out.println("press enter and you will be reprompted.");
        System.out.println("type \"12/12/12\" and itll be correct.");
        assertTrue(testLogInput.inputDate(expected), "should be true (if you enter 121212)");
    }

    @Test
    void testInputSets_correct() {
        LogInput testLogInput = new LogInput();
        String input = "3";
        // Call the method with the string input
        assertTrue(testLogInput.inputSets(input), "The input sets should be valid.");
    }

    @Test
    void testInputReps_correct() {
        LogInput testLogInput = new LogInput();
        String input = "12";
        // Call the method with the string input
        assertTrue(testLogInput.inputReps(input), "The input reps should be valid.");
    }
}