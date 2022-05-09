package hw1;

interface LBState {
    public Borrowed issue (LBState state) throws BadOperationException;
    public GotBack returnIt(LBState state) throws BadOperationException;
    public Borrowed extend(LBState state) throws BadOperationException;
    public OnShelf shelf(LBState state) throws BadOperationException;
}