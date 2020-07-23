import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Human extends Player{
    public static List listterms = new ArrayList();
    public static int[] arrayterms = {0,0};

    public static Player player = new Player(true, board1) {
        @Override
        public void movePiece() {

        }
    };
    public static Player human1 = new Player(true, board1) {
        @Override
        public void movePiece() {

        }
    };
    public static Player human2 = new Player(true,board1) {
        @Override
        public void movePiece() {

        }
    };

    public Human(boolean sidewhite, Board board) {
        super(sidewhite,board);

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
        String number = start.substring(1);
        System.out.println(letter);
        System.out.println(number);
        //Convert the inputs to [x, y] coordinates
        int number1 = Integer.parseInt(number);
        int letternumber = 0;


    }
    //public static void main(String[] args){
//        movePiece();
//    }

}
