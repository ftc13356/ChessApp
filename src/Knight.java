import java.util.ArrayList;

public class Knight extends ChessPiece{

    public static final String whitePath = "src\\White Pieces\\KNIGHT.png";
    private static final String blackPath = "src\\Black Pieces\\KNIGHT.png";

    public Knight(int x, int y, Board board, Player player) {
        super(x, y, board, player);
    }


    public ArrayList<Location> getLegalMoves() {

        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation(); //takes in starting point
        int[] x_directions = {-2, -1, 1, 2, 2, 1, -1, -2}; //the x of the chessboard ex: x axis = -2, y axis = 1
        int[] y_directions = {1, 2, 2, 1, -1, -2, -2, -1}; // same as above except y axis

            for (int i = 0; i < 8; i++) {
                int new_x = x_y[0] + x_directions[i]; // new starting location + the x
                int new_y = x_y[1] + y_directions[i]; // new starting location + the y
                    if ( (!getBoard().isOutOfBoard(new_x, new_y)) && // ! means not
                         (getBoard().isLocationOccupied(new_x, new_y) == null) &&
                            (getPlayer().isSidewhite()) ) {
                        Location location = new Location();
                        location.setLocation(new_x, new_y); // sets location
                        moves.add(location);
                    }
                }
        return moves;
    }

    public static void main(String[] args){
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Knight k = new Knight (1, 1, board1, player1);
        System.out.println(k.getLegalMoves());
    }
}