package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL resource = getClass().getResource("../Views/StudentTable.fxml");
            Parent root = FXMLLoader.load(resource);
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NullPointerException e){
            System.err.println("Can't get resource file !!!");
            System.err.println(e.getMessage());
        } catch (LoadException e){
            System.err.println("LoadException");
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
