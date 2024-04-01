package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInputTest {

    /*
    For these tests, I cant seem to find any articles online on
    how to make an input.

    These tests don't work but they are ideas.
    These have been tested manually by running the program, but I can't find a way to automatically do them.

    Tried:
    - Typing into terminal
    - System.in

    Out of ideas.
     */

    @Test
    void testInputDate_correct() {
        LogInput testLogInput = new LogInput();
        String expected = "12/12/12";

        System.out.println("type \"12/12/12\"");
        //System.in.("12/12/12");
        String toCheck = testLogInput.inputDate();

        boolean result = (expected.equals(toCheck));
        assertTrue(result, "should be true (if you enter 12/12/12)");
    }

    @Test
    void testInputDate_incorrect() {
        LogInput testLogInput = new LogInput();
        String expected = "12/12/12";

        System.out.println("type \"121212\" and you will be reprompted.");
        System.out.println("type \"12/12/12\" and itll be correct.");
        String toCheck = testLogInput.inputDate();

        boolean result = (expected.equals(toCheck));
        assertTrue(result, "should be true (if you enter 121212)");
    }

    @Test
    void testInputDate_nothing() {
        LogInput testLogInput = new LogInput();
        String expected = "12/12/12";

        System.out.println("press enter and you will be reprompted.");
        System.out.println("type \"12/12/12\" and itll be correct.");
        String toCheck = testLogInput.inputDate();

        boolean result = (expected.equals(toCheck));
        assertTrue(result, "should be true (if you enter 121212)");
    }

    @Test
    void testInputSets_correct() {
        LogInput testLogInput = new LogInput();
        int expected = 3;

        System.out.println("type \"3\"");
        int toCheck = testLogInput.inputSets();

        boolean result = (expected == toCheck);
        assertTrue(result, "should be true (if you enter 3)");
    }


    @Test
    void testInputReps_correct() {
        LogInput testLogInput = new LogInput();
        int expected = 12;

        System.out.println("type \"12\"");
        int toCheck = testLogInput.inputReps();

        boolean result = (expected == toCheck);
        assertTrue(result, "should be true (if you enter 12)");
    }
}