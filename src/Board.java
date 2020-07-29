import java.util.ArrayList;

class Board {
    private Player p1;
    private Player p2;
//    int p1Type = 0; // 0 human (default), 1 computer
//    int p2Type = 0; // 0 human (default), 1 computer
//    int p1Color = 0; // 0 white (default), 1 black
//    int p2Color = 0; // 0 white (default), 1 black
//    int p1Checked = 0; // 0 not checked (default), 14 checked
//    int p2Checked = 0; // 0 not checked default), 1 checked

    //Player class will provide way to read role and color inputed
    public static void main(String args[]){
        /**Instantiating**/
        Board board = new Board();
        board.start();
    }
    public Board() {
        p1 = new Human(true, this);
        p2 = new Human(false, this);
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
        for(int i=1;i<9;i++) {
            System.out.println("_________________________________________________");
            for(int j=1;j<9;j++){
                System.out.print('|');
                if(this.isLocationOccupied(j,i)!=null){
                    System.out.print("  a  ");
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


    //waiting for the arrayList from player class


    /*
    void analysis() { //method called in above
        //check if king in danger, print check

     }
     */
}