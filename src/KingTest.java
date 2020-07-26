import java.util.ArrayList;
import java.util.Arrays;

public class KingTest extends BaseTest{
    public static void main(String[] args) {
        System.out.println("King move test " + (testKingMove() ? "passed" : "failed"));
    }
    public static boolean testKingMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = null;

        King king1 = new King(4, 4, board1, player1);

        Location l1 = new Location(4, 5);
        Location l2 = new Location(5, 5);
        Location l3 = new Location(5, 4);
        Location l4 = new Location(5, 3);
        Location l5 = new Location(4, 3);
        Location l6 = new Location(3, 3);
        Location l7 = new Location(3, 4);
        Location l8 = new Location(3, 5);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8));
        ArrayList<Location>KingLegalMoves = king1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, KingLegalMoves);

    }
}
