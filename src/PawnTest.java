import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PawnTest extends BaseTest {

    @Test
    public void testWhitePawnBasicMove() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        p1P.add(pawn1);

        Location l1 = new Location(1, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));
    }

    @Test
    @Ignore
    public void testBlackPawnBasicMove() {
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p2P);
        Player player2 = board1.getP2();

        Pawn pawn1 = new Pawn(1, 6, board1, player2);
        p2P.add(pawn1);

        Location l1 = new Location(1, 5);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));
    }

    @Test
    public void testWhitePawnBasicMoveLocationOccupied() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);
        p1P.add(ocupadoPawn);

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        p1P.add(pawn1);

        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Not expecting any legal moves when occupied", pawnLegalMoves.size() == 0);


    }

    @Test
    @Ignore
    public void testBlackPawnBasicMoveLocationOccupied() {
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p2P);
        Player player2 = board1.getP2();

        Pawn ocupadoPawn = new Pawn(1, 5, board1, player2);
        p2P.add(ocupadoPawn);

        Pawn pawn1 = new Pawn(1, 6, board1, player2);
        p2P.add(pawn1);

        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Not expecting any legal moves when occupied", pawnLegalMoves.size() == 0);

    }

    @Test
    public void testWhitePawnFirstMove() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        p1P.add(pawn1);

        Location l1 = new Location(1, 3);
        Location l2 = new Location(1, 4);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));

    }

    @Test
    @Ignore
    public void testBlackPawnFirstMove() {
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p2P);
        Player player2 = board1.getP2();

        Pawn pawn1 = new Pawn(1, 7, board1, player2);
        p2P.add(pawn1);

        Location l1 = new Location(1, 6);
        Location l2 = new Location(1, 5);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1, l2));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));

    }

    @Test
    public void testWhitePawnFirstMoveTS1Occupied() {
            ArrayList<ChessPiece> p1P = new ArrayList<>();
            Board board1 = new Board(true, p1P);
            Player player1 = board1.getP1();

            Pawn ocupadoPawn = new Pawn(1, 3, board1, player1);
            p1P.add(ocupadoPawn);

            Pawn pawn1 = new Pawn(1, 2, board1, player1);
            p1P.add(pawn1);

            ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

            Assert.assertTrue("Not expecting any legal moves when occupied", pawnLegalMoves.size() == 0);

    }

    @Test
    @Ignore
    public void testBlackPawnFirstMoveTS1Occupied() {
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p2P);
        Player player2 = board1.getP2();

        Pawn ocupadoPawn = new Pawn(1, 6, board1, player2);
        p2P.add(ocupadoPawn);

        Pawn pawn1 = new Pawn(1, 7, board1, player2);
        p2P.add(pawn1);

        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Not expecting any legal moves when occupied", pawnLegalMoves.size() == 0);

    }

    @Test
    public void testWhitePawn2SquareMoveTS2Occupied() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);
        p1P.add(ocupadoPawn);

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        p1P.add(pawn1);

        Location l1 = new Location(1, 3);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));

    }

    @Test
    @Ignore
    public void testBlackPawn2SquareMoveTS2Occupied() {
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p2P);
        Player player2 = board1.getP2();

        Pawn ocupadoPawn = new Pawn(1, 5, board1, player2);
        p2P.add(ocupadoPawn);

        Pawn pawn1 = new Pawn(1, 7, board1, player2);
        p2P.add(pawn1);

        Location l1 = new Location(1, 6);

        ArrayList<Location> expectedLegalMoves = new ArrayList<Location>(Arrays.asList(l1));
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Comparing expected legal moves", compare2Arrays(expectedLegalMoves, pawnLegalMoves));

    }
}

