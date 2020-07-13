import java.util.ArrayList;

public class King extends ChessPiece{

    public King(int x, int y, Board board){
        super(x,y,board);
    }

    private boolean isCastled = false;
    public static boolean locationOccupied(int x, int y){ //empty waiting for andrew
        return false;
    }
    public static boolean isOutOfBoard(int x, int y){ // empty: waiting for someone to make this function
        return false;
    }

    public boolean hasKingMoved(){
        boolean hasKingMoved = false;
        //Body
        return hasKingMoved;
    }

    public boolean isCastleLegal(){
        boolean castleLegal = true;
        //Body
        return castleLegal;
    }

    @Override
    public ArrayList<Location> getLegalMoves() {

        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation(); //takes in current location and gets location
        int[] x_directions = {-1, -1, 0, 1, 1, 1, 0, -1}; //the x of the chessboard ex: x axis = -1, y axis = 0
        int[] y_directions = {0, 1, 1, 1, 0, -1, -1, -1}; // same as above except y axis
        for (int i = 0; i < 8; i++) {
            int new_x = x_y[0] + x_directions[i]; // new starting location + the x
            int new_y = x_y[1] + y_directions[i]; // new starting location + the y
            if ( (locationOccupied(new_x, new_y)) && (isOutOfBoard(new_x, new_y)) ); {
                Location location = new Location();
                location.setLocation(new_x, new_y); // sets new location
                moves.add(location);
            }
        }

        return moves;
    }

    @Override
    public void move(int x, int y) {

    }
}
