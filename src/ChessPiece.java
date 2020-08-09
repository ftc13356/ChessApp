import java.util.ArrayList;

public abstract class ChessPiece{

    private Location currentLocation;
    private Board board;
    private Player player;

    public ChessPiece(int x, int y, Board boardRef, Player player) {
        currentLocation = new Location(x,y);
        board = boardRef;
        this.player = player;
    }

    public void setLocation(int x, int y) {
        currentLocation.setLocation(x,y);
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
        ArrayList<Location> moves= this.getLegalMoves();
        for(int i=0;i<moves.size();i++){
            if(moves.get(i).getLocation()[0]==x&&moves.get(i).getLocation()[1]==y){
                if(getBoard().isLocationOccupied(x,y)!=null&&getBoard().isLocationOccupied(x,y).getPlayer().isSidewhite()!=this.getPlayer().isSidewhite()){
                    getBoard().remove(getBoard().isLocationOccupied(x, y));
                }
                this.setLocation(x,y);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String side = player.sideWhite ? "White " : "Black ";
        return side + getClass().getName() + " at " + currentLocation;
    }
}