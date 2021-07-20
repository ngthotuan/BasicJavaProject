package sample.TableView;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> tableView;
    private ObservableList<Student> studentList;

    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TextField txtID, txtName, txtEmail, txtAge;

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnDetail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentList = FXCollections.observableArrayList(
                new Student(1,"Nguyễn Thọ Tuấn", "nttuan@gmail.com", 21),
                new Student(2,"Châu Xuân Tuấn", "cxtuan@gmail.com", 20)
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        tableView.setItems(studentList);
        btnDelete.setDisable(true);
        btnDetail.setDisable(true);

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                if(newValue != null){
                    btnDelete.setDisable(false);
                    btnDetail.setDisable(false);
                }
            }
        });

    }


    public void addStudent(ActionEvent event){
        try{
            Student e = new Student(Integer.parseInt(txtID.getText()), txtName.getText(), txtEmail.getText(), Integer.parseInt(txtAge.getText()));
            studentList.add(e);
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid input type");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void deleteStudent(ActionEvent event){
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        System.out.println(selectedStudent);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Do you want to delete ?");
        alert.setContentText(selectedStudent.toString());
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().getButtonData().equals(ButtonBar.ButtonData.OK_DONE)){
            studentList.remove(selectedStudent);
        }
    }

    public void detailStudent(ActionEvent event){
        Student student = tableView.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentDetail.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
            stage.setScene(new Scene(parent));
            StudentDetailController detailController = loader.getController();
            detailController.setValue(student);
        } catch (IOException e) {
            System.out.println(getClass().getName());
            System.err.println(e.getCause().getMessage());
        }
    }
    public void actionClose(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }
}
