Program Instructions:

User enters username. Their workout logs will correspond to their usernames.

Gets user input. User will enter their date, exercise, sets, reps. Includes error checking. Will reprompt for input if initial input is invalid. Adds date, exercise, sets, reps into an array

Gets workout date. Checks if the date is legitimate. Entering "24/02/35" (Feb. 35th 2024) will not work. Will check if numbers are in place of yy/mm/dd. Gets workout name. Any type of input can be accepted. Gets amount of sets. Non negative integers can be accepted. ie. 0, 1, 2, etc. Gets amount of reps. Non negative integers can be accepted. ie. 0, 1, 2, etc.

The logged workout (ie. 01/01/01,"BENCH PRESS",3,12) is stored as an object of class WorkoutLog.

File must be in src/workouts.txt

Note: File could be created using .createNewFile() but not using that because we don't trust it. This starts writing content at the end instead of the start. Appends instead of overrides. Includes error/exception handling.

User has the option to choose how the file is read.
- By Recently Added,
The text in the file is sorted by recently added by default. This reads the file and outputs exactly what the file says. Outputs into the terminal, does not modify file.
- By Date, or
This function outputs the workouts in the file in chronological order. Opens file, puts all the lines from that file into an ArrayList Sorts the ArrayList using java.util.Collections Prints the file in chronological order.
- By Exercise (alphabetical order)
This function outputs the workouts in the file in alphabetical order in terms of exercise name. (apparently sorting by alphabetical order by the second word in a string is way harder than sorting by its first word) Must make a HashMap (keys: date, values: exercises), Then make an ArrayList with exercise, Then alphabetically sort the ArrayList, Then with the sorted ArrayList, map each value to it's key.

Has the option to continue running the loop.
New things since Demo 1:

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
