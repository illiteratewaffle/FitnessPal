package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CounterTest {
@Test
    void countDates() {
        Counter counter = new Counter(5);
        ArrayList<WorkoutLog> workoutLogs = counter.getInformation();

        int expected = 5;
        int actual = counter.countDates(workoutLogs);

        assertEquals(expected, actual, "There should be 5 days in the file, test should have passed");
    }

    @Test
    void countExercises() {
        Counter counter = new Counter(5);
        ArrayList<WorkoutLog> workoutLogs = counter.getInformation();
        int expected = 8;
        int toCheck = counter.countExercises(workoutLogs);

        boolean result = (toCheck == expected);
        assertTrue(result, "There should be 8 exercises in the file. Test should have passed");
    }

    @Test
    void countSets() {
        int expected = 26;

        int toCheck = Counter.countSets(Counter.getInformation());

        boolean result = (toCheck == expected);
        assertTrue(result, "There should be 26 sets in the file");

    }

    @Test
    void countReps() {
        int expected = 93;

        int toCheck = Counter.countReps(Counter.getInformation());

        boolean result = (toCheck == expected);
        assertTrue(result, "There should be 93 reps in the file");

    }
}