import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PawnTest extends BaseTest {
//    public static void main(String[] args) {
//
//        System.out.println("Pawn basic move test " + (testPawnBasicMove() ? "passed" : "failed"));
//        System.out.println("Pawn basic move location occupied test " + (testPawnBasicMoveLocationOccupied() ? "passed" : "failed"));
//        System.out.println("Pawn 2 square move test " + (testPawn2SquareMove() ? "passed" : "failed"));
//        System.out.println("Pawn 2 square move target square 1 occupied test " + (testPawn2SquareMoveTS1Occupied() ? "passed" : "failed"));
//        System.out.println("Pawn 2 square move target square 2 occupied test has " + (testPawn2SquareMoveTS2Occupied() ? "passed" : "failed"));
//    }


    @Test
    public void testPawnBasicMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertEquals("Validating number of legal moves", 1, pawnLegalMoves.size());

        Assert.assertTrue("Expected 1,4 legal move", (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 4));


    }

    @Test
    public void testPawnBasicMoveLocationOccupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertTrue("Not expecting any legal moves when occupied", pawnLegalMoves.size() == 0);


    }

    @Test
    public void testPawn2SquareMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();


        Assert.assertTrue("Expecting 2 legal moves when on 2nd rank", pawnLegalMoves.size() == 2);
        Assert.assertTrue("Expecting valid 2 moves when on 2nd rank", (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 3 && pawnLegalMoves.get(0).getLocation()[2] == 1 && pawnLegalMoves.get(0).getLocation()[3] == 4));
    }

    @Test
    public void testPawn2SquareMoveTS1Occupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 3, board1, player1);

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();
        Assert.assertEquals("Validating number of legal moves", 0, pawnLegalMoves.size());
//        if (pawnLegalMoves.size() != 0) {
//            return false;
//        } else {
//            return true;
//        }
    }


    @Before
    public void setupBoard(){

    }

    @Test
    public void testPawn2SquareMoveTS2Occupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        Assert.assertEquals("Validating number of legal moves", 1, pawnLegalMoves.size());

        Assert.assertTrue("Validating the move", (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 3));


    }
}

