package sample.TableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDetailController {
    @FXML
    private Label txtId;
    @FXML
    private Label txtName;
    @FXML
    private Label txtEmail;
    @FXML
    private Label txtAge;

    public void setValue(Student student){
        try {
            txtId.setText(String.valueOf(student.getId()));
            txtName.setText(student.getName());
            txtEmail.setText(student.getEmail());
            txtAge.setText(String.valueOf(student.getAge()));
        } catch (Exception e){
            System.out.println(getClass().getName());
            System.err.println(e.getCause());
        }
    }

    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("views.fxml"));
        stage.setScene(new Scene(parent));
    }
}
