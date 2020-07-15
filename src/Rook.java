import java.util.ArrayList;

public class Rook extends ChessPiece{

    public Rook(int x, int y, Board boardRef) {
        super(x, y, boardRef);
    }
    public int[] Location() {
        return getLocation();
    }
    public static boolean locationOccupied(int x, int y){ //empty waiting for andrew
        return true;
    }
    public static boolean isOutOfBoard(int x, int y){ // empty: waiting for someone to make this function
        return false;
    }
    public ArrayList<Location> getLegalMoves() {
        int[] x_directions = {1, -1, 0, 0};
        int[] y_directions = {0, 0, 1, -1};
        ArrayList<Location> available_points=new ArrayList<Location>();
        int[] rook_pos=getLocation();
        for (int i = 0; i < 4; i++) {
            int x = 1;
            while (locationOccupied(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x)  == false&&!isOutOfBoard(rook_pos[0] + x_directions[i] * x, rook_pos[1] + y_directions[i] * x)) {
                ArrayList<Integer> points= new ArrayList<Integer>();
                Location location= new Location();
                location.setLocation(rook_pos[0] + x_directions[i] * x,rook_pos[1] + y_directions[i] * x);
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
        Location location= new Location();
        location.setLocation(x,y);
        for (int i = 0; i < available_points.size(); i++) {
            if (available_points.get(i)==location){
                return true;
            }
        }
        return false;
    }
}
