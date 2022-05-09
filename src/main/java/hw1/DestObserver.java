package hw1;
import java.util.HashMap;

public class DestObserver implements Observer {
	private String name;
	private HashMap<Subject, String> subjectToNewStateName = null;

	private LibraryLogger log = LibraryLogger.getInstance();
	
	public DestObserver(String n) {
		this.name = n;
		this.subjectToNewStateName = new HashMap<Subject, String>();
	}

	@Override
	public void update(Subject o) {
		this.subjectToNewStateName.put(o, o.getStateName());
        
        String currStateName = o.getStateName();
		String lineToWrite = this.name + " OBSERVED " + o.toString() + " REACHING STATE: " + currStateName;
		
        this.log.writeLine(lineToWrite);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
