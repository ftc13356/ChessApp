public class Computer extends Player{
    public Computer(boolean sidewhite) {
        if (sidewhite == true)
                this.sideWhite = false;
        else
            this.sideWhite = true;

        this.isHuman = false;
    }

    public static Player player = new Player() {};
    public static Player human1 = new Player() {};
    public static Player computer = new Player() {};
    public static Board board = new Board(human1, computer);

    public static Pawn wpawn1 = new Pawn(0,7, board, player);
    public static Pawn wpawn2 = new Pawn(1,7, board, player);
    public static Pawn wpawn3 = new Pawn(2,7, board, player);
    public static Pawn wpawn4 = new Pawn(3,7, board, player);
    public static Pawn wpawn5 = new Pawn(4,7, board, player);
    public static Pawn wpawn6 = new Pawn(5,7, board, player);
    public static Pawn wpawn7 = new Pawn(6,7, board, player);
    public static Pawn wpawn8 = new Pawn(7,7, board, player);
    public static Rook wrook1 = new Rook(0,8, board, player);
    public static Rook wrook2 = new Rook(7,8, board, player);
    public static Knight wknight1 = new Knight(1,8, board, player) {
        @Override
        public void move(int x, int y) {

        }
    };
    public static Knight wknight2 = new Knight(6,8, board, player) {
        @Override
        public void move(int x, int y) {
        }
    };
    public static Bishop wbishop1 = new Bishop(2,8, board, player);
    public static Bishop wbishop2 = new Bishop(5,8, board, player);
    public static Queen wqueen = new Queen(3,8, board, player);
    public static King wking = new King(4,0, board, player);

}
