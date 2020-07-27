import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RookTest extends BaseTest {
//    public static void main(String[] args) {
//        System.out.println("Rook move test " + (testRookMove() ? "passed" : "failed"));
//        System.out.println("Rook move inside board test " + (testRookMoveInsideBoard() ? "passed" : "failed"));
//    }

    @Test
    public void testRookMove() {

        Board board1 = new Board();

        Player player1 = new Human(true, board1);

        Rook rook1 = new Rook(4, 4, board1, player1);

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

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));

    }

    @Test
    public void testRookMoveInsideBoard() {

        Board board1 = new Board();

        Player player1 = new Human(true, board1);

        Rook rook1 = new Rook(1, 1, board1, player1);

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

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));

    }
}
