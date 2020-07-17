class Board {
    private Human p1;
    private Human p2;
//    int p1Type = 0; // 0 human (default), 1 computer
//    int p2Type = 0; // 0 human (default), 1 computer
//    int p1Color = 0; // 0 white (default), 1 black
//    int p2Color = 0; // 0 white (default), 1 black
//    int p1Checked = 0; // 0 not checked (default), 14 checked
//    int p2Checked = 0; // 0 not checked default), 1 checked

    //Player class will provide way to read role and color inputed
    public Board(Human p1, Human p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Board() {
        p1 = new Human(true);
        p2 = new Human(false);
    }

    // need to confirm color value of player class
    // assume player takes care of move method & pass the next moves
    public void start() {
        if (p1.isSidewhite()) {
            p1.movePiece();
        } else {
            p2.movePiece();
        }
    }
/*
    public ChessPiece isLocationOccupied(int x, int y) {

        for (int i = 0; i < p1.arrayList.size(); i++) { // arrayList defined in player class
            if (x == arrayList[i].getX() && y == arrayList[i].getY()) {
                return arrayList[i];
            }
        }
        for (int i = 0; i < p2.arrayList.size(); i++) { // arrayList defined in player class
            if (x == arraylist[i].getX() && y == arraylist[i].getY()) {
                return arrayList[i];
            }
        }
        return null;
    }
    */

    //waiting for the arrayList from player class


    /*
    void analysis() { //method called in above
        //check if king in danger, print check

     }
     */
}