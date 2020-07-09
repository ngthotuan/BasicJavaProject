package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main1 extends Application {
    private Button btn1;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello world!");
        StackPane layout = new StackPane();
        btn1 = new Button("Say Hello!");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(event);
            }
        });
        layout.getChildren().add(btn1);
        Scene scene = new Scene(layout, 200, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
