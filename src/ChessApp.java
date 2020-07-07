import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.*;

public class ChessApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        Pane gamePane = new Pane();

        Label hi = new Label("hello everyone");
        gamePane.getChildren().addAll(hi);

        mainPane.setCenter(gamePane);
        Scene scene = new Scene(mainPane, 500, 500);
        primaryStage.setTitle("Chess App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
