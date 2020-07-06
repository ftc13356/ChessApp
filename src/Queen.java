import java.util.Vector;

public class Queen{
        int[] queen_pos = {4, 1};

        public int[] queen_location() {
            return queen_pos;
        }

        public Vector[] queen_availableMoves() {
            int[] x_directions = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] y_directions = {1, 1, 0, -1, -1, -1, 0, 1};
            Vector[] available_points= new Vector[2];
            for (int i = 0; i < 8; i++) {
                int x = 1;
                while (/*board_isOccupied(queen_pos[0] + x_directions[i] * x, queen_pos[1] + y_directions[i] * x)  == false*/true) {
                    available_points[0].add(queen_pos[0] + x_directions[i] * x);
                    available_points[1].add(queen_pos[1] + y_directions[i] * x);
                }
            }
            return available_points;
        }

        public boolean queen_move(int x, int y) {
            Vector[] available_points;
            available_points = queen_availableMoves();
            for (int i = 0; i < available_points[0].size(); i++) {
                if ((int) available_points[0].get(i) == x && (int) available_points[1].get(i) == y) {
                    queen_pos[0] = (int) x;
                    queen_pos[1] = (int) y;
                    return true;
                }
            }
            return false;
        }

        public boolean queen_check() {
            Vector[] available_points;
            available_points = queen_availableMoves();
            for (int i = 0; i < available_points[0].size(); i++) {
                if (/*board_isOccupiedEnemy(available_points[0][i], available_points[1][i])*/true) {
                    return true;
                }
            }
            return false;
        }
}
