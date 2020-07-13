import java.util.ArrayList;

public class Queen extends ChessPiece{
        int[] queen_pos = {4, 1};

        public int[] Location() {
            return queen_pos;
        }
        public Queen(int x, int y, Board board){
            super(x,y,board);
        }

        public ArrayList<Location> getLegalMoves() {
            int[] x_directions = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] y_directions = {1, 1, 0, -1, -1, -1, 0, 1};
            ArrayList<Location> available_points=new ArrayList<Location>();
            for (int i = 0; i < 8; i++) {
                int x = 1;
                while (/*board_isOccupied(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x)  == false&&queen_pos[0] + x_directions[i] * x<=8&&queen_pos[1] + y_directions[i]<=8&&queen_pos[0] + x_directions[i] * x>0&&queen_pos[1] + y_directions[i]>0 x*/true) {
                    ArrayList<Integer> points= new ArrayList<Integer>();
                    Location location= new Location();
                    location.setLocation(queen_pos[0] + x_directions[i] * x,queen_pos[1] + y_directions[i] * x);
                    available_points.add(location);
                    x++;
                }
            }
            return available_points;
        }

        public void move(int x, int y) {
            queen_pos[0]=x;
            queen_pos[1]=y;
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
