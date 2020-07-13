import java.util.ArrayList;

public abstract class ChessPiece{

    private Location currentLocation;
    private Board board;

    public ChessPiece(int x, int y, Board boardRef) {
        currentLocation = new Location(x,y);
        board = boardRef;
    }

    public void setLocation(int x, int y) {
        currentLocation.setLocation(x,y);
    }

    public int[] getLocation() {
        return currentLocation.getLocation();
    }

    public Board getBoard() {
        return board;
    }

    public abstract ArrayList<Location> getLegalMoves();
    public abstract void move(int x, int y);
}