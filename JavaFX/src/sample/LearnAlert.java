package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class LearnAlert extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world!");
        StackPane layout = new StackPane();
        Button btn1 = new Button("Close");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Confirmation");
                confirm.setHeaderText("Confirmation header text");
                confirm.setContentText("Choose your option");

                ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
                ButtonType btnCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                confirm.getButtonTypes().setAll(btnYes, btnNo, btnCancel);
                Optional<ButtonType> optional = confirm.showAndWait();
                if(optional.get() == btnYes){
                    System.out.println("code for yes");
                } else if(optional.get().getButtonData() == ButtonBar.ButtonData.NO){
                    System.out.println("code for no");
                } else {
                    System.out.println("code for cancel");
                }

                String message = optional.get().getText();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
                alert.showAndWait();
                primaryStage.close();
            }
        });
        layout.getChildren().add(btn1);
        Scene scene = new Scene(layout, 200, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(Event::consume);
    }
}
