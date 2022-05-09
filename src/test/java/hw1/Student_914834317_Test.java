package hw1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Student_914834317_Test {
    
    @BeforeEach
    public void resetLog() {
        LibraryLogger.getInstance().clearWriteLog();
    }

    @Test
    public void TestStateTransitionTests() {
        /**
         * A test designed to check that exceptions are thrown properly as
		 * instances of the LibraryBook class transition around the state loop. 
         */

        LibraryBook book1 = new LibraryBook("BOOK_1"); // Goes until OnShelf and then checks invalid methods in that state
        LibraryBook book2 = new LibraryBook("BOOK_2"); // Goes until GotBack and then checks invalid methods in that state
        LibraryBook book3 = new LibraryBook("BOOK_3"); // Goes until first extension off of Borrowed and then checks invalid methods in that state
        LibraryBook book4 = new LibraryBook("BOOK_4"); // Goes until Borrowed and then checks invalid methods in that state
        LibraryBook book5 = new LibraryBook("BOOK_5"); // Stays OnShelf and checks invalid methods in that state

        book1.issue();
        book2.issue();
        book3.issue();
        book4.issue();
        book5.extend();     // First of Exceptions for Book 5.

        book1.extend();
        book2.extend();
        book3.extend();
        book4.issue();      // First of Exceptions for Book 4.
        book5.returnIt();   // Second of Exceptions for Book 5.

        book1.returnIt();
        book2.returnIt();
        book3.issue();      // First of Exceptions for Book 3.
        book4.shelf();      // Second and last of Exceptions for Book 4.
        book5.shelf();      // Third and last of Exceptions for Book 5.

        book1.shelf();
        book2.issue();      // First of Exceptions for Book 2.
        book3.shelf();      // Second and last of Exceptions for Book 3.

        book1.shelf();      // First of Exceptions for Book 1.
        book2.extend();     // Second of Exceptions for Book 2.
        
        book1.returnIt();   // Second of Exceptions for Book 1.
        book2.returnIt();   // Third and last of Exceptions for Book 2.

        book1.extend();     // Third and last of Exceptions for Book 1.

        assertArrayEquals(
			new String [] {
                "Leaving State OnShelf for State Borrowed",
                "Leaving State OnShelf for State Borrowed", 
                "Leaving State OnShelf for State Borrowed", 
                "Leaving State OnShelf for State Borrowed", 
                "BadOperationException - Can't use extend in OnShelf state", 

                "Leaving State Borrowed for State Borrowed",
                "Leaving State Borrowed for State Borrowed", 
                "Leaving State Borrowed for State Borrowed", 
                "BadOperationException - Can't use issue in Borrowed state", 
                "BadOperationException - Can't use returnIt in OnShelf state", 

                "Leaving State Borrowed for State GotBack",
                "Leaving State Borrowed for State GotBack", 
                "BadOperationException - Can't use issue in Borrowed state", 
                "BadOperationException - Can't use shelf in Borrowed state", 
                "BadOperationException - Can't use shelf in OnShelf state", 

                "Leaving State GotBack for State OnShelf",
                "BadOperationException - Can't use issue in GotBack state", 
                "BadOperationException - Can't use shelf in Borrowed state", 

                "BadOperationException - Can't use shelf in OnShelf state",
                "BadOperationException - Can't use extend in GotBack state", 

                "BadOperationException - Can't use returnIt in OnShelf state",
                "BadOperationException - Can't use returnIt in GotBack state", 

                "BadOperationException - Can't use extend in OnShelf state"
            }, 
            LibraryLogger.getInstance().getWrittenLines());

    }
}
