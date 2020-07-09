package sample.PieChart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private TextField txtCSharp, txtJava, txtPython;
    @FXML
    private PieChart pieChart;

    public void drawChart(ActionEvent event){
        int valueCSharp, valueJava, valuePython;
        try {
            valueCSharp = Integer.parseInt(txtCSharp.getText());
            valueJava = Integer.parseInt(txtJava.getText());
            valuePython = Integer.parseInt(txtPython.getText());

            PieChart.Data cSharp = new PieChart.Data("CSharp", valueCSharp);
            PieChart.Data java = new PieChart.Data("Java", valueJava);
            PieChart.Data python = new PieChart.Data("Python", valuePython);

            pieChart.getData().setAll(cSharp, java, python);

            for(PieChart.Data data : pieChart.getData()){
                data.getNode().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Data of "+ data.getName());
                        alert.setContentText(String.format("%s value: %d", data.getName(), (int)data.getPieValue()));
                        alert.showAndWait();
                    }
                });
            }
        } catch (Exception e){
            System.err.println(e.getCause());
        }
    }
}
