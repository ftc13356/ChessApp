import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public boolean sideWhite;
    public static Board board1;
    public boolean isHuman;
    
    public Player(boolean sideWhite, Board board){
        this.sideWhite = sideWhite;
        if(sideWhite==true){
            this.isHuman=true;
        } else {
            this.isHuman=false;
        }

        board1 = board;

        Player player = null;
        
        List pieceList = new ArrayList();

        Pawn wpawn1 = new Pawn(0, 1, board, player);
        Pawn wpawn2 = new Pawn(1,1, board, player);
        Pawn wpawn3 = new Pawn(2,1, board, player);
        Pawn wpawn4 = new Pawn(3,1, board, player);
        Pawn wpawn5 = new Pawn(4,1, board, player);
        Pawn wpawn6 = new Pawn(5,1, board, player);
        Pawn wpawn7 = new Pawn(6,1, board, player);
        Pawn wpawn8 = new Pawn(7,1, board, player);
        Rook wrook1 = new Rook(0,0, board, player);
        Rook wrook2 = new Rook(0,7, board, player);
        Knight wknight1 = new Knight(1,0, board, player);
        Knight wknight2 = new Knight(6,0, board, player);
        Bishop wbishop1 = new Bishop(2,0, board, player);
        Bishop wbishop2 = new Bishop(5,0, board, player);
        Queen wqueen = new Queen(3,0, board, player);
        King wking = new King(4,0, board, player);

        pieceList.add(wpawn1);
        pieceList.add(wpawn2);
        pieceList.add(wpawn3);
        pieceList.add(wpawn4);
        pieceList.add(wpawn5);
        pieceList.add(wpawn6);
        pieceList.add(wpawn7);
        pieceList.add(wpawn8);
        pieceList.add(wrook1);
        pieceList.add(wrook2);
        pieceList.add(wknight1);
        pieceList.add(wknight2);
        pieceList.add(wbishop1);
        pieceList.add(wbishop2);
        pieceList.add(wqueen);
        pieceList.add(wking);

    }

    public abstract void movePiece();

    public boolean isSidewhite() {
        return this.sideWhite;
        // Later have to change to input from Human to decide sides
    }

}
