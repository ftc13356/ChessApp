import java.util.ArrayList;
import java.util.Arrays;

public class QueenTest extends BaseTest{
    public static void main(String[] args) {
        System.out.println("Queen move test " + (testQueenMove() ? "passed" : "failed"));
        System.out.println("Queen move inside board test " + (testQueenMoveInsideBoard() ? "passed" : "failed"));
    }
    public static boolean testQueenMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Queen queen1 = new Queen(4, 4, board1, player1);

        Location l1 = new Location(4, 5);
        Location l2 = new Location(4, 6);
        Location l3 = new Location(4, 7);
        Location l4 = new Location(4, 8);
        Location l5 = new Location(4, 3);
        Location l6 = new Location(4, 2);
        Location l7 = new Location(4, 1);
        Location l8 = new Location(3, 4);
        Location l9 = new Location(2, 4);
        Location l10 = new Location(1, 4);
        Location l11 = new Location(5, 4);
        Location l12 = new Location(6, 4);
        Location l13 = new Location(7, 4);
        Location l14 = new Location(8, 4);
        Location l15 = new Location(5, 5);
        Location l16 = new Location(6, 6);
        Location l17 = new Location(7, 7);
        Location l18 = new Location(8, 8);
        Location l19 = new Location(3, 3);
        Location l20 = new Location(2, 2);
        Location l21 = new Location(1, 1);
        Location l22 = new Location(3, 5);
        Location l23 = new Location(2, 6);
        Location l24 = new Location(1, 7);
        Location l25 = new Location(5, 3);
        Location l26 = new Location(6, 2);
        Location l27 = new Location(7, 1);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27));
        ArrayList<Location> queenLegalMoves = queen1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, queenLegalMoves);

    }
    public static boolean testQueenMoveInsideBoard() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Queen queen1 = new Queen(1, 1, board1, player1);

        Location l1 = new Location(2, 1);
        Location l2 = new Location(3, 1);
        Location l3 = new Location(4, 1);
        Location l4 = new Location(5, 1);
        Location l5 = new Location(6, 1);
        Location l6 = new Location(7, 1);
        Location l7 = new Location(8, 1);
        Location l8 = new Location(1, 2);
        Location l9 = new Location(1, 3);
        Location l10 = new Location(1, 4);
        Location l11 = new Location(1, 5);
        Location l12 = new Location(1, 6);
        Location l13 = new Location(1, 7);
        Location l14 = new Location(1, 8);
        Location l15 = new Location(2, 2);
        Location l16 = new Location(3, 3);
        Location l17 = new Location(4, 4);
        Location l18 = new Location(5, 5);
        Location l19 = new Location(6, 6);
        Location l20 = new Location(7, 7);
        Location l21 = new Location(8, 8);


        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21));
        ArrayList<Location> queenLegalMoves = queen1.getLegalMoves();

        return compare2Arrays(expectedLegalMoves, queenLegalMoves);

    }
}
