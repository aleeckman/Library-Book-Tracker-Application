package hw1;

public class OnShelf implements LBState {

    private static OnShelf shelfInstance = null;
    private static final String name = "OnShelf";

    private OnShelf() {}

    public static synchronized OnShelf getInstance() {
        
        if (shelfInstance == null) {
            shelfInstance = new OnShelf(); 
        }

        return shelfInstance;
    }

    public String toString() {
        return name;
    }

    @Override
    public Borrowed issue(LBState state) throws BadOperationException {
        String methodName = "issue";
        String stateName = state.toString();
        if (!stateName.equals(name)) {
            throw new BadOperationException(methodName, stateName);
        }

        return Borrowed.getInstance();
    }

    @Override
    public GotBack returnIt(LBState state) throws BadOperationException {
        String methodName = "returnIt";
        String stateName = state.toString();
        throw new BadOperationException(methodName, stateName);
    }

    @Override
    public Borrowed extend(LBState state) throws BadOperationException {
        String methodName = "extend";
        String stateName = state.toString();
        throw new BadOperationException(methodName, stateName);
    }

    @Override
    public OnShelf shelf(LBState state) throws BadOperationException {
        String methodName = "shelf";
        String stateName = state.toString();
        throw new BadOperationException(methodName, stateName);
    }
}