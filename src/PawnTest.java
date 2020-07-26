import java.util.ArrayList;

public class PawnTest extends BaseTest {
    public static void main(String[] args) {

        System.out.println("Pawn basic move test " + (testPawnBasicMove() ? "passed" : "failed"));
        System.out.println("Pawn basic move location occupied has not been programmed yet");
        System.out.println("Pawn 2 square move has not been programmed yet");
        System.out.println("Pawn 2 square move target square 1 occupied has not been programmed yet");
        System.out.println("Pawn 2 square move target square 2 occupied has not been programmed yet");
    }

    public static boolean testPawnBasicMove() {
        Player player1 = null;
        Player player2 = null;
        Board board1 = null;

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
        Board board1 = null;

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
        Board board1 = null;

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
        Board board1 = null;

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
        Board board1 = null;

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

