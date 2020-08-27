import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {

    @Test
    public void move() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 3, board1, player1);
        p1P.add(pawn1);

        King king1 = new King(1, 2, board1, player1);
        p1P.add(king1); board1.printBoard();

        boolean moveSuccessful = pawn1.move(1, 4);
        Assert.assertTrue("Pawn move to 3rd rank", moveSuccessful);

        int numberOfWhitePieces = player1.pieceList.size();
        Assert.assertTrue("only pawn and king", (numberOfWhitePieces == 2));
    }

    @Test
    public void capture() {
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
        p1P.add(king1); board1.printBoard();

        boolean moveSuccessful = bishop1.move(6, 8);
        Assert.assertTrue("bishop captures knight", moveSuccessful);

        int numberOfWhitePieces = player1.pieceList.size();
        Assert.assertTrue("only bishop and king for white", (numberOfWhitePieces == 2));

        int numberOfBlackPieces = player2.pieceList.size();
        Assert.assertTrue("knight is gone", (numberOfBlackPieces == 0));
    }

    @Test
    public void checkBoardSetup() {
        Board board1 = new Board(); board1.printBoard();
        Player player1 = new Human(true, board1);
        Player player2 = new Human(false, board1);

        Assert.assertTrue("Rook on 1, 1", board1.isLocationOccupied(1, 1) instanceof Rook);
        Assert.assertTrue("Knight on 2, 1", board1.isLocationOccupied(2, 1) instanceof Knight);
        Assert.assertTrue("Bishop on 3, 1", board1.isLocationOccupied(3, 1) instanceof Bishop);
        Assert.assertTrue("Queen on 4, 1", board1.isLocationOccupied(4, 1) instanceof Queen);
        Assert.assertTrue("King on 5, 1", board1.isLocationOccupied(5, 1) instanceof King);
        Assert.assertTrue("Bishop on 6, 1", board1.isLocationOccupied(6, 1) instanceof Bishop);
        Assert.assertTrue("Knight on 7, 1", board1.isLocationOccupied(7, 1) instanceof Knight);
        Assert.assertTrue("Rook on 8, 1", board1.isLocationOccupied(8, 1) instanceof Rook);
        Assert.assertTrue("Pawn on 1, 2", board1.isLocationOccupied(1, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 2, 2", board1.isLocationOccupied(2, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 3, 2", board1.isLocationOccupied(3, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 4, 2", board1.isLocationOccupied(4, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 5, 2", board1.isLocationOccupied(5, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 6, 2", board1.isLocationOccupied(6, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 7, 2", board1.isLocationOccupied(7, 2) instanceof Pawn);
        Assert.assertTrue("Pawn on 8, 2", board1.isLocationOccupied(8, 2) instanceof Pawn);
    }

    @Test
    public void testPawnPromotion() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        Board board1 = new Board(true, p1P);
        Player player1 = board1.getP1();

        Pawn pawn1 = new Pawn(1, 7, board1, player1);
        p1P.add(pawn1); board1.printBoard();

        boolean moveSuccessful = pawn1.move(1, 8);
        Assert.assertTrue("Pawn move to 8th rank", moveSuccessful);

        ChessPiece possibleQueen = board1.isLocationOccupied(1, 8);
        Assert.assertTrue("Pawn promote to queen", (possibleQueen instanceof Queen));

        ChessPiece nonexistentPawn = board1.isLocationOccupied(1, 7);
        Assert.assertTrue("Pawn is gone", (nonexistentPawn == null));
    }

    @Test
    public void testPawnPromotionWithCapture() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        Pawn pawn1 = new Pawn(1, 7, board1, player1);
        p1P.add(pawn1);

        Knight knight1 = new Knight(2, 8, board1, player2);
        p2P.add(knight1); board1.printBoard();

        boolean moveSuccessful = pawn1.move(2, 8);
        Assert.assertTrue("Pawn move to 8th rank", moveSuccessful);

        ChessPiece possibleQueen = board1.isLocationOccupied(2, 8);
        Assert.assertTrue("Pawn promote to queen", (possibleQueen instanceof Queen));

        ChessPiece nonexistentPawn = board1.isLocationOccupied(1, 7);
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
        p2P.add(checkqueen); board1.printBoard();

        boolean moveSuccessful = knight1.move(5, 2);
        Assert.assertTrue("Knight cannot move to 5, 2", moveSuccessful == false);

        moveSuccessful = knight1.move(6, 3);
        Assert.assertTrue("Knight cannot move to 6, 3", (moveSuccessful == false));

        moveSuccessful = knight1.move(8, 3);
        Assert.assertTrue("Knight can move to 8, 3", (moveSuccessful == true));
    }

    @Test
    public void moveOutOfCheck() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen); board1.printBoard();

        boolean moveSuccessful = king1.move(8, 2);
        Assert.assertTrue("King cannot move to 8, 2", moveSuccessful == false);


        moveSuccessful = king1.move(7, 1);
        Assert.assertTrue("King can move to 7, 1", (moveSuccessful == true));

        king1.setLocation(8, 1);

        moveSuccessful = king1.move(7, 2);
        Assert.assertTrue("King can move to 7, 2", (moveSuccessful == true));
    }

    @Test
    public void captureCheck() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen);

        Rook rook1 = new Rook(7, 8, board1, player1);
        p1P.add(rook1);

        Pawn moveLimitingPawn = new Pawn(7, 6, board1, player1);
        p1P.add(moveLimitingPawn);

        Knight moveLimitingKnight = new Knight(5, 8, board1, player1);
        p1P.add(moveLimitingKnight); board1.printBoard();

        boolean moveSuccessful = rook1.move(6, 8);
        Assert.assertTrue("Rook cannot move to 6, 8", moveSuccessful == false);


        moveSuccessful = rook1.move(7, 7);
        Assert.assertTrue("Rook cannot move to 7, 7", (moveSuccessful == false));

        moveSuccessful = rook1.move(8, 8);
        Assert.assertTrue("Rook can move to 8, 8", (moveSuccessful == true));
    }

    @Test
    public void captureCheckWithKingLegal() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(7, 7, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen); board1.printBoard();

        boolean moveSuccessful = king1.move(8, 8);
        Assert.assertTrue("King can capture queen", (moveSuccessful == true));
    }

    @Test
    public void captureCheckWithKingIllegal() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(7, 7, board1, player1);
        p1P.add(king1);

        Queen checkqueen = new Queen(8, 8, board1, player2);
        p2P.add(checkqueen);

        Queen checkQueenProtector = new Queen(1, 8, board1, player2);
        p2P.add(checkQueenProtector); board1.printBoard();

        boolean moveSuccessful = king1.move(8, 8);
        Assert.assertTrue("King cannot capture queen", (moveSuccessful == false));
    }

    @Test
    public void absolutePin() {
        ArrayList<ChessPiece> p1P = new ArrayList<>();
        ArrayList<ChessPiece> p2P = new ArrayList<>();
        Board board1 = new Board(true, p1P, p2P);
        Player player1 = board1.getP1();
        Player player2 = board1.getP2();

        King king1 = new King(8, 1, board1, player1);
        p1P.add(king1);

        Queen pinqueen = new Queen(1, 8, board1, player2);
        p2P.add(pinqueen);

        Pawn pinnedPawn = new Pawn(6, 3, board1, player1);
        p1P.add(pinnedPawn); board1.printBoard();

        boolean moveSuccessful = pinnedPawn.move(6, 4);
        Assert.assertTrue("Pawn cannot move", (moveSuccessful == false));
    }
}
