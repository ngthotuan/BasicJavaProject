package sample.LineChart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private LineChart<String, Number> lineChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<String, Number> an;
        int anSalary[] = {494,113,854,143,235,437,836,772,912,566,391,441};
        an = new XYChart.Series<>();
        an.getData().addAll(makeData(anSalary));
        an.setName("Salary of An");

        XYChart.Series<String, Number> binh;
        int binhSalary[] = {746,595,528,544,840,490,959,804,967,658,549,624};
        binh = new XYChart.Series<>();
        binh.getData().addAll(makeData(binhSalary));
        binh.setName("Salary of Binh");

        lineChart.getData().addAll(an, binh);
    }

    private  XYChart.Data<String, Number>[] makeData(int[] salary){
        final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int len = months.length;
        if(salary.length == len){
            XYChart.Data[] data = new XYChart.Data[len];
            for(int i = 0; i < len; i++){
                data[i] = new XYChart.Data<String, Number>(months[i], salary[i]);
            }
            return data;
        }
        return null;
    }

}
