package sample.WebView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField addressBar;
    @FXML
    private WebView webView;
    private WebEngine engine;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();

        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if(newValue.equals(Worker.State.SUCCEEDED)){
                    addressBar.setText(engine.getLocation());
                }
            }
        });
    }
    public void keyHandle(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            String address = addressBar.getText();
            if(!address.startsWith("http")){
                address = "http://" + address;
            }
            engine.load(address);
        }
    }

    public void back(ActionEvent event){
        if(engine.getHistory().getCurrentIndex() > 0){
            engine.getHistory().go(-1);
        }
    }

    public void forward(ActionEvent event){
        if(engine.getHistory().getCurrentIndex() + 1 < engine.getHistory().getEntries().size()){
            engine.getHistory().go(1);
        }
    }
}
