public class TestProgram {
    public static void main(String args[]){
        /**Instantiating**/

        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board(null, null);

        King king = new King(1,1, board1, player1);
        Knight knight1 = new Knight(8,1,board1, player1);
        Pawn pawn1 = new Pawn(1,8, board1, player1);
        Queen queen1 = new Queen(4,4, board1, player2);
        Rook rook1 = new Rook(8,8, board1, player1);

        System.out.println(king.getLegalMoves());
        System.out.println("king");
        System.out.println(knight1.getLegalMoves());
        System.out.println("knight ");
        System.out.println(pawn1.getLegalMoves());
        System.out.println("pawn");
        System.out.println(queen1.getLegalMoves());
        System.out.println("queen finished");
        System.out.println(rook1.getLegalMoves());
        System.out.println("rook finished");

    }
}
