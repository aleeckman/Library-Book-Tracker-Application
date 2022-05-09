package hw1;

public class GotBack implements LBState {

    private static GotBack gotBackInstance = null;
    private static final String name = "GotBack";

    private GotBack() {}

    public static synchronized GotBack getInstance() {
        
        if (gotBackInstance == null) {
            gotBackInstance = new GotBack(); 
        }

        return gotBackInstance;
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

        if (!stateName.equals(name)) {
            throw new BadOperationException(methodName, stateName);
        }

        return OnShelf.getInstance();
    }
}