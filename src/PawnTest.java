import java.util.ArrayList;

public class PawnTest extends BaseTest {
    public static void main(String[] args) {

        System.out.println("Pawn basic move test " + (testPawnBasicMove() ? "passed" : "failed"));
        System.out.println("Pawn basic move location occupied test " + (testPawnBasicMoveLocationOccupied() ? "passed" : "failed"));
        System.out.println("Pawn 2 square move test " + (testPawn2SquareMove() ? "passed" : "failed"));
        System.out.println("Pawn 2 square move target square 1 occupied test " + (testPawn2SquareMoveTS1Occupied() ? "passed" : "failed"));
        System.out.println("Pawn 2 square move target square 2 occupied test has " + (testPawn2SquareMoveTS2Occupied() ? "passed" : "failed"));
    }

    public static boolean testPawnBasicMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        if (pawnLegalMoves.size() != 1) {
            return false;
        }

        if (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testPawnBasicMoveLocationOccupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        if (pawnLegalMoves.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean testPawn2SquareMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        if (pawnLegalMoves.size() != 2) {
            return false;
        }

        if (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 3 && pawnLegalMoves.get(0).getLocation()[2] == 1 && pawnLegalMoves.get(0).getLocation()[3] == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testPawn2SquareMoveTS1Occupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 3, board1, player1);

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        if (pawnLegalMoves.size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean testPawn2SquareMoveTS2Occupied() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        Pawn ocupadoPawn = new Pawn(1, 4, board1, player1);

        Pawn pawn1 = new Pawn(1, 2, board1, player1);
        ArrayList<Location> pawnLegalMoves = pawn1.getLegalMoves();

        if (pawnLegalMoves.size() != 1) {
            return false;
        }
        if (pawnLegalMoves.get(0).getLocation()[0] == 1 && pawnLegalMoves.get(0).getLocation()[1] == 3) {
            return true;
        } else {
            return false;
        }
    }
}

