package sample.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controllers implements Initializable {
    @FXML
    ComboBox<String> comboBox;

    @FXML
    Label label;
    ObservableList<String> list = FXCollections.observableArrayList("C/C++", "Java", "Python");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(list);
    }
    public void comboBoxChanged(ActionEvent e){
        System.out.println(e);
        label.setText(comboBox.getValue());
    }

}
