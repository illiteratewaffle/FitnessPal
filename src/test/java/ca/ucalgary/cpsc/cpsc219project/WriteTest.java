import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class WriteTest {

    @Test
    public void testWriteFile() {
        // Defines the file path
        String filePath = "test_file"; // Using a simple file name for testing

        try {
            // Creates an empty file
            File file = new File(filePath);

            // Attempts to create a new file
            boolean fileCreated = file.createNewFile();

            // Provides information about the file creation operation
            if (fileCreated) {
                System.out.println("File created successfully at: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to create the file at: " + file.getAbsolutePath());
            }

            // Checks if the file exists
            assertTrue(file.exists(), "The file does not exist");
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}
