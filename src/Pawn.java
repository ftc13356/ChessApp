import java.util.ArrayList;

public class Pawn extends ChessPiece{
    public Pawn(int x, int y, Board board, Player player) {
        super(x, y, board, player);
    }
public boolean firstMovePawn () {
    if(!move(0,0)){
        return true;
        }
    else{
        return false;
    }
}



    @Override
    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation();
        if (firstMovePawn()) {
            int[] x_directions = {0};
            int[] y_directions = {1, 2};

        }
        else{
            int[] x_directions = {0}; //the x of the board
            int[] y_directions = {1}; // same as above except y axis
        }
        int[] x_directions = {}; //the x of the board
        int[] y_directions = {}; // same as above except y axis
        int new_x = x_directions[1] + x_y[0]; // new starting location + the x
        boolean side = getPlayer().isSidewhite();
        int new_y = y_directions[0] + x_y[1]; // new starting location + the y
        if (null==getBoard().isLocationOccupied(new_x, new_y) && !getBoard().isOutOfBoard(new_x, new_y) )
        {
            Location location = new Location();
            location.setLocation(new_x, new_y); // sets new location
            moves.add(location);
        }

        return moves;
    }



}
