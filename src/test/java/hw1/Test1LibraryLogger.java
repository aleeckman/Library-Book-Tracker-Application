package hw1;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

// If you are using VS code, you should see a run button
//  on the left to run these tests. You can also go to
//  View>Testing to view the tests and run from there.

public class Test1LibraryLogger {
    @Test
    public void shouldMakeSingleInstance()
    {
        LibraryLogger instance = LibraryLogger.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void shouldReturnSameInstance()
    {
        LibraryLogger instance = LibraryLogger.getInstance();
        LibraryLogger instance2 = LibraryLogger.getInstance();
        assertTrue(
            instance == instance2, 
            "It should be a singleton with exactly the same reference"
        );
    }

    @Test
    public void shouldBeAbleToWriteLine() {
        LibraryLogger logger = LibraryLogger.getInstance();
        logger.clearWriteLog();
        logger.writeLine("test line");
        assertArrayEquals(
            new String[] {
                "test line"
            }, 
            LibraryLogger.getInstance().getWrittenLines()
        );
        logger.writeLine("new test line");
        assertArrayEquals(
            new String[] {
                "test line", 
                "new test line"
            }, 
            LibraryLogger.getInstance().getWrittenLines()
        );
    }

    @Test
    public void shouldBeAbleToResetLines() {
        LibraryLogger logger = LibraryLogger.getInstance();
        logger.clearWriteLog();
        logger.writeLine("test line");
        logger.clearWriteLog();
        assertEquals(
            0, 
            LibraryLogger.getInstance().getWrittenLines().length
        );
    }

    @Test
    public void testExpensiveComputeSetup() {
        var logger = LibraryLogger.getInstance();
        assertEquals(
            1,
            ExpensiveComputeToy.getNumberOfTimesExpensiveSetupCalled()
        );
    }
}
