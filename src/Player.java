import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public boolean sideWhite;
    public Board board1;
    public boolean isHuman;

    public ArrayList<ChessPiece> pieceList = new ArrayList<>();

    public Player(boolean sideWhite, Board board){
        this.sideWhite = sideWhite;
        if(sideWhite==true){
            this.sideWhite=true;
            this.isHuman=true;
        } else {
            this.sideWhite=false;
            this.isHuman=true; // will change to false later when computer is made
        }

        board1 = board;

        int y;
        int y2;

        if(sideWhite != true) {
            y = 7;
            y2 = 8;
        }
        else{
            y = 2;
            y2 = 1;
        }

        Pawn pawn1 = new Pawn(1, y, board, this);
        Pawn pawn2 = new Pawn(2, y, board, this);
        Pawn pawn3 = new Pawn(3, y, board, this);
        Pawn pawn4 = new Pawn(4, y, board, this);
        Pawn pawn5 = new Pawn(5, y, board, this);
        Pawn pawn6 = new Pawn(6, y, board, this);
        Pawn pawn7 = new Pawn(7, y, board, this);
        Pawn pawn8 = new Pawn(8, y, board, this);
        Rook rook1 = new Rook(1, y2, board, this);
        Rook rook2 = new Rook(8, y2, board, this);
        Knight knight1 = new Knight(2, y2, board, this);
        Knight knight2 = new Knight(7, y2, board, this);
        Bishop bishop1 = new Bishop(3, y2, board, this);
        Bishop bishop2 = new Bishop(6, y2, board, this);
        Queen queen = new Queen(4, y2, board, this);
        King king = new King(5, y2, board, this);

        pieceList.add(pawn1);
        pieceList.add(pawn2);
        pieceList.add(pawn3);
        pieceList.add(pawn4);
        pieceList.add(pawn5);
        pieceList.add(pawn6);
        pieceList.add(pawn7);
        pieceList.add(pawn8);
        pieceList.add(rook1);
        pieceList.add(rook2);
        pieceList.add(knight1);
        pieceList.add(knight2);
        pieceList.add(bishop1);
        pieceList.add(bishop2);
        pieceList.add(queen);
        pieceList.add(king);
    }

    // testing only!!!
    public Player(boolean sideWhite, Board board, boolean emptyBoardTest, ArrayList<ChessPiece> pieces) {
        this.sideWhite = sideWhite;
        this.board1 = board;
        pieceList = pieces;
    }

    public abstract void movePiece();

    public boolean isSidewhite() {
        return this.sideWhite;
        // Later have to change to input from Human to decide sides
    }

    public void remove(ChessPiece piece){
        System.out.println(piece + " has been captured");
        pieceList.remove(piece);
    }
    public ChessPiece getKing(){
        for(int i=0;i<this.pieceList.size();i++){
            if(this.pieceList.get(i) instanceof King){
                return this.pieceList.get(i);
            }
        }
        return null;
    }

    public void add (ChessPiece piece){
        pieceList.add(piece);
    }
}