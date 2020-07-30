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
        Location moveLocation=new Location();
        moveLocation.setLocation(x,y);
        ArrayList<Location> moves= this.getLegalMoves();
        for(int i=0;i<moves.size();i++){
            if(moveLocation==moves.get(i)){
                this.setLocation(x,y);
                return true;
            }
        }
        return false;
    }
}
/*        if isLocationOccupied=True
return try again
if move is legal=true
then move piece to place user specified
 */
//    }
//}