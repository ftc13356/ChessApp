import java.util.ArrayList;

abstract class ChessPiece{
    abstract ArrayList<Location> getLegalMoves();
    abstract void move(int x, int y);
}
