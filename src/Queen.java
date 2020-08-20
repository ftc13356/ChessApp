import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen(int x, int y, Board board, Player player) {
        super(x, y, board, player);
        whitePath = "src\\White Pieces\\QUEEN.png";
        blackPath = "src\\Black Pieces\\QUEEN.png";
    }

    public ArrayList<Location> getLegalMoves() {
        int[] x_directions = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] y_directions = {1, 1, 0, -1, -1, -1, 0, 1};
        ArrayList<Location> available_points = new ArrayList<Location>();
        int[] queen_pos = getLocation();
        boolean sideColor = getPlayer().isSidewhite();

        for (int i = 0; i < 8; i++) {
            int x = 1;
            while (getBoard().isLocationOccupied(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x) == null && !getBoard().isOutOfBoard(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x)) {
                ArrayList<Integer> points = new ArrayList<Integer>();
                Location location = new Location();
                location.setLocation(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x);
                available_points.add(location);
                x++;
            }
            if (getBoard().isLocationOccupied(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x) != null && getBoard().isLocationOccupied(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x).getPlayer().isSidewhite() != sideColor){
                ArrayList<Integer> points= new ArrayList<Integer>();
                Location location= new Location();
                location.setLocation(queen_pos[0] + x_directions[i] * x,queen_pos[1] + y_directions[i] * x);
                available_points.add(location);
            }
        }
        return available_points;

    }

    @Override
    public String abbreviation() {
        return "Q";
    }

}
