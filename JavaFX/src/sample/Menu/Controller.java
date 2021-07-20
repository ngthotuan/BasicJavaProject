package sample.Menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;


public class Controller {
    public void actionClose(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }
}
