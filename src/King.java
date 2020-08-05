import java.util.ArrayList;

public class King extends ChessPiece{

    public static final String whitePath = "src\\White Pieces\\KING.png";
    private static final String blackPath = "src\\Black Pieces\\KING.png";

    public King(int x, int y, Board board, Player player){
        super(x,y,board, player);
    }

    private boolean isCastled = false;

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
        boolean side = getPlayer().isSidewhite();
        for (int i = 0; i < 8; i++) {
            int new_x = x_y[0] + x_directions[i]; // new starting location + the x
            int new_y = x_y[1] + y_directions[i]; // new starting location + the y
            while ( (getBoard().isLocationOccupied(new_x, new_y)==null) && (!getBoard().isOutOfBoard(new_x, new_y)) ){
                Location location = new Location();
                location.setLocation(new_x, new_y); // sets new location
                moves.add(location);
            }
            if(getBoard().isLocationOccupied(new_x, new_y)!=null&&getBoard().isLocationOccupied(new_x, new_y).getPlayer().isSidewhite()!=side){
                Location location= new Location();
                location.setLocation(new_x, new_y);
                moves.add(location);
            }
        }

        return moves;
    }

}
