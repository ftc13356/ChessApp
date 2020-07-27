import java.util.ArrayList;

public class Bishop extends ChessPiece{

    public int[] Location() {
        return getLocation();
    }
    public Bishop(int x, int y, Board board, Player player){
            super(x, y, board, player);
    }

    public static boolean locationOccupied(int x, int y){ //empty waiting for andrew
        return false;
    }
    public boolean isOutOfBoard( int x, int y){
        if(x > 8||y > 8||x < 1||y < 1){
            return true;
        }
        return false;
    }

        public ArrayList<Location> getLegalMoves() {
        int[] x_directions = {1, -1, 1, -1};
        int[] y_directions = {1, 1, -1, -1};
        ArrayList<Location> available_points=new ArrayList<Location>();
        int []bishop_pos = getLocation();
        for (int i = 0; i < 4; i++) {
            int x = 1;
            while (getBoard().isLocationOccupied(bishop_pos[0] + x_directions[i] * x, bishop_pos[1] + y_directions[i] * x)  == null && !getBoard().isOutOfBoard(bishop_pos[0] + x_directions[i] * x, bishop_pos[1] + y_directions[i] * x)){
                ArrayList<Integer> points= new ArrayList<Integer>();
                Location location= new Location();
                location.setLocation(bishop_pos[0] + x_directions[i] * x,bishop_pos[1] + y_directions[i] * x);
                available_points.add(location);
                x++;
            }
        }
        return available_points;

    }
    public void move(int x, int y) {
        setLocation(x,y);
    }

    public boolean check(int x, int y) {
        ArrayList<Location> available_points=new ArrayList<Location>();
        available_points = getLegalMoves();
        Location location = new Location();
        location.setLocation(x,y);
        for (int i = 0; i < available_points.size(); i++) {
            if (available_points.get(i) == location){
                return true;
            }
        }
        return false;
    }
}

