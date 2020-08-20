import java.util.ArrayList;

public abstract class ChessPiece {

    private Location currentLocation;
    private Board board;
    private Player player;
    public  String whitePath;
    public  String blackPath;


    public ChessPiece(int x, int y, Board boardRef, Player player) {
        currentLocation = new Location(x, y);
        board = boardRef;
        this.player = player;
    }

    public void setLocation(int x, int y) {
        currentLocation.setLocation(x, y);
    }

    public int[] getLocation() {
        return currentLocation.getLocation();
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract ArrayList<Location> getLegalMoves();

    public boolean move(int x, int y) {
        ArrayList<Location> moves = this.getLegalMoves();

        //Go through each legal move
        for (int i = 0; i < moves.size(); i++) {
            //Check if the move is the legal move.
            if (moves.get(i).getLocation()[0] == x && moves.get(i).getLocation()[1] == y&&getBoard().checkMove(x,y,getPlayer(),this)) {

                //THis is the move.. now check.. if the taget location is occupied and there is oppoents at target location
                if (getBoard().isLocationOccupied(x, y) != null && getBoard().isLocationOccupied(x, y).getPlayer().isSidewhite() != this.getPlayer().isSidewhite()) {

                    //
                    getBoard().remove(getBoard().isLocationOccupied(x, y));
                }



                if (isPromoteLegal() == true) {

                    getBoard().remove(this);
                    Queen promoteQueen = new Queen(x, y, this.getBoard(), this.getPlayer());
                    this.getPlayer().add(promoteQueen);
                } else {
                    this.setLocation(x, y);
                }

                return true;
            }
        }
        return false;
    }

    public abstract String abbreviation();

    @Override
    public String toString() {
        String side = player.sideWhite ? "White " : "Black ";
        return side + getClass().getName() + " at " + currentLocation;
    }

    public boolean isPromoteLegal() {

        if (this instanceof Pawn == true && ((getLocation()[1] == 7 && this.getPlayer().isSidewhite() == true)|| (getLocation()[1] == 2 && this.getPlayer().isSidewhite() == false))) {

            return true;
        }

        return false;
    }
}