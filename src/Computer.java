import java.util.Random;

public class Computer extends Player{
    public Computer(boolean sidewhite, Board board) {
        super(sidewhite,board);
    }

    @Override
    public void movePiece() {
        while (true) {
            Random rand = new Random();
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
                }
            }
        }
    }
}
