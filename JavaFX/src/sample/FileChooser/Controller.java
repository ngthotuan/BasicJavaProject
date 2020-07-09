package sample.FileChooser;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    private ImageView imgView;
    @FXML
    private AnchorPane sence;

    private FileChooser fileChooser;
    public void OpenFile(){
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images only", "*.jpg", "*.png"));
        File file = fileChooser.showOpenDialog(sence.getScene().getWindow());
        if(file != null){
            System.out.println(file.getAbsolutePath());
            Image image = new Image(file.toURI().toString());
            imgView.setImage(image);
        }
    }

}
