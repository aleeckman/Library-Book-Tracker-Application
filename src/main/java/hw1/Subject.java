package hw1;

public interface Subject {
	public void attach(Observer obs);
	public void detach(Observer obs);
	public void notifyObservers();
	public String getStateName();
}
