import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class KnightTest extends BaseTest {

    @Test
    public void testKnightMove() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Knight knight1 = new Knight(4, 4, board1, player1);
        p1P.add(knight1); board1.printBoard();

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
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Knight knight1 = new Knight(1, 1, board1, player1);
        p1P.add(knight1); board1.printBoard();

        Location l1 = new Location(3, 2);
        Location l2 = new Location(2, 3);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    public void testKnightMoveLocationOccupiedbySameSide() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();


        Knight knight1 = new Knight(4, 4, board1, player1);
        p1P.add(knight1);

        Pawn ocupadopawn = new Pawn(5, 6, board1, player1);
        p1P.add(ocupadopawn); board1.printBoard();

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
    public void testKnightMoveLocationOccupiedbyOppSide() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Knight knight1 = new Knight(4, 4, board1, player1);
        p1P.add(knight1);

        Pawn ocupadopawn = new Pawn(5, 6, board1, player2);
        p2P.add(ocupadopawn); board1.printBoard();


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
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Knight knight1 = new Knight(3, 1, board1, player1);
        p1P.add(knight1);

        King king1 = new King(1, 1, board1, player1);
        p1P.add(knight1);

        Queen checkqueen = new Queen(1, 8, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(6, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

    @Test
    @Ignore
    public void testKnightCaptureCheck() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Knight knight1 = new Knight(3, 7, board1, player1);
        p1P.add(knight1);

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 8, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(1, 8);
        Location l2 = new Location(1, 6);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> knightLegalMoves = knight1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, knightLegalMoves));
    }

}

