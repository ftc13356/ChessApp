import java.util.ArrayList;
import java.util.Arrays;

public class KnightTest extends BaseTest {
    public static void main(String[] args) {
        System.out.println("Knight move test " + (testKnightMove() ? "passed" : "failed"));
        System.out.println("Knight move inside board has not been programmed yet");

    }

    public static boolean testKnightMove(){
        Player player1 = null;
        Player player2 = null;
        Board board1 = null;

        Knight knight1 = new Knight(4,4, board1, player1);

        Location l1 = new Location(6, 3);
        Location l2 = new Location(6, 5);
        Location l3 = new Location(5, 2);
        Location l4 = new Location(3, 2);
        Location l5 = new Location(2, 3);
        Location l6 = new Location(6, 5);
        Location l7 = new Location(3, 6);
        Location l8 = new Location(5, 6);
        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, knightLegalMoves);


    }
    public static boolean testKnightMoveInsideBoard(){
        Player player1 = null;
        Player player2 = null;
        Board board1 = null;

        Knight knight1 = new Knight(1,1, board1, player1);

        Location l1 = new Location(3, 2);
        Location l2 = new Location(2, 3);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, knightLegalMoves);
    }

}

