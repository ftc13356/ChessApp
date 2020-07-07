import java.util.ArrayList;

public abstract class Knight extends ChessPiece{


    private Location currentLocation;

    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.currentLocation.getLocation(); //takes in current location and gets location
        int[] x_directions = {-2, -1, 1, 2, 2, 1, -1, -2}; //the x of the chessboard ex: x axis = -2, y axis = 1
        int[] y_directions = {1, 2, 2, 1, -1, -2, -2, -1}; // same as above except y axis
        for (int i = 0; i < 8; i++) {
            Location location = new Location();
            location.setLocation(x_y[0] + x_directions[i], x_y[1] + y_directions[i]); // 0 and 0 for both the arrays the first time through the loop
            moves.add(location);
        }

        return moves;
    }
}