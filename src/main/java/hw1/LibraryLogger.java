package hw1;
import java.util.ArrayList;

public class LibraryLogger {
    private static LibraryLogger libLog = null;
    private ArrayList<String> lines = new ArrayList<>();

    private LibraryLogger() {}

    public void writeLine(String line) {
        System.out.println("LibraryLogger: " + line + "\n");
        this.lines.add(line);
    }

    public String[] getWrittenLines() {
        int sizeOfLines = this.lines.size();
        String linesToRet[] = this.lines.toArray(new String[sizeOfLines]);
        return linesToRet;
    }

    public void clearWriteLog() {
        this.lines.clear();
    }
    
    public static synchronized LibraryLogger getInstance() {
        if (libLog == null) { 
            libLog = new LibraryLogger();
            ExpensiveComputeToy.performExpensiveLogSetup();
        }
        return libLog;
    }
}
