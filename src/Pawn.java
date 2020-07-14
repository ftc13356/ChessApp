import java.util.ArrayList;

public class Pawn extends ChessPiece{
    public Pawn(int x, int y, Board board) {
        super(x, y, board);
    }

    public static boolean locationOccupied(int x, int y){ //empty waiting for andrew
        return false;
    }
    public static boolean isOutOfBoard(int x, int y){ // empty: waiting for someone to make this function
        return false;
    }

    @Override
    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation();
        int[] x_directions = {1}; //the x of the board
        int[] y_directions = {0}; // same as above except y axis
        int new_x = x_directions[0]; // new starting location + the x
        int new_y = y_directions[0]; // new starting location + the y
        if ((locationOccupied(new_x, new_y)) && (isOutOfBoard(new_x, new_y))) ;
        {
            Location location = new Location();
            location.setLocation(new_x, new_y); // sets new location
            moves.add(location);
        }

        return moves;
    }


    @Override
    public void move(int x, int y) {

    }
}
