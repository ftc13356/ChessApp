import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RookTest extends BaseTest {

    @Test
    public void testRookMove() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Rook rook1 = new Rook(4, 4, board1, player1);
        p1P.add(rook1);

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
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Rook rook1 = new Rook(1, 1, board1, player1);
        p1P.add(rook1);

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

    @Test
    public void testRookMoveLocationOccupiedbySameSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Rook rook1 = new Rook(4,4, board1, player1);
        Pawn ocupadopawn = new Pawn(4, 5, board1, player1);
        p1P.add(rook1); p1P.add(ocupadopawn);

        Location l1 = new Location(4, 3);
        Location l2 = new Location(4, 2);
        Location l3 = new Location(4, 1);
        Location l4 = new Location(3, 4);
        Location l5 = new Location(2, 4);
        Location l6 = new Location(1, 4);
        Location l7 = new Location(5, 4);
        Location l8 = new Location(6, 4);
        Location l9 = new Location(7, 4);
        Location l10 = new Location(8, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));
    }

    @Test
    public void testRookMoveLocationOccupiedbyOppSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P,p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Rook rook1 = new Rook(4,4, board1, player1);
        Pawn ocupadopawn = new Pawn(4, 5, board1, player2);
        p1P.add(rook1); p2P.add(ocupadopawn);

        Location l1 = new Location(4, 5);
        Location l2 = new Location(4, 3);
        Location l3 = new Location(4, 2);
        Location l4 = new Location(4, 1);
        Location l5 = new Location(3, 4);
        Location l6 = new Location(2, 4);
        Location l7 = new Location(1, 4);
        Location l8 = new Location(5, 4);
        Location l9 = new Location(6, 4);
        Location l10 = new Location(7, 4);
        Location l11 = new Location(8, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));
    }

    @Test
    @Ignore
    public void testRookBlockCheck(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Rook rook1 = new Rook(8,2, board1, player1);
        p1P.add(rook1);

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 8, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(1, 2);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));
    }

    @Test
    @Ignore
    public void testRookCaptureCheck(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Rook rook1 = new Rook(8,8, board1, player1);
        p1P.add(rook1);

        King king1 = new King(1, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 8, board1, player2);
        p1P.add(checkqueen);

        Location l1 = new Location(1, 8);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> rookLegalMoves = rook1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, rookLegalMoves));
    }
}
