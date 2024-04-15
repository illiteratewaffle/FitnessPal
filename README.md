**Progam Name: FitnessPal - Workout Log Tracker**
**Developers : Harry Hu, Muhammad Hasham, Armaan Singh**

Program Description

FitnessPal is a dynamic workout tracker thats allows users to log and track their workouts efficiently. Each user is able
to create and manage their own workout log. They can write any workouts including custom workouts so there is no
limits to what the user can track which provides versatility. These workouts can then be organzied in different ways in 
terms of practicality/personal choice so that the program has better readability and tracking for the user.


Program Instructions:

User enters username. Their workout logs will correspond to their usernames.

Gets user input. User will enter their date, exercise, sets, reps. Includes error checking. Will reprompt for input if initial input is invalid. Adds date, exercise, sets, reps into an array

Gets workout date. Checks if the date is legitimate. Entering "24/02/35" (Feb. 35th 2024) will not work. Will check if numbers are in place of yy/mm/dd. Gets workout name. Any type of input can be accepted. Gets amount of sets. Non negative integers can be accepted. ie. 0, 1, 2, etc. Gets amount of reps. Non negative integers can be accepted. ie. 0, 1, 2, etc.

The logged workout (ie. 01/01/01,"BENCH PRESS",3,12) is stored as an object of class WorkoutLog.

User has the option to choose how the file is read.
- By Recently Added,
The text in the file is sorted by recently added by default. This reads the file and outputs exactly what the file says. Outputs into the terminal, does not modify file.
- By Date, or
This function outputs the workouts in the file in chronological order. Opens file, puts all the lines from that file into an ArrayList Sorts the ArrayList using java.util.Collections Prints the file in chronological order.
- By Exercise (alphabetical order)
This function outputs the workouts in the file in alphabetical order in terms of exercise name. (apparently sorting by alphabetical order by the second word in a string is way harder than sorting by its first word) Must make a HashMap (keys: date, values: exercises), Then make an ArrayList with exercise, Then alphabetically sort the ArrayList, Then with the sorted ArrayList, map each value to it's key.
- Search by specific exercise. If you search "bench", the program will only display "bench" exercises.

NOTE: The author "BuildTools" in GitLab is Harry Hu


Testing outside of JUnit:
Testing the GUI using JUnit can be weird so many things are manually tested.
- Logging in:
    - Logging in as one user;
    - Logging out then logging in again as another user;
    - Leaving username TextField blank (creates "null.txt" and we've used that as a community file.)
    - Usernames that were used for testing were "armaan", "Harry", "workouts"
        - "workouts" was the main file used for testing as it contained the most logs.
- Main Menu:
    - Add Workout button works;
    - View Workouts button works;
    - Logging out works;
    - Help button displays message (works);
- Adding a workout:
    - Date TextField only accepts valid dates in the form of yy/mm/dd
    - Exercise TextField accepts anything
    - Number of Sets TextField accepts non-negative integers
    - Number of Reps TextField accepts non-negative integers
    - In the event of invalid input, an error label with helpful messages will appear.
- Sorting:
    - Recently Added, Alphabetical, Date sorting works and outputs correct results;
    - Sort by specific exercise TextField works
        - If you enter nothing, it will output everything.
        - not gonna lie, this was kind of a last minute feature so its pretty janky. it does not calculate the statistics for exercises.
- And all the back buttons work.


New things since Demo 1:

Has the option to continue running the loop.
Counter, stats on your workouts,
More tests
Made only valid date entry
Introduction, homepage - Ability to repeatedly add logs or choose to view repeadly
Input error checking for everything that takes input. Including wrong formats.
Choosing to srt by no longer case-sensitive

Since Demo 2:

Larger variety of tests
More specific tests
GUI interface
Login page added to the GUI
 - Multiple files set up, one for each user
More specific documentation

Changes since Demo 3 (FOR FINAL SUBMISSION):
- Added option to logout of program, and log back in (essentially changing which file you are writing to while still in the application)
- Added cleaner UI when displaying workouts. Each of "DATE", "EXERCISE", "SETS" and "REPS" are centered in their own column (suggestion by TA)
- Added ability to filter for specific exercies when viewing workout log (mentioned by TA)
- Added more specific documentation + information in readme file