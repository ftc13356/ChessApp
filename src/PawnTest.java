import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PawnTest extends BaseTest {

    @Test
    public void testPawnBasicMove() {
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
    public void testPawnBasicMoveLocationOccupied() {
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
    public void testPawn2SquareMove() {
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
    public void testPawn2SquareMoveTS1Occupied() {
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


    @Before
    public void setupBoard(){

    }

    @Test
    public void testPawn2SquareMoveTS2Occupied() {
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
}

