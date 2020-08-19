import javafx.application.Application;
import javafx.application.Platform;

import java.util.ArrayList;

class Board {
    private Player p1;
    private Player p2;

    private final static boolean usefxgui = true;

    //Player class will provide way to read role and color inputted
    public static void main(String[] args){
        if (usefxgui) {
            new Thread(() -> Application.launch(gui.class)).start();
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }

        Board board = new Board();
        board.start();
    }

    public Board() {
        p1 = new Human(true, this);
        p2 = new Human(false, this);
    }

    public Board(boolean p1SideWhite, boolean p2SideWhite) {
        p1 = new Computer(p1SideWhite, this);
        p2 = new Computer(p2SideWhite, this);
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
            if (usefxgui) {
                Platform.runLater(() -> gui.drawBoard(this));
            }

            if(turn%2==0){
                p1.movePiece();
            }
            else{
                p2.movePiece();
            }
            if(Checkmate(p1)){
                System.out.println("White side(p1) wins");break;
            }
            else if(Checkmate(p2)){
                System.out.println("Black side(p2) wins");break;
            }
            turn++;
        }
    }

    public void printBoard(){
        for(int i=8;i>0;i--) {
            System.out.println("_________________________________________________");
            for(int j=1;j<9;j++){
                System.out.print("|");
                ChessPiece piece = this.isLocationOccupied(j, i);
                if(piece == null) {
                    System.out.print("     ");
                }
                else {

                    if (piece.getPlayer().isSidewhite() == true) {
                        System.out.print(" W-" + piece.abbreviation() + " ");

                    } else {
                        System.out.print(" B-" + piece.abbreviation() + " ");
                    }

                }
            }
            System.out.print("| " + i);
            System.out.print("\n");
        }
        System.out.println("_________________________________________________");
        System.out.println("   a     b     c     d     e     f     g     h");
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

    public boolean checkMove(int x, int y, Player player,ChessPiece piece) {//false means is in danger, true means safe
        int[] start_pos=piece.getLocation();
        piece.setLocation(x,y);
        if(getP1().isSidewhite()==player.isSidewhite()){
            player=getP1();
        }
        else{
            player=getP2();
        }
        for (int i = 0; i < player.pieceList.size(); i++) { // arrayList defined in player class
            ArrayList<Location> moves=player.pieceList.get(i).getLegalMoves();
            for(int j=0;j<moves.size();j++){
                if(moves.get(j).getLocation()[0]==piece.getPlayer().getKing().getLocation()[0]&&moves.get(j).getLocation()[1]==piece.getPlayer().getKing().getLocation()[1]){
                    return false;
                }
            }
        }
        piece.setLocation(start_pos[0],start_pos[1]);
        return true;
    }
    public boolean Checkmate(Player player){
        if(!checkMove(player.getKing().getLocation()[0],player.getKing().getLocation()[1],player,player.getKing())){
            for(int i=0;i<player.getKing().getLegalMoves().size();i++){
                if(checkMove(player.getKing().getLegalMoves().get(i).getLocation()[0],player.getKing().getLegalMoves().get(i).getLocation()[1],player,player.getKing())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void remove(ChessPiece piece){
        if(piece.getPlayer().isSidewhite()!=p1.isSidewhite()){
            p2.remove(piece);
        }
        else{
            p1.remove(piece);
        }
    }

    /*
    void analysis() { //method called in above
        //check if king in danger, print check

     }
     */
}