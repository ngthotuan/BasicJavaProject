package sample.TreeView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controllers implements Initializable {
    @FXML
    private TreeView<String> treeView;

    public void showChildren(File file,TreeItem<String> parent){
        if(!file.isHidden())
        {
            parent.setExpanded(true);
            TreeItem<String> f = new TreeItem<>(file.getName());
            parent.getChildren().add(f);
            if(file.isDirectory()){
                for(File fi : Objects.requireNonNull(file.listFiles())){
                    showChildren(fi, f);
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>();
        File f = new File(System.getProperty("user.dir"));
        showChildren(f, root);

        treeView.setRoot(root);
        treeView.setShowRoot(false);
        treeView.showRootProperty();

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                System.out.printf("old value: %s => new value: %s\n", oldValue, newValue);
            }
        });
    }
}
