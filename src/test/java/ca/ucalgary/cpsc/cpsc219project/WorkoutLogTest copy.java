package ca.ucalgary.cpsc.cpsc219project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutLogTest {

    @Test
    //Checks if "workoutLog" initializes objects correctly
    void test_WorkoutLog_validEntry(){
        String testDate = "22/22/22";
        String testExercise = "testExercise";
        int testSets = 22;
        int testReps = 22;

        WorkoutLog workOutLog = new WorkoutLog(testDate,testExercise, testSets, testReps );
        String resultDate = workOutLog.getDATE();
        String resultExercise = workOutLog.getEXERCISE();
        int resultSets = workOutLog.getSETS();
        int resultReps = workOutLog.getREPS();


        assertEquals(testDate,resultDate, "Input date was 22/22/22, result should have been true");
        assertEquals(testExercise,resultExercise, "Input exercise was testExercise, result should have been true");
        assertEquals(testSets,resultSets, "Input sets were 22, result should have been true");
        assertEquals(testReps,resultReps, "Input reps were 22, result should have been true");


    }

}