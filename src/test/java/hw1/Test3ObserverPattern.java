package hw1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test3ObserverPattern {
    @BeforeEach
    public void resetLog() {
        LibraryLogger.getInstance().clearWriteLog();
    }

    @Test
    public void LibraryObserverE2E() {
        /**
         * A test designed to show you sample output for Problem 3.
		 * It is not guaranteed to be the highest quality/comprehensive
         */
        
        
		LibraryBook book1 = new LibraryBook("Design Patterns");
		LibraryBook book2 = new LibraryBook("Deep Learning");
		
		SourceObserver srcObserver = new SourceObserver("SrcObserverFoo");
		DestObserver destObserver = new DestObserver("DestObserverBar");
		
		book1.detach(destObserver);
		book1.attach(srcObserver);
		book1.attach(destObserver);
		book2.attach(destObserver);
				
		book1.issue();
		book1.extend();
		book1.detach(srcObserver);
		book1.extend();
		book1.returnIt();
		book1.shelf();
		
		book2.shelf();
		book2.issue();
		book2.attach(srcObserver);
		book2.returnIt();
		book2.detach(destObserver);
		book2.shelf();
		book2.issue();

		assertArrayEquals(
			new String [] {
                "SrcObserverFoo is now watching Design Patterns",
                "DestObserverBar is now watching Design Patterns",
                "DestObserverBar is now watching Deep Learning",
                "Leaving State OnShelf for State Borrowed",
                "SrcObserverFoo OBSERVED Design Patterns LEAVING STATE: UNOBSERVED",
                "DestObserverBar OBSERVED Design Patterns REACHING STATE: Borrowed",
                "Leaving State Borrowed for State Borrowed",
                "SrcObserverFoo OBSERVED Design Patterns LEAVING STATE: Borrowed",
                "DestObserverBar OBSERVED Design Patterns REACHING STATE: Borrowed",
                "SrcObserverFoo is no longer watching Design Patterns",
                "Leaving State Borrowed for State Borrowed",
                "DestObserverBar OBSERVED Design Patterns REACHING STATE: Borrowed",
                "Leaving State Borrowed for State GotBack",
                "DestObserverBar OBSERVED Design Patterns REACHING STATE: GotBack",
                "Leaving State GotBack for State OnShelf",
                "DestObserverBar OBSERVED Design Patterns REACHING STATE: OnShelf",
                "BadOperationException - Can't use shelf in OnShelf state",
                "Leaving State OnShelf for State Borrowed",
                "DestObserverBar OBSERVED Deep Learning REACHING STATE: Borrowed",
                "SrcObserverFoo is now watching Deep Learning",
                "Leaving State Borrowed for State GotBack",
                "DestObserverBar OBSERVED Deep Learning REACHING STATE: GotBack",
                "SrcObserverFoo OBSERVED Deep Learning LEAVING STATE: UNOBSERVED",
                "DestObserverBar is no longer watching Deep Learning",
                "Leaving State GotBack for State OnShelf",
                "SrcObserverFoo OBSERVED Deep Learning LEAVING STATE: GotBack",
                "Leaving State OnShelf for State Borrowed",
                "SrcObserverFoo OBSERVED Deep Learning LEAVING STATE: OnShelf"
			}, 
			LibraryLogger.getInstance().getWrittenLines()
		);
	}
}
