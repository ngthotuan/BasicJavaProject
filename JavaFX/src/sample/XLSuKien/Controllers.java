package sample.XLSuKien;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controllers implements EventHandler<MouseEvent> {
    @FXML
    private TextField value;
    @FXML
    private Button btnClick;

    public Controllers(){
        try{
            btnClick.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(value.getText());
                }
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void showInfo(ActionEvent event){
        System.out.println(value.getText());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event);
        if(event.getSource() == btnClick){
            System.out.println(value.getText());
        }
    }
}
