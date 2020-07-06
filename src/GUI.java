import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.*;

/**
 * This is the Graphical User Interface for the ChessApp
 *
 * @author Aiden Ma
 * @version 1.0
 */
public class GUI {
    private Board board;

    public GUI(Board chessBoard) {
        board = chessBoard;
    }

    private void drawBoard() {
        //draw a board that is 8 squares by 8 squares
        //alternating between black and white squares
        //draw numbers(1-8) on vertical
        //draw letters(a-h) on horizontal
        //call Player1.draw(g2?); (@sai, write function)
        //call Player2.draw(g2?); (@sai, write function)
    }

    public void draw() {
        drawBoard();
        //Player1.draw(g2);
        //Player2.draw(g2);
    }

}
