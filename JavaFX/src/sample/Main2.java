package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {
    private Stage window;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //scene 1
        VBox layout1 = new VBox();
        Label label = new Label("welcome to howkteam!");
        Button button = new Button("Go to course");
        button.setOnAction(event -> {
            window.setScene(scene2);
        });
        layout1.getChildren().addAll(label, button);
        scene1 = new Scene(layout1, 200, 300);

        //scene 2
        StackPane layout2 = new StackPane();
        Button button2 = new Button("Go back");
        button2.setOnAction(event -> {
            window.setScene(scene1);
        });
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300,200);

        window.show();
        window.setScene(scene1);
    }
}
