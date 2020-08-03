import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class KnightTest extends BaseTest {

    @Test
    public void testKnightMove() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

        Knight knight1 = new Knight(4, 4, board1, player1);

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

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));

    }

    @Test
    public void testKnightMoveInsideBoard() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

        Knight knight1 = new Knight(1, 1, board1, player1);

        Location l1 = new Location(3, 2);
        Location l2 = new Location(2, 3);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    @Ignore
    public void testKnightMoveLocationOccupiedbySameSide() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

        Knight knight1 = new Knight(4, 4, board1, player1);
        Pawn ocupadopawn = new Pawn(5, 6, board1, player1);

        Location l1 = new Location(6, 3);
        Location l2 = new Location(6, 5);
        Location l3 = new Location(5, 2);
        Location l4 = new Location(3, 2);
        Location l5 = new Location(2, 3);
        Location l6 = new Location(6, 5);
        Location l7 = new Location(3, 6);
        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    @Ignore
    public void testKnightMoveLocationOccupiedbyOppSide() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        Knight knight1 = new Knight(4, 4, board1, player1);
        Pawn ocupadopawn = new Pawn(5, 6, board1, player2);

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


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    @Ignore
    public void testKnightBlockCheck() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        Knight knight1 = new Knight(3, 1, board1, player1);
        King king1 = new King(1, 1, board1, player1);
        Queen checkqueen = new Queen(1, 8, board1, player2);

        Location l1 = new Location(6, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    @Ignore
    public void testKnightCaptureCheck() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        Knight knight1 = new Knight(3, 7, board1, player1);
        King king1 = new King(1, 1, board1, player1);
        Queen checkqueen = new Queen(1, 8, board1, player2);

        Location l1 = new Location(1, 8);
        Location l2 = new Location(1, 6);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

}

