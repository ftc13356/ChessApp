import java.util.ArrayList;

class Board {
    private Player p1;
    private Player p2;

    //Player class will provide way to read role and color inputed
    public static void main(String[] args){
        /*Instantiating**/
        Board board = new Board();
        board.start();
    }

    public Board() {
        p1 = new Human(true, this);
        p2 = new Human(false, this);
    }

    // testing only!!!
    public Board(boolean emptyBoardTest, ArrayList<ChessPiece> p1Pieces) {
        p1 = new Human(true, this, true, p1Pieces);
        p2 = new Human(false, this, true, new ArrayList<>());
    }
    public Board(boolean emptyBoardTest, ArrayList<ChessPiece> p1Pieces, ArrayList<ChessPiece> p2Pieces) {
        p1 = new Human(true, this, true, p1Pieces);
        p2 = new Human(false, this, true, p2Pieces);
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    // need to confirm color value of player class
    // assume player takes care of move method & pass the next moves
    public void start() {
        int turn=0;
        while(true){
            printBoard();
            if(turn%2==0){
                p1.movePiece();
            }
            else{
                p2.movePiece();
            }
            turn++;
        }
    }

    public void printBoard(){
        for(int i=8;i>0;i--) {
            System.out.println("_________________________________________________");
            for(int j=1;j<9;j++){
                System.out.print('|');
                if(this.isLocationOccupied(j,i)!=null){
                    System.out.print(" "+this.isLocationOccupied(j,i).getAbbreviation()+" ");
                }
                else{
                    System.out.print("     ");//a will be replaced with chesspiece name
                }
            }
            System.out.print('|');
            System.out.print("\n");
        }
        System.out.println("_________________________________________________");
    }

    public boolean isOutOfBoard(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return false;
        } else {
            return true;
        }
    }

    public ChessPiece isLocationOccupied(int x, int y) {
        int[] location = {x,y};
        for (int i = 0; i < p1.pieceList.size(); i++) { // arrayList defined in player class
            if (location[0] == p1.pieceList.get(i).getLocation()[0]&&location[1] == p1.pieceList.get(i).getLocation()[1]) {
                return p1.pieceList.get(i);
            }
        }
        for (int i = 0; i < p2.pieceList.size(); i++) { // arrayList defined in player class
            if (location[0] == p2.pieceList.get(i).getLocation()[0]&&location[1] == p2.pieceList.get(i).getLocation()[1]) {
                return p2.pieceList.get(i);
            }
        }
        return null;
    }

    public ChessPiece check(int x, int y, Player player) {
        Location location= new Location();
        location.setLocation(x,y);
        for (int i = 0; i < player.pieceList.size(); i++) { // arrayList defined in player class
            ArrayList<Location> moves=player.pieceList.get(i).getLegalMoves();
            for(int j=0;j<moves.size();j++){
                if(moves.get(j)==location){
                    return player.pieceList.get(i);
                }
            }
        }
        return null;
    }
    public void remove(ChessPiece piece){
        if(piece.getPlayer().isSidewhite()!=p1.isSidewhite()){
            //p2.remove(piece);
        }
        else{
            //p1.remove(piece);
        }
    }

    /*
    void analysis() { //method called in above
        //check if king in danger, print check

     }
     */
}