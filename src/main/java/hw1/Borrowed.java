package hw1;

public class Borrowed implements LBState {

    private static Borrowed borrowedInstance = null;
    private static final String name = "Borrowed";

    private Borrowed() {}

    public static synchronized Borrowed getInstance() {
        
        if (borrowedInstance == null) {
            borrowedInstance = new Borrowed(); 
        }

        return borrowedInstance;
    }

    public String toString() {
        return name;
    }

    @Override
    public Borrowed issue(LBState state) throws BadOperationException {
        String methodName = "issue";
        String stateName = state.toString();
        throw new BadOperationException(methodName, stateName);
    }

    @Override
    public GotBack returnIt(LBState state) throws BadOperationException {
        String methodName = "returnIt";
        String stateName = state.toString();
        
        if (!stateName.equals(name)) {
            throw new BadOperationException(methodName, stateName);
        }

        return GotBack.getInstance();
    }

    @Override
    public Borrowed extend(LBState state) throws BadOperationException {
        String methodName = "extend";
        String stateName = state.toString();
        
        if (!stateName.equals(name)) {
            throw new BadOperationException(methodName, stateName);
        }

        return Borrowed.getInstance();
    }

    @Override
    public OnShelf shelf(LBState state) throws BadOperationException {
        String methodName = "shelf";
        String stateName = state.toString();
        throw new BadOperationException(methodName, stateName);
    }
}