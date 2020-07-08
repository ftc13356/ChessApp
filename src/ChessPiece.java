import java.util.ArrayList;

abstract class ChessPiece{
    Location currentLocation;
    abstract ArrayList<Location> getLegalMoves();
    abstract void move(int x, int y);
    Board isLocationOccupied;
}