import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight(int x, int y, Board board) {
        super(x, y, board);
    }

    public static boolean locationOccupied(int x, int y){ //empty waiting for andrew
        return false;
    }
    public static boolean isOutOfBoard(int x, int y){ // empty: waiting for someone to make this function
        return false;
    }

    public ArrayList<Location> getLegalMoves() {

        ArrayList<Location> moves = new ArrayList<Location>();
        int[] x_y = this.getLocation(); //takes in starting point
        int[] x_directions = {-2, -1, 1, 2, 2, 1, -1, -2}; //the x of the chessboard ex: x axis = -2, y axis = 1
        int[] y_directions = {1, 2, 2, 1, -1, -2, -2, -1}; // same as above except y axis

            for (int i = 0; i < 8; i++) {
                int new_x = x_y[0] + x_directions[i]; // new starting location + the x
                int new_y = x_y[1] + y_directions[i]; // new starting location + the y
                    if ( (!isOutOfBoard(new_x, new_y)) && // ! means not
                         (locationOccupied(new_x, new_y)) ); {
                        Location location = new Location();
                        location.setLocation(new_x, new_y); // sets location
                        moves.add(location);
                    }
                }
        return moves;
    }

    @Override
    public void move(int x, int y) {

    }

    public static void main(String[] args){
        Knight k = new Knight (1, 1,null);
        System.out.println(k.getLegalMoves());
    }
}