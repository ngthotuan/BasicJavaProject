package sample.LineChart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("views.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NullPointerException e){
            System.err.println("Can't get resource file !!!");
            System.err.println(e.getMessage());
        } catch (LoadException e){
            System.err.println("LoadException");
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
