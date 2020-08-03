public class TestProgram {
    public static void main(String[] args){

        Board board1 = new Board();
        Human player1 = new Human(true, board1);

        System.out.println("king");
        King king = new King(5,5, board1, player1);
        System.out.println(king.getLegalMoves());

        System.out.println("queen");
        Queen queen = new Queen(4,4, board1, player1);
        System.out.println(queen.getLegalMoves());

        System.out.println("rook");
        Rook rook = new Rook(8,8, board1, player1);
        System.out.println(rook.getLegalMoves());

        System.out.println("bishop");
        Bishop bishop = new Bishop(3,3,board1, player1);
        System.out.println(bishop.getLegalMoves());

        System.out.println("knight");
        Knight knight = new Knight(4,5,board1, player1);
        System.out.println(knight.getLegalMoves());

        System.out.println("pawn");
        Pawn pawn = new Pawn(2,2, board1, player1);
        System.out.println(pawn.getLegalMoves());

    }
}
