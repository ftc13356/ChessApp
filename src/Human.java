import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Human extends Player{
    public static List listterms = new ArrayList();
    public static int[] arrayterms = {0,0};

    public Human(boolean sideWhite, Board board) {
        super(sideWhite, board);
    }

    public int convertToCoordinates(String letter) {
        if (letter=="a")
            return 0;
        else if (letter.equals("b"))
            return 1;
        else if (letter.equals("c"))
            return 2;
        else if (letter.equals("d"))
            return 3;
        else if (letter.equals("e"))
            return 4;
        else if (letter.equals("f"))
            return 5;
        else if (letter.equals("g"))
            return 6;
        else if (letter.equals("h"))
            return 7;
        else
            return 8;
    }

    public void movePiece() {
        // Create a prompt and get an input from the human player
        JTextField startField = new JTextField(5);
        JTextField endField = new JTextField(5);
        String start,end;

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Coordinates of the Piece"));
        myPanel.add(startField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Where the Piece Should Move To"));
        myPanel.add(endField);
        while (true) {
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter Your Move", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                start = startField.getText();
                end = endField.getText();
                System.out.println(start);
                System.out.println(end);
                break;
            }
            else {
                continue;
            }
        }
        String letter = start.substring(0,1);
        char number = start.charAt(2);
        int number1 = number-49;
        System.out.println("letter");
        System.out.println(letter);
        System.out.println("number");
        System.out.println(number1);
        //Convert the inputs to [x, y] coordinates
        int letternumber = convertToCoordinates(letter);
        ChessPiece chosenPiece = board1.isLocationOccupied(letternumber, number1);
        if (chosenPiece==null){
            System.out.println("There is no piece at the chosen square. Please input again.");
            movePiece();
        }
        List legalMoves = chosenPiece.getLegalMoves();
        ArrayList chosenMove = new ArrayList();
        chosenMove.add(letternumber);
        chosenMove.add(number1);
        if (legalMoves.contains(chosenMove)) {
            chosenPiece.setLocation(letternumber, number1);
        }
        else
            System.out.println("The move is not legal. Please input again.");
            movePiece();



    }
    //public static void main(String[] args){
//        movePiece();
//    }

}
