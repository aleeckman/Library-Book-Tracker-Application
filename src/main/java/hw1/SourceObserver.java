package hw1;
import java.util.HashMap;

public class SourceObserver implements Observer {
	private String name;
	private HashMap<Subject, String> subjectToPastStateName = null;

	private LibraryLogger log = LibraryLogger.getInstance();
	
	public SourceObserver(String n) {
		this.name = n;
		this.subjectToPastStateName = new HashMap<Subject, String>();
	}

	@Override
	public void update(Subject o) {
		String currStateName = ((this.subjectToPastStateName.containsKey(o)) 
			? this.subjectToPastStateName.get(o) 
			: "UNOBSERVED");

		this.subjectToPastStateName.put(o, o.getStateName());
		
		String lineToWrite = this.name + " OBSERVED " + o.toString() + " LEAVING STATE: " + currStateName;
		this.log.writeLine(lineToWrite);

	}

	@Override
	public String toString() {
		return name;
	}
}
