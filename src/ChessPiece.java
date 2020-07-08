import java.util.ArrayList;

abstract class ChessPiece{
    public int Location;
    abstract ArrayList<Location> getLegalMoves();
    abstract void move(int x, int y);
    public int isLocationOccupied;
}