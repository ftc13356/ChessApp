import javafx.application.Application;
import javafx.application.Platform;

import java.util.ArrayList;

class Board {

    private Player p1;
    private Player p2;
    private boolean stalemate = false;

    private final static boolean usefxgui = true;

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

    public Board(boolean p1SideWhite, boolean isHuman1, boolean p2SideWhite, boolean isHuman2) {
        if(isHuman1==true){
            p1 = new Human(p1SideWhite, this);
        } else{
            p1 = new Computer(p1SideWhite, this);
        }

        if(isHuman2==true){
            p2 = new Human(p2SideWhite, this);
        } else{
            p2 = new Computer(p2SideWhite, this);
        }
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

    public void start() {
        printBoard();
        if (usefxgui) {
            Platform.runLater(() -> gui.drawBoard(this));
        }

        int turn = 0;
        while (true) {

            if (turn % 2 == 0) {
                System.out.println("Move " + ((turn / 2) + 1));
                System.out.println("It is the " + (p1.sideWhite ? "white" : "black") + " side's turn");
                p1.movePiece();
            } else {
                System.out.println("It is the " + (p2.sideWhite ? "white" : "black") + " side's turn");
                p2.movePiece();
            }

            printBoard();
            if (usefxgui) {
                Platform.runLater(() -> gui.drawBoard(this));
            }

            if (checkmate(p1)) {
                System.out.println((p1.sideWhite ? "Black" : "White") + " side wins");
                break;
            } else if (checkmate(p2)) {
                System.out.println((p2.sideWhite ? "Black" : "White") + " side wins");
                break;
            }

            if (p1.pieceList.size() == 1 && p1.pieceList.get(0) instanceof King
                    && p2.pieceList.size() == 1 && p2.pieceList.get(0) instanceof King) {
                System.out.println("Draw (2 Kings Left)");
                break;
            }

            if (stalemate || stalemate(p1) || stalemate(p2)) {
                System.out.println("Stalemate");
                break;
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

    public boolean checkMove(int x, int y, Player player,ChessPiece piece) {
        // false means is in danger, true means safe
        int[] start_pos=piece.getLocation();
        ChessPiece start_piece=null;
        if(isLocationOccupied(x,y)!=null&&isLocationOccupied(x,y).getPlayer().isSidewhite()!=piece.getPlayer().isSidewhite()){
            start_piece=isLocationOccupied(x,y);
            remove(start_piece);
        }
        piece.setLocation(x,y);
        if(getP1().isSidewhite()==player.isSidewhite()){
            player=getP2();
        }
        else{
            player=getP1();
        }
        for (int i = 0; i < player.pieceList.size(); i++) { // arrayList defined in player class
            ArrayList<Location> moves=player.pieceList.get(i).getLegalMoves();
            for(int j=0;j<moves.size();j++){
                if(moves.get(j).getLocation()[0]==piece.getPlayer().getKing().getLocation()[0]&&moves.get(j).getLocation()[1]==piece.getPlayer().getKing().getLocation()[1]){
                    piece.setLocation(start_pos[0],start_pos[1]);
                    if(start_piece!=null){
                        player.pieceList.add(start_piece);

                    }
                    return false;
                }
            }
        }
        piece.setLocation(start_pos[0],start_pos[1]);
        if(start_piece!=null){
            player.pieceList.add(start_piece);

        }
        return true;
    }

    public boolean checkmate(Player player){
        if(!checkMove(player.getKing().getLocation()[0],player.getKing().getLocation()[1],player,player.getKing())) {
            for (int i = 0; i < player.pieceList.size(); i++) {
                for (int j = 0; j < player.pieceList.get(i).getLegalMoves().size(); j++) {
                    if (checkMove(player.pieceList.get(i).getLegalMoves().get(j).getLocation()[0], player.pieceList.get(i).getLegalMoves().get(j).getLocation()[1], player, player.pieceList.get(i))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean stalemate(Player player) {
        //if not in check, check all pieces, if all legal moves move return false, stalemate
        if (!checkMove(player.getKing().getLocation()[0],player.getKing().getLocation()[1],player,player.getKing())) {
            return false;
        }
        for (ChessPiece piece : player.pieceList) {
            for (Location loc : piece.getLegalMoves()) {
                if (piece.testMove(loc.getLocation()[0],loc.getLocation()[1])) {
                    return false;
                }
            }
        }
        stalemate = true;
        return true;
    }

    public void remove(ChessPiece piece){
        if(piece.getPlayer().isSidewhite()!=p1.isSidewhite()){
            p2.remove(piece);
        }
        else{
            p1.remove(piece);
        }
    }
}