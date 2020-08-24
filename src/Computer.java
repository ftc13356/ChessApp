import java.util.Random;

public class Computer extends Player{

    private final int computerMoveDelay = 500;
    private Random rand = new Random();

    public Computer(boolean sidewhite, Board board) {
        super(sidewhite,board);
    }

    @Override
    public void movePiece() {
        try { Thread.sleep(computerMoveDelay); } catch (InterruptedException e) { e.printStackTrace(); }
        while (true) {
            int pieceIndex = rand.nextInt(pieceList.size());
            ChessPiece chosenPiece = pieceList.get(pieceIndex);
            if (chosenPiece.getLegalMoves().size()>0) {
                int chosenMove = rand.nextInt(chosenPiece.getLegalMoves().size());
                String coordinates = chosenPiece.getLegalMoves().get(chosenMove).toString();
                String xstring = coordinates.substring(0, 1);
                String ystring = coordinates.substring(2,3);
                int x = Integer.parseInt(xstring);
                int y = Integer.parseInt(ystring);
                if(chosenPiece.move(x,y)){
                    break;
                } else {
                    if (board1.stalemate(this)) {
                        break;
                    }
                }
            }
        }
    }
}
