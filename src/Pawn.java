import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public Pawn(int x, int y, Board board, Player player) {
        super(x, y, board, player);
        whitePath = "src\\White Pieces\\PAWN.png";
        blackPath = "src\\Black Pieces\\PAWN.png";
    }
public boolean firstMovePawn () {
        if (getPlayer().isSidewhite()==true && getLocation()[1]==2) {

            return true;
        }
        else if (getPlayer().isSidewhite()==false && getLocation()[1]==7){
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
            int[] x_directions = {0};
            int[] y_directions = {1, 2, -1, -2};
            boolean side = getPlayer().isSidewhite();
            if (getPlayer().isSidewhite()==true) {
                for (int i = 0; i < 2; i++) {
                    int new_x = x_directions[0] + x_y[0]; // new starting location + the x
                    int new_y = y_directions[i] + x_y[1]; // new starting location + the y

                    if (getBoard().isLocationOccupied(new_x, new_y) == null && !getBoard().isOutOfBoard(new_x, new_y)) {
                        Location location = new Location();
                        location.setLocation(new_x, new_y); // sets new location
                        moves.add(location);
                    }
                    else{
                        break;
                    }

                }
            }
            else {
                for (int i = 2; i < 4; i++) {
                    int new_x = x_directions[0] + x_y[0]; // new starting location + the x
                    int new_y = y_directions[i] + x_y[1]; // new starting location + the y

                    if ( getBoard().isLocationOccupied(new_x, new_y) == null && !getBoard().isOutOfBoard(new_x, new_y)) {
                        Location location = new Location();
                        location.setLocation(new_x, new_y);
                        moves.add(location);
                    }
                    else{
                        break;
                    }
                }
            }

        }

        else {
            int[] x_y = this.getLocation();
            int[] x_directions = {0};
            int[] y_directions = {1, -1};
            boolean side = getPlayer().isSidewhite();
                int new_x = x_directions[0] + x_y[0]; // new starting location + the x
                int new_y = y_directions[0] + x_y[1]; // new starting location + the y
            if (getPlayer().isSidewhite()==true) {

                if (null == getBoard().isLocationOccupied(new_x, new_y) && !getBoard().isOutOfBoard(new_x, new_y)) {
                    Location location = new Location();
                    location.setLocation(new_x, new_y); // sets new location
                    moves.add(location);
                }
            }
            else {
                int new_x_black = x_directions[0] + x_y[0]; // new starting location + the x
                int new_y_black = y_directions[1] + x_y[1]; // new starting location + the y

                if (getBoard().isLocationOccupied(new_x_black, new_y_black)== null && !getBoard().isOutOfBoard(new_x_black, new_y_black)) {
                    Location location = new Location();
                    location.setLocation(new_x_black, new_y_black);
                    moves.add(location);
                }
            }
        }



        return moves;
    }

    @Override
    public String abbreviation() {
        return "P";
    }

    public String getWhitePath(){
        return whitePath;
    }

    public String getBlackPath(){
        return blackPath;
    }

}



//test
        