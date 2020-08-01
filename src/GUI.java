/*
import com.sun.javafx.geom.Line2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.border.StrokeBorder;

*/
/**
 * This is the Graphical User Interface for the ChessApp
 *
 * @author Aiden Ma
 * @version 1.0
 *//*

public class GUI extends Application {

    // FIELDS
    final private int TOPLEFTX = 40;
    final private int TOPLEFTY = 40;
    final private int SIDEOFSQUARE = 70;
    final private int NUMOFSQUARESPERSIDE = 8;

    private Board board;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainPane = new BorderPane();
        Pane gamePane = new Pane();

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
        Line border1 = new Line(40,40,40,600 );
        Line border2 = new Line(40,40,600,40 );
        Line border3 = new Line(600,40,600,600 );
        Line border4 = new Line(40,600,600,600 );
        border1.setStrokeWidth(x);
        border2.setStrokeWidth(x);
        border3.setStrokeWidth(x);
        border4.setStrokeWidth(x);

        // draws numbering/lettering
        // lettering
        Text letteringTop = new Text(67, 30, "a         b        c        d        e         f        g       h");
        Text letteringBottom = new Text(67, 630, "a         b        c        d        e         f        g       h");
        // numbering


        letteringTop.setFont(Font.font(25));
        letteringBottom.setFont(Font.font(25));


        gamePane.getChildren().addAll(border1, border2, border3, border4, letteringTop, letteringBottom);






        mainPane.setCenter(gamePane);
        Scene scene = new Scene(mainPane, 640, 640);
        stage.setTitle("Chess App");
        stage.setScene(scene);
        stage.show();
    }

//    public void draw() {
//        drawBoard();
//        //Player1.draw(g2);
//        //Player2.draw(g2);
//    }

}
*/
