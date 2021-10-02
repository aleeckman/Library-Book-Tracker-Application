package hw1;
import java.util.HashMap;

// TODO HW1 P3

public class SourceObserver implements Observer {
	private String name;
	private HashMap<Subject, String> subjectToPastStateName;
	
	public SourceObserver(String n) {
		// TODO?
	}

	@Override
	public void update(Subject o) {
		// TODO?
	}

	@Override
	public String toString() {
		return name;
	}
}
