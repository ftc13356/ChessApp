import com.sun.jdi.Location;

import java.util.ArrayList;

public abstract class Knight extends ChessPiece{

    private ChessApp currentLocation;

    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.currentLocation.
        int[] x_directions = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] y_directions = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < 8; i++) {
            Location location = new Location();
            moves.add(x_directions[i] + y_directions[i]);
        }

        return Knight.Location.setLocation;
    }
}