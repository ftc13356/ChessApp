import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class KingTest extends BaseTest{

    @Test
    public void testKingMove() {

        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        King king1 = new King(4, 4, board1, player1);
        p1P.add(king1);

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
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Location l1 = new Location(2, 1);
        Location l2 = new Location(2, 2);
        Location l3 = new Location(1, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3));
        ArrayList<Location>KingLegalMoves = king1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, KingLegalMoves));
    }

    @Test
    public void testKingMoveLocationOccupiedbySameSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        King king1 = new King(4,4, board1, player1);
        p1P.add(king1);

        Pawn ocupadopawn = new Pawn(3, 5, board1, player1);
        p1P.add(ocupadopawn);

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
    public void testKingMoveLocationOccupiedbyOppSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(4,4, board1, player1);
        p1P.add(king1);

        Pawn ocupadopawn = new Pawn(3, 5, board1, player2);
        p2P.add(ocupadopawn);

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
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 3, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(2, 1);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }

    @Test
    @Ignore
    public void testKingCaptureCheck(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 2, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(1, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> kingLegalMoves = king1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, kingLegalMoves));
    }
}
