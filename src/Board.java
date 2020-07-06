//import randomizer
​
class Board {
    Player p1;
    Player p2;
    int p1Type = 0; // 0 human (default), 1 computer
    int p2Type = 0; // 0 human (default), 1 computer
    int p1Color = 0; // 0 white (default), 1 black
    int p2Color = 0; // 0 white (default), 1 black
    int p1Checked = 0; // 0 not checked (default), 1 checked
    int p2Checked = 0; // 0 not checked default), 1 checked
​

    //Player class will provide way to read role and color inputed
    public Board(Player player1, Player player2) {
        p1 = player1;
        p2 = player2;
        p1Role = p1.getRole();
        //player1.initialize();
        //player2.initialize();
​
    }

    void start() {
        //who is which color
        // player type (human, computer)
        // white player go first
        // assign p1/p2 Color = 0 for white
        // assign p1/p2 Color = 1 for black
        // white player move first check if human or computer type
​
    }

    void humanPlayerMove(Player currentPlayer) {
        // am I checked, if so move king. If can move p1/p2 Checked = 0 else print checkmate, end game
        // ask which piece & where,
        // legal/illegal, if illegal ask again
        // check if checking opponent. if so print check, p1/p2 checked = 1
        // check if capturing, if so remove captured piece
        // set current location after validation
        // next player turn
    }

    void computerPlayerMove(Player currentPlayer) {
        // am I checked, if so move king. If can move p1/p2 Checked = 0 else print checkmate, end game
        // pick a piece(randomizer)
        // generate new location
        // check if checking opponent. if so print check, p1/p2 checked = 1
        // check if capturing, if so remove captured piece
        // set current location after validation
        // next player turn
    }

    void analysis() { //method called in above
        //check if king in danger, print check
    }
​
        ​
}