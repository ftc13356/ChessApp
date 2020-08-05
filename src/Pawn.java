import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public static final String whitePath = "src\\White Pieces\\PAWN.png";
    private static final String blackPath = "src\\Black Pieces\\PAWN.png";

    public Pawn(int x, int y, Board board, Player player) {
        super(x, y, board, player);
    }
public boolean firstMovePawn () {
        if (this.getPlayer().isSidewhite()==true && null == getBoard().isLocationOccupied(0,1) ) {

            return true;
        }
        else if (this.getPlayer().isSidewhite()==false && getLocation()[1]==7 && null == getBoard().isLocationOccupied(0,1)){
            return true;
        }
        else {
            return false;
        }


}




    @Override

    public ArrayList<Location> getLegalMoves() {
        ArrayList<Location> moves = new ArrayList<Location>();
        if (firstMovePawn() == true) {
            int[] x_y = this.getLocation();
            int [] x_directions={0};
            int [] y_directions={1,2};
            boolean side = getPlayer().isSidewhite();


            for (int i = 0; i < 2; i++) {
                int new_x = x_directions[0] + x_y[0]; // new starting location + the x
                int new_y = y_directions[i] + x_y[1]; // new starting location + the y

                if (null == getBoard().isLocationOccupied(new_x, new_y) && !getBoard().isOutOfBoard(new_x, new_y)) {
                    Location location = new Location();
                    location.setLocation(new_x, new_y); // sets new location
                    moves.add(location);
                }
                if (getBoard().isLocationOccupied(new_x, new_y) != null && getBoard().isLocationOccupied(new_x, new_y).getPlayer().isSidewhite() != side) {
                    Location location = new Location();
                    location.setLocation(new_x, new_y);
                    moves.add(location);
                }
            }
        }
        else{
            int[] x_y = this.getLocation();
            int [] x_directions={0};
            int [] y_directions={1};
            boolean side = getPlayer().isSidewhite();



                int new_x = x_directions[0] + x_y[0]; // new starting location + the x
                int new_y = y_directions[0] + x_y[1]; // new starting location + the y

                if (null == getBoard().isLocationOccupied(new_x, new_y) && !getBoard().isOutOfBoard(new_x, new_y)) {
                    Location location = new Location();
                    location.setLocation(new_x, new_y); // sets new location
                    moves.add(location);
                }
                if (getBoard().isLocationOccupied(new_x, new_y) != null && getBoard().isLocationOccupied(new_x, new_y).getPlayer().isSidewhite() != side) {
                    Location location = new Location();
                    location.setLocation(new_x, new_y);
                    moves.add(location);
                }
            }



        return moves;
    }

    public String getWhitePath(){
        return whitePath;
    }

    public String getBlackPath(){
        return blackPath;
    }

}




        /*if (firstMovePawn()==true) {
            int[] x_directions = {0};
            int[] y_directions = {1, 2};

        }
        else{
            int[] x_directions = {0}; //the x of the board
            int[] y_directions = {1}; // same as above except y axis
        }*/