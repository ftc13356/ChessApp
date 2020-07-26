import java.util.ArrayList;
import java.util.Arrays;

public class BishopTest extends BaseTest {
    public static void main(String[] args) {
        System.out.println("Bishop move test " + (testBishopMove() ? "passed" : "failed"));
    }

    public static boolean testBishopMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = null;

        Bishop bishop1 = new Bishop(4, 4, board1, player1);

        Location l1 = new Location(5, 5);
        Location l2 = new Location(6, 6);
        Location l3 = new Location(7, 7);
        Location l4 = new Location(8, 8);
        Location l5 = new Location(3, 3);
        Location l6 = new Location(2, 2);
        Location l7 = new Location(1, 1);
        Location l8 = new Location(3, 5);
        Location l9 = new Location(2, 6);
        Location l10 = new Location(1, 7);
        Location l11 = new Location(5, 3);
        Location l12 = new Location(6, 2);
        Location l13 = new Location(7, 1);

        ArrayList<Location> expectedLegalMoves = new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, bishopLegalMoves);

    }
}