import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Human extends Player{
    public static List listterms = new ArrayList();
    public static int[] arrayterms = {0,0};

    public static Player player = new Player() {};
    public static Player human1 = new Player() {};
    public static Player human2 = new Player() {};
    public static Board board = new Board(human1, human2);

    public static Pawn wpawn1 = new Pawn(0, 1, board, player);
    public static Pawn wpawn2 = new Pawn(1,1, board, player);
    public static Pawn wpawn3 = new Pawn(2,1, board, player);
    public static Pawn wpawn4 = new Pawn(3,1, board, player);
    public static Pawn wpawn5 = new Pawn(4,1, board, player);
    public static Pawn wpawn6 = new Pawn(5,1, board, player);
    public static Pawn wpawn7 = new Pawn(6,1, board, player);
    public static Pawn wpawn8 = new Pawn(7,1, board, player);
    public static Rook wrook1 = new Rook(0,0, board, player);
    public static Rook wrook2 = new Rook(0,7, board, player);
    public static Knight wknight1 = new Knight(1,0, board, player) {
        @Override
        public void move(int x, int y) {

        }
    };
    public static Knight wknight2 = new Knight(6,0, board, player) {
        @Override
        public void move(int x, int y) {
        }
    };
    public static Bishop wbishop1 = new Bishop(2,0, board, player);
    public static Bishop wbishop2 = new Bishop(5,0, board, player);
    public static Queen wqueen = new Queen(3,0, board, player);
    public static King wking = new King(4,0, board, player);

    public Human(boolean sidewhite) {
        this.sideWhite = sidewhite;
        this.isHuman = true;

        };


    public static void convertToCoordinates(String letter, int number) {
        List listterms1 = new ArrayList();
        if (letter == "a")
            listterms1.add(0);
            arrayterms[0] = 0;
        if (letter == "b")
            listterms1.add(1);
            arrayterms[0] = 1;
        if (letter == "c")
            listterms1.add(2);
            arrayterms[0] = 2;
        if (letter == "d")
            listterms1.add(3);
            arrayterms[0] = 3;
        if (letter == "e")
            listterms1.add(4);
            arrayterms[0] = 4;
        if (letter == "f")
            listterms1.add(5);
            arrayterms[0] = 5;
        if (letter == "g")
            listterms1.add(6);
            arrayterms[0] = 6;
        if (letter == "h")
            listterms1.add(7);
            arrayterms[0] = 7;
        listterms1.add(number-1);
        arrayterms[1] = number-1;
        listterms = listterms1;
    }
    public static void checkLocations() {
        if (wpawn1.getLocation()==arrayterms)
            wpawn1.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn2.getLocation()==arrayterms)
            wpawn2.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn3.getLocation()==arrayterms)
            wpawn3.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn4.getLocation()==arrayterms)
            wpawn4.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn5.getLocation()==arrayterms)
            wpawn5.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn6.getLocation()==arrayterms)
            wpawn6.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn7.getLocation()==arrayterms)
            wpawn7.setLocation(arrayterms[0], arrayterms[1]);
        if (wpawn8.getLocation()==arrayterms)
            wpawn8.setLocation(arrayterms[0], arrayterms[1]);
        if (wknight1.getLocation()==arrayterms)
            wknight1.setLocation(arrayterms[0], arrayterms[1]);
        if (wknight2.getLocation()==arrayterms)
            wknight2.setLocation(arrayterms[0], arrayterms[1]);
        //if (wbishop1.getLocation()==arrayterms)
        //    wbishop1.setLocation(arrayterms[0], arrayterms[1]);
        //if (wbishop2.getLocation()==arrayterms)
        //    wbishop2.setLocation(arrayterms[0], arrayterms[1]);
        if (wrook1.getLocation()==arrayterms)
            wrook1.setLocation(arrayterms[0], arrayterms[1]);
        if (wrook2.getLocation()==arrayterms)
            wrook2.setLocation(arrayterms[0], arrayterms[1]);
        if (wqueen.getLocation()==arrayterms)
            wqueen.setLocation(arrayterms[0], arrayterms[1]);
        if (wking.getLocation()==arrayterms)
            wking.setLocation(arrayterms[0], arrayterms[1]);
    }



    public static void movePiece() {
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
        convertToCoordinates(letter, number1);


    }

    public static void main(String[] args){
        movePiece();
    }

}
