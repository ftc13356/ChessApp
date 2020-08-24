import javax.swing.*;
import java.util.ArrayList;

public class Human extends Player {

    public Human(boolean sideWhite, Board board) {
        super(sideWhite, board);
    }

    // testing only!!!
    public Human(boolean sideWhite, Board board, boolean emptyBoardTest, ArrayList<ChessPiece> pieces) {
        super(sideWhite,board,emptyBoardTest,pieces);
    }

    public int convertToCoordinates(String letter) {
        if (letter.equals("a"))
            return 1;
        else if (letter.equals("b"))
            return 2;
        else if (letter.equals("c"))
            return 3;
        else if (letter.equals("d"))
            return 4;
        else if (letter.equals("e"))
            return 5;
        else if (letter.equals("f"))
            return 6;
        else if (letter.equals("g"))
            return 7;
        else if (letter.equals("h"))
            return 8;
        else
            return 8;
    }

    public void movePiece() {
        while (true) {
            // Create a prompt and get an input from the human player
            JTextField startField = new JTextField(5);
            JTextField endField = new JTextField(5);
            String start, end;

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Coordinates of the Piece"));
            myPanel.add(startField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Where the Piece Should Move To"));
            myPanel.add(endField);
            while (true) {
                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        (sideWhite ? "White" : "Black") + ", Please Enter Your Move (ex. a3)",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    start = startField.getText();
                    end = endField.getText();
                    break;
                } else {
                    continue;
                }
            }


            if (!start.equals("castle")) {
                int number1, letternumber, endnumber2, endletternumber;
                try {
                    String letter = start.substring(0, 1);
                    String number = start.substring(1);
                    String endletter = end.substring(0, 1);
                    String endnumber = end.substring(1);

                    //Convert the inputs to [x, y] coordinates
                    number1 = Integer.parseInt(number);
                    letternumber = convertToCoordinates(letter);
                    endnumber2 = Integer.parseInt(endnumber);
                    endletternumber = convertToCoordinates(endletter);

                } catch (StringIndexOutOfBoundsException | NumberFormatException ex) {
                    System.out.println("Invalid Input. Please input again");
                    continue;
                }

                ChessPiece chosenPiece = board1.isLocationOccupied(letternumber, number1);
                if (chosenPiece == null) {
                    System.out.println("There is no piece at the chosen square. Please input again.");
                    continue;
                }
                Location chosenMove = new Location(endletternumber, endnumber2);
                if (((chosenPiece != null && chosenPiece.getPlayer().isSidewhite()) == this.isSidewhite()) && chosenPiece.move(endletternumber, endnumber2)) {
                    chosenPiece.move(endletternumber, endnumber2);
                    break;
                } else {
                    System.out.println("The move is not legal. Please input again.");
                }

            } else {
                Rook castleRook = null;
                for (ChessPiece piece : pieceList) {
                    if (piece instanceof Rook && piece.getLocation()[0] == 8) {
                        castleRook = (Rook) piece;
                    }
                }
                int y = sideWhite ? 1 : 8;
                if (getKing() != null && castleRook != null && canCastle // check pieces
                        && board1.isLocationOccupied(6,y) == null && board1.isLocationOccupied(7,y) == null // check spaces occupied
                        && board1.checkMove(getKing().getLocation()[0],getKing().getLocation()[1],this,getKing()) // check if in check
                        && board1.checkMove(7,y,this,getKing())) { // check final position for danger
                    getKing().setLocation(7,y);
                    castleRook.setLocation(6,y);
                    break;
                } else {
                    System.out.println("Castle is not legal");
                }
            }
        }
    }
}