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
    //left this in so rest of code would compile
    public Board(Player p1, Player p2) {
        this.p1 = (Human)p1;
        this.p2 = (Human)p2;
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
            if(turn%2==0){
                //p1.movePiece();
            }
            else{
                //p2.movePiece();
            }
            turn++;
        }
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
            if (location == p1.pieceList.get(i).getLocation()) {
                return p1.pieceList.get(i);
            }
        }
        for (int i = 0; i < p2.pieceList.size(); i++) { // arrayList defined in player class
            if (location == p2.pieceList.get(i).getLocation()) {
                return p2.pieceList.get(i);
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