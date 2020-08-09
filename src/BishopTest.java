import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BishopTest extends BaseTest {

    @Test
    public void testBishopMove() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Bishop bishop1 = new Bishop(4, 4, board1, player1);
        p1P.add(bishop1); board1.printBoard();

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

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));

    }

    @Test
    public void testBishopMoveInsideBoard() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Bishop bishop1 = new Bishop(1, 1, board1, player1);
        p1P.add(bishop1); board1.printBoard();

        Location l1 = new Location(2, 2);
        Location l2 = new Location(3, 3);
        Location l3 = new Location(4, 4);
        Location l4 = new Location(5, 5);
        Location l5 = new Location(6, 6);
        Location l6 = new Location(7, 7);
        Location l7 = new Location(8, 8);

        ArrayList<Location> expectedLegalMoves = new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));

    }

    @Test
    public void testBishopMoveLocationOccupiedbySameSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Bishop bishop1 = new Bishop(4,4, board1, player1);
        p1P.add(bishop1);

        Pawn ocupadopawn = new Pawn(5, 5, board1, player1);
        p1P.add(ocupadopawn); board1.printBoard();

        Location l1 = new Location(3, 3);
        Location l2 = new Location(2, 2);
        Location l3 = new Location(1, 1);
        Location l4 = new Location(3, 5);
        Location l5 = new Location(2, 6);
        Location l6 = new Location(1, 7);
        Location l7 = new Location(5, 3);
        Location l8 = new Location(6, 2);
        Location l9 = new Location(7, 1);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));
    }

    @Test
    public void testBishopMoveLocationOccupiedbyOppSide(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Bishop bishop1 = new Bishop(4,4, board1, player1);
        p1P.add(bishop1);

        Pawn ocupadopawn = new Pawn(5, 5, board1, player2);
        p2P.add(ocupadopawn); board1.printBoard();

        Location l1 = new Location(5, 5);
        Location l2 = new Location(3, 3);
        Location l3 = new Location(2, 2);
        Location l4 = new Location(1, 1);
        Location l5 = new Location(3, 5);
        Location l6 = new Location(2, 6);
        Location l7 = new Location(1, 7);
        Location l8 = new Location(5, 3);
        Location l9 = new Location(6, 2);
        Location l10 = new Location(7, 1);
        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));
    }

    @Test
    @Ignore
    public void testBishopBlockCheck(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Bishop bishop1 = new Bishop(2,1, board1, player1);
        p1P.add(bishop1);

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(1, 8, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(5, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();


        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));
    }

    @Test
    @Ignore
    public void testBishopCaptureCheck(){
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Bishop bishop1 = new Bishop(1,1, board1, player1);
        p1P.add(bishop1);

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen);

        Location l1 = new Location(8, 8);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> bishopLegalMoves = bishop1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, bishopLegalMoves));
    }

}