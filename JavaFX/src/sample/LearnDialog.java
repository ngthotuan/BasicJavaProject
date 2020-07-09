package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LearnDialog extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Dialog
        Dialog<List<String>> dialog = new Dialog<>();
        dialog.setTitle("Login");
        dialog.setHeaderText("Enter user name, password and press Login");
        // Button
        ButtonType btnLogin = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnLogin, ButtonType.CANCEL);
        //Layout
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50));
        Label usernameLabel = new Label("Username: ");
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("username here...");
        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password here...");
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameTextField, 1,0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1,1);
        //add layout to dialog
        dialog.getDialogPane().setContent(grid);

        // disable login if username empty
        Node nodeLogin = dialog.getDialogPane().lookupButton(btnLogin);
        nodeLogin.setDisable(true);
        usernameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                nodeLogin.setDisable(newValue.trim().isEmpty());
            }
        });
        //custom return
        dialog.setResultConverter(new Callback<ButtonType, List<String>>() {
            @Override
            public List<String> call(ButtonType param) {
                if(param.getButtonData() == ButtonBar.ButtonData.OK_DONE){
                    List<String> list = new ArrayList<>();
                    list.add(usernameTextField.getText());
                    list.add(passwordField.getText());
                    return list;
                }
                return null;
            }
        });

        Optional<List<String>> optional = dialog.showAndWait();
        optional.ifPresent(System.out::println);
    }
}
