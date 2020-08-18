import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {

    @Test
    public void Move() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        p1P.add(pawn1);

        King king1 = new King(1, 2, board1, player1);
        p1P.add(king1);

        boolean moveSuccessful = pawn1.move(1, 4);
        Assert.assertTrue("Pawn move to 3rd rank", moveSuccessful);

        int numberOfWhitePieces = player1.pieceList.size();
        Assert.assertTrue("only pawn and king", (numberOfWhitePieces == 2));
    }

    @Test
    public void Capture() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Bishop bishop1 = new Bishop(1, 3, board1, player1);
        p1P.add(bishop1);

        Knight capturableKnight = new Knight(6, 8, board1, player2);
        p2P.add(capturableKnight);

        King king1 = new King(1, 2, board1, player1);
        p1P.add(king1);

        boolean moveSuccessful = bishop1.move(6, 8);
        Assert.assertTrue("bishop captures knight", moveSuccessful);

        int numberOfWhitePieces = player1.pieceList.size();
        Assert.assertTrue("only bishop and king for white", (numberOfWhitePieces == 2));

        int numberOfBlackPieces = player2.pieceList.size();
        Assert.assertTrue("knight is gone", (numberOfBlackPieces == 0));
    }
    @Test
    public void testPawnPromotion() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 7, board1, player1);
        p1P.add(pawn1);

        boolean moveSuccessful = pawn1.move(1, 8);
        Assert.assertTrue("Pawn move to 8th rank", moveSuccessful);

        ChessPiece possibleQueen = board1.isLocationOccupied(1,8);
        Assert.assertTrue("Pawn promote to queen", (possibleQueen instanceof Queen));

        ChessPiece nonexistentPawn = board1.isLocationOccupied(1, 7 );
        Assert.assertTrue("Pawn is gone", (nonexistentPawn == null));
    }

    @Test
    @Ignore
    public void testPawnPromotionWithCapture() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Pawn pawn1 = new Pawn(1, 7, board1, player1);
        p1P.add(pawn1);

        Knight knight1 = new Knight(2, 7, board1, player2);
        p2P.add(knight1);

        boolean moveSuccessful = pawn1.move(2, 8);
        Assert.assertTrue("Pawn move to 8th rank", moveSuccessful);

        ChessPiece possibleQueen = board1.isLocationOccupied(2,8);
        Assert.assertTrue("Pawn promote to queen", (possibleQueen instanceof Queen));

        ChessPiece nonexistentPawn = board1.isLocationOccupied(1, 7 );
        Assert.assertTrue("Pawn is gone", (nonexistentPawn == null));

        int numberOfWhitePieces = player1.pieceList.size();
        int numberOfBlackPieces = player2.pieceList.size();
        Assert.assertTrue("1 piece for white", (numberOfWhitePieces == 1));
        Assert.assertTrue("0 pieces for black", (numberOfBlackPieces == 0));
    }

    @Test
    public void blockCheck() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Knight knight1 = new Knight(7, 1, board1, player1);
        p1P.add(knight1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen);

        boolean moveSuccessful = knight1.move(5, 2);
        Assert.assertTrue("Knight cannot move to 5, 2", moveSuccessful == false);


        moveSuccessful = knight1.move(6, 3);
        Assert.assertTrue("Knight cannot move to 6, 3", (moveSuccessful == false));

        moveSuccessful = knight1.move(8, 3);
        Assert.assertTrue("Knight can move to 8, 3", (moveSuccessful == true));
    }
}
