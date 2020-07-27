public class TestProgram {
    public static void main(String args[]){
        /**Instantiating**/

        Player player1 = null;
        Player player2 = null;
        Board board1 = new Board();

        King king = new King(1,1, board1, player1);
        System.out.println("========================================================");
        System.out.println("king was place at 1,1");
        System.out.println("\tLegal moves should be 1,2 2,1 2,2");
        System.out.println("\tgetLegalMoves: " + king.getLegalMoves());
        System.out.println("\n");

        Knight knight1 = new Knight(8,1,board1, player1);
        System.out.println(knight1.getLegalMoves());
        System.out.println("knight ");

        Pawn pawn1 = new Pawn(1,8, board1, player1);
        System.out.println(pawn1.getLegalMoves());
        System.out.println("pawn");

        Queen queen1 = new Queen(4,4, board1, player2);
        System.out.println(queen1.getLegalMoves());
        System.out.println("queen finished");

        Rook rook1 = new Rook(8,8, board1, player1);
        System.out.println(rook1.getLegalMoves());
        System.out.println("rook finished");

    }
}
