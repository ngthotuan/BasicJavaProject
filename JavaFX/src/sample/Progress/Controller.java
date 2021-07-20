package sample.Progress;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;


public class Controller {
    @FXML
    private Label status;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;

    DoWork task = null;
    public void start(){
        task = new DoWork();
        status.textProperty().bind(task.messageProperty());
        progressBar.progressProperty().bind(task.progressProperty());
        progressIndicator.progressProperty().bind(task.progressProperty());

        new Thread(task).start();
    }
    public void cancel(){
        if(task != null){
            task.cancel();
            status.textProperty().unbind();
            status.setText("Ready");
            progressBar.progressProperty().unbind();
            progressBar.progressProperty().setValue(0);
            progressIndicator.progressProperty().unbind();
            progressIndicator.progressProperty().setValue(0);
        }
    }
}
class DoWork extends Task<Void>{

    @Override
    protected Void call() throws Exception {
        for(int i = 0; i < 10; i++){
            if(isCancelled()){
                updateMessage("Canceled!");
                break;
            }
            updateProgress(i+1, 10);
            updateMessage("Loading");
            Thread.sleep(500);
        }
        updateMessage("Finished");
        return null;
    }
}
