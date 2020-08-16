import java.util.ArrayList;

public class Rook extends ChessPiece{

    private static final String whitePath = "src\\White Pieces\\ROOK.png";
    private static final String blackPath = "src\\Black Pieces\\ROOK.png";


    public Rook(int x, int y, Board boardRef, Player player) {
        super(x, y, boardRef, player);
    }
    public int[] Location() {
        return getLocation();
    }
    public ArrayList<Location> getLegalMoves() {
        int[] x_directions = {1, -1, 0, 0};
        int[] y_directions = {0, 0, 1, -1};
        ArrayList<Location> available_points=new ArrayList<Location>();
        int[] rook_pos=getLocation();
        boolean side = getPlayer().isSidewhite();
        for (int i = 0; i < 4; i++) {
            int x = 1;
            while (getBoard().isLocationOccupied(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x)  == null&&!getBoard().isOutOfBoard(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x)) {
                ArrayList<Integer> points= new ArrayList<Integer>();
                Location location= new Location();
                location.setLocation(rook_pos[0] + x_directions[i] * x,rook_pos[1] + y_directions[i] * x);
                    available_points.add(location);
                x++;
            }
            if(getBoard().isLocationOccupied(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x)!=null&&getBoard().isLocationOccupied(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x).getPlayer().isSidewhite()!=side){
                ArrayList<Integer> points= new ArrayList<Integer>();
                Location location= new Location();
                location.setLocation(rook_pos[0] + x_directions[i] * x,rook_pos[1] + y_directions[i] * x);

                    available_points.add(location);
            }
        }
        return available_points;
    }

    public String abbreviation() {
        return "R";
    }
}
