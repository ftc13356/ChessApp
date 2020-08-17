import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.management.StandardEmitterMBean;
import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * This is the Graphical User Interface for the ChessApp
 *
 * @author Aiden Ma
 * @version 1.0
 */

public class gui extends Application {

    // FIELDS
    final private int TOPLEFTX = 40;
    final private int TOPLEFTY = 40;
    final private int SIDEOFSQUARE = 70;
    final private int NUMOFSQUARESPERSIDE = 8;

    private static BorderPane mainPane;
    private static Pane gamePane;
    private Board board;

    public static int hi = 0;

    private static boolean Debug = true;

    @Override
    public void start(Stage stage) throws Exception {

        mainPane = new BorderPane();
        gamePane = new Pane();
        board = new Board();

        // draws chess board with alternating colored squares
        for (int row = 0; row < NUMOFSQUARESPERSIDE; row++) {

            for (int col = 0; col < NUMOFSQUARESPERSIDE; col++) {

                Rectangle chessSpace = new Rectangle(TOPLEFTX + SIDEOFSQUARE * col, TOPLEFTY + SIDEOFSQUARE * row, SIDEOFSQUARE, SIDEOFSQUARE);

                if ((row + col) % 2 != 0) {
                    // darker brown
                    chessSpace.setFill(Color.rgb(109, 83, 56));
                } else {
                    // beige
                    chessSpace.setFill(Color.BEIGE);
                }
                gamePane.getChildren().addAll(chessSpace);

            }
        }
        int x = 3;
        Line border1 = new Line(TOPLEFTX, TOPLEFTY, TOPLEFTX, 600);
        Line border2 = new Line(TOPLEFTX, TOPLEFTY, 600, TOPLEFTY);
        Line border3 = new Line(600, TOPLEFTY, 600, 600);
        Line border4 = new Line(TOPLEFTX, 600, 600, 600);
        border1.setStrokeWidth(x);
        border2.setStrokeWidth(x);
        border3.setStrokeWidth(x);
        border4.setStrokeWidth(x);

        // draws numbering/lettering
        // lettering
        Text letteringTop = new Text(67, 30, "a         b        c        d        e         f        g       h");
        Text letteringBottom = new Text(67, 630, "a         b        c        d        e         f        g       h");
        // numbering
        for (int i = 0; i <= NUMOFSQUARESPERSIDE; i++) {

            Text numbering = new Text(15, 73 * i, i + 0 + "");
            numbering.setFont(Font.font(20));
            gamePane.getChildren().add(numbering);
        }

        for (int i = 0; i <= NUMOFSQUARESPERSIDE; i++) {

            Text numbering = new Text(615, 73 * i, i + 0 + "");
            numbering.setFont(Font.font(20));
            gamePane.getChildren().add(numbering);
        }

        letteringTop.setFont(Font.font(25));
        letteringBottom.setFont(Font.font(25));

        drawBoard(board);

        gamePane.getChildren().addAll(border1, border2, border3, border4, letteringTop, letteringBottom);

        mainPane.setCenter(gamePane);
        Scene scene = new Scene(mainPane, 640, 640);
        stage.setTitle("Chess App");
        stage.setScene(scene);
        stage.show();

        System.out.println(getPlayerMove()[0]);
    }

    public static String[] getPlayerMove() {

        Stage stage2 = new Stage();

        GridPane gridPane = new GridPane();
        Scene scene2 = new Scene(gridPane, 450, 120);

        Button whereToMove = new Button("MOVE");
        TextField startingPos = new TextField();
        TextField moveToPos = new TextField();
        Label whereIsPiece = new Label("Enter the square the piece you want to move is on(e.g a5): ");
        Label moveToWhere = new Label("Enter the square you want to move the piece to(e.g b5): ");
        gridPane.add(whereToMove, 1, 4);

        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(6);
        gridPane.setVgap(6);

        whereToMove.setOnAction(e -> {
            stage2.close();
        });

        gridPane.add(whereIsPiece, 0, 0);
        gridPane.add(startingPos, 1, 0);
        gridPane.add(moveToWhere, 0, 1);
        gridPane.add(moveToPos, 1, 1);

        GridPane.setHalignment(whereToMove, HPos.RIGHT);
        gridPane.setAlignment(Pos.CENTER);

        stage2.setTitle("Where to move");
        stage2.setScene(scene2);
        stage2.showAndWait();

        return new String[]{startingPos.getText(), moveToPos.getText()};
    }

    public static void drawBoard(Board board) {
        Player p1 = board.getP1();
        Player p2 = board.getP2();
        ArrayList<ChessPiece> pieceList1 = p1.pieceList;
        ArrayList<ChessPiece> pieceList2 = p2.pieceList;

        // draws chess pieces for both sides

        // WHITE
        for (ChessPiece piece : pieceList1) {
            String whichSide = "";

            int[] pieceCoordinate = piece.getLocation();

            if (piece.getPlayer().sideWhite) {
                whichSide = piece.whitePath;
            }
            ImageView pieceView = new ImageView("file:" + whichSide);
            if (Debug) {
                System.out.println("\tSide: " + whichSide);
            }
            int horizontalSquareNum = pieceCoordinate[0];
            int verticalSquareNum = pieceCoordinate[1];
            int squareSideLength = 70;
            int topLeftX = -20;
            int topLeftY = -30;

            pieceView.setX(horizontalSquareNum * squareSideLength + topLeftX);
            pieceView.setY(verticalSquareNum * squareSideLength + topLeftY);
            if (Debug) {
                System.out.println("X: " + pieceCoordinate[0] + " Y: " + pieceCoordinate[1]);
            }
            gamePane.getChildren().add(pieceView);

            if (Debug) {
                System.out.println("Coordinates: (" + pieceCoordinate[0] + "," + pieceCoordinate[1] + ")");
            }
        }

        for (ChessPiece piece : pieceList2) {
            String whichSide = "";

            int[] pieceCoordinate = piece.getLocation();

            if (!piece.getPlayer().sideWhite) {
                whichSide = piece.blackPath;
            }
            ImageView pieceView = new ImageView("file:" + whichSide);
            if (Debug) {
                System.out.println("\tSide: " + whichSide);
            }
            int horizontalSquareNum = pieceCoordinate[0];
            int verticalSquareNum = pieceCoordinate[1];
            int squareSideLength = 70;
            int topLeftX = -20;
            int topLeftY = -30;

            if (pieceCoordinate[1] == 7) {
                pieceView.setX(horizontalSquareNum * squareSideLength + topLeftX);
                pieceView.setY(verticalSquareNum * squareSideLength + -topLeftY);
            } else {
                pieceView.setX(horizontalSquareNum * squareSideLength + topLeftX);
                pieceView.setY((verticalSquareNum - 1) * squareSideLength + topLeftY);
            }
            if (Debug) {
                System.out.println("X: " + pieceCoordinate[0] + " Y: " + pieceCoordinate[1]);
            }

            gamePane.getChildren().add(pieceView);

            if (Debug) {
                System.out.println("Coordinates: (" + pieceCoordinate[0] + "," + pieceCoordinate[1] + ")");
            }
        }
//        }

    }
}