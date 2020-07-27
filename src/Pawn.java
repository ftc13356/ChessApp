import java.util.ArrayList;

public class Pawn extends ChessPiece{
    public Pawn(int x, int y, Board board, Player player) {
        super(x, y, board, player);
    }
    

    @Override
    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation();
        int[] x_directions = {0}; //the x of the board
        int[] y_directions = {1}; // same as above except y axis
        int new_x = x_directions[0] + x_y[0]; // new starting location + the x
        int new_y = y_directions[0] + x_y[1]; // new starting location + the y
        if (null==getBoard().isLocationOccupied(new_x, new_y) && !getBoard().isOutOfBoard(new_x, new_y) )
        {
            Location location = new Location();
            location.setLocation(new_x, new_y); // sets new location
            moves.add(location);
        }

        return moves;
    }


    public void move(int x, int y){

    }
}
