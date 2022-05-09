package hw1;
import java.util.ArrayList;

public class LibraryBook implements Subject {                  
    private String name; 
    private LBState state;
    
    private ArrayList<Observer> obsOfBook = new ArrayList<>();

    private LibraryLogger log = LibraryLogger.getInstance();
    
    public LibraryBook(String name) {
        this.name = name;
        this.state = this.getState();
    }
    
    public LBState getState() {
        if (this.state == null) {
            this.state = OnShelf.getInstance();
        }

        return this.state;
    }

    private void transitionHelper(LBState prev, LBState curr) {
        /**
         * A function meant to facilitate the transition from one
         * state to the next, prev -> curr. Logging the transition
         * right before it occurs and notifying any potential observers.
        */

        String lineToWrite = "Leaving State " + prev.toString() + " for State " + curr.toString();
        log.writeLine(lineToWrite);

        this.state = curr;

        this.notifyObservers();
    }
    
    public void returnIt() {
        try {
            transitionHelper(this.state, this.state.returnIt(this.state));
        } catch (BadOperationException e) { log.writeLine(e.getMessage()); }
    }
    
    public void shelf() {
        try {
            transitionHelper(this.state, this.state.shelf(this.state));
        } catch (BadOperationException e) { log.writeLine(e.getMessage()); }
    }
    
    public void extend() {
        try {
            transitionHelper(this.state, this.state.extend(this.state));
        } catch (BadOperationException e) { log.writeLine(e.getMessage()); }
    }
    
    public void issue() {
        try {
            transitionHelper(this.state, this.state.issue(this.state));
        } catch (BadOperationException e) { log.writeLine(e.getMessage());}
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void attach(Observer obs) {
        String lineToWrite;
        String obsName = obs.toString();
        if (!this.obsOfBook.contains(obs)) {
            this.obsOfBook.add(obs);
            lineToWrite = obsName + " is now watching " + this.name;
            
        } else { lineToWrite = obsName + " is already attached to " + this.name; }

        this.log.writeLine(lineToWrite);
    }

    @Override
    public void detach(Observer obs) {
        String lineToWrite;
        String obsName = obs.toString();
        if (this.obsOfBook.remove(obs)) {
            lineToWrite = obsName + " is no longer watching " + this.name;
            this.log.writeLine(lineToWrite);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.obsOfBook) { o.update(this); }
    }

    @Override
    public String getStateName() {
        LBState state = this.getState();
        String stateName = state.toString();
        return stateName;
    }
}