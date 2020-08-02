import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class KingTest extends BaseTest{

    @Test
    public void testKingMove() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

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

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, KingLegalMoves));

    }

    @Test
    public void testKingMoveInsideBoard() {
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

        King king1 = new King(1, 1, board1, player1);

        Location l1 = new Location(2, 1);
        Location l2 = new Location(2, 2);
        Location l3 = new Location(1, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3));
        ArrayList<Location>KingLegalMoves = king1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, KingLegalMoves));
    }

    @Test
    @Ignore
    public void testKingMoveLocationOccupiedbySameSide(){
        Board board1 = new Board();
        Player player1 = new Human(true, board1);

        King king1 = new King(4,4, board1, player1);
        Pawn ocupadopawn = new Pawn(3, 5, board1, player1);

        Location l1 = new Location(4, 5);
        Location l2 = new Location(5, 5);
        Location l3 = new Location(5, 4);
        Location l4 = new Location(5, 3);
        Location l5 = new Location(4, 3);
        Location l6 = new Location(3, 3);
        Location l7 = new Location(3, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }

    @Test
    @Ignore
    public void testKingMoveLocationOccupiedbyOppSide(){
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        King king1 = new King(4,4, board1, player1);
        Pawn ocupadopawn = new Pawn(3, 5, board1, player2);

        Location l1 = new Location(4, 5);
        Location l2 = new Location(5, 5);
        Location l3 = new Location(5, 4);
        Location l4 = new Location(5, 3);
        Location l5 = new Location(4, 3);
        Location l6 = new Location(3, 3);
        Location l7 = new Location(3, 4);
        Location l8 = new Location(3, 5);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }

    @Test
    @Ignore
    public void testKingMoveOutofCheck(){
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        King king1 = new King(1, 1, board1, player1);
        Queen checkqueen = new Queen(1, 3, board1, player2);

        Location l1 = new Location(2, 1);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }

    @Test
    @Ignore
    public void testKingCaptureCheck(){
        Board board1 = new Board();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        King king1 = new King(1, 1, board1, player1);
        Queen checkqueen = new Queen(1, 2, board1, player2);

        Location l1 = new Location(1, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }
}
