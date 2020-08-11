import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Human extends Player{
    public static List listterms = new ArrayList();
    public static int[] arrayterms = {0,0};

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
            if (sideWhite==true){
                System.out.println("It is the white side's turn");
            }
            else {
                System.out.println("It is the black side's turn");
            }

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
                        "Please Enter Your Move (ex. a3)", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    start = startField.getText();
                    end = endField.getText();
                    System.out.println(start);
                    System.out.println(end);
                    break;
                } else {
                    continue;
                }
            }
            String letter = start.substring(0, 1);
            String number = start.substring(1);
            String endletter = end.substring(0, 1);
            String endnumber = end.substring(1);

            //Convert the inputs to [x, y] coordinates
            int number1 = Integer.parseInt(number);
            number1 = number1;
            int letternumber = convertToCoordinates(letter);
            System.out.println(letternumber);
            System.out.println(number1);
            int endnumber2 = Integer.parseInt(endnumber);
            endnumber2 = endnumber2;
            int endletternumber = convertToCoordinates(endletter);
            System.out.println(endletternumber);
            System.out.println(endnumber2);
            ChessPiece chosenPiece = board1.isLocationOccupied(letternumber, number1);
            System.out.println(chosenPiece);
            if (chosenPiece == null) {
                System.out.println("There is no piece at the chosen square. Please input again.");
            }
            Location chosenMove = new Location(endletternumber, endnumber2);
            if (chosenPiece.getPlayer().isSidewhite()==this.isSidewhite() && chosenPiece.move(endletternumber, endnumber2)) {
                chosenPiece.setLocation(endletternumber, endnumber2);
                break;
            } else {
                System.out.println("The move is not legal. Please input again.");
            }
        }

    }


}
