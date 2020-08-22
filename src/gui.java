import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This is the Graphical User Interface for the ChessApp
 *
 * @author Aiden Ma
 * @version 1.0
 */

public class gui extends Application {

    // FIELDS
    private final static int TOPLEFTX = 40;
    private final static int TOPLEFTY = 40;
    private final static int SIDEOFSQUARE = 70;
    private final static int NUMOFSQUARESPERSIDE = 8;

    private static BorderPane mainPane;
    private static Pane gamePane;

    private static boolean Debug = true;

    @Override
    public void start(Stage stage) throws Exception {

        mainPane = new BorderPane();
        gamePane = new Pane();

        redraw();

        mainPane.setCenter(gamePane);
        Scene scene = new Scene(mainPane, 640, 640);
        stage.setTitle("Chess App");
        stage.setScene(scene);
        stage.show();
    }

    public static void redraw() {

        gamePane.getChildren().clear();

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
        for (int i = 8; i >= 1; i--) {

            Text numbering = new Text(15, 640 - 70 * i, i + 0 + "");
            numbering.setFont(Font.font(20));
            gamePane.getChildren().add(numbering);
        }

        for (int i = 8; i >= 1; i--) {

            Text numbering = new Text(615, 640 - 70 * i, i + 0 + "");
            numbering.setFont(Font.font(20));
            gamePane.getChildren().add(numbering);
        }

        letteringTop.setFont(Font.font(25));
        letteringBottom.setFont(Font.font(25));

        gamePane.getChildren().addAll(border1, border2, border3, border4, letteringTop, letteringBottom);
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

        stage2.setTitle("Your Move");
        stage2.setScene(scene2);
        stage2.showAndWait();

        return new String[]{startingPos.getText(), moveToPos.getText()};
    }

    public static void drawBoard(Board board) {

        redraw();
        board.getP1().drawBoard(gamePane);
        board.getP2().drawBoard(gamePane);
    }
}