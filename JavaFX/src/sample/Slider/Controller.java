package sample.Slider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Slider slider;
    @FXML
    private TextField textField;

    static final double INIT_VALUE = 50;
    static final double MAX_VALUE = 200;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider.setValue(INIT_VALUE);
        slider.setMax(MAX_VALUE);
//        textField.setText(String.valueOf(slider.getValue()));
        textField.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
//        textField.textProperty().bindBidirectional(slider.valueProperty(), new StringConverter<Number>() {
//            @Override
//            public String toString(Number object) {
//                return String.format("%d", object.intValue());
//            }
//
//            @Override
//            public Integer fromString(String string) {
//                Integer integer = null;
//                try{
//                    Double d = Double.parseDouble(string);
//                    integer = d.intValue();
////                    integer = Integer.parseInt(string);
//                } catch (Exception e){
//                    System.err.printf("User input invalid %s\n", e.getMessage());
//                }
//                return integer;
//            }
//        });
    }
}
