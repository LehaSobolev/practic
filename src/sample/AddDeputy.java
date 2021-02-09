package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddDeputy {

    public TextField FIO,adress,phone_h,phone_w,sex;

    public void AddDeputy(ActionEvent actionEvent) throws SQLException {
        BaseData.getBaseData().insertDeputy(new Deputy(0,FIO.getText(),adress.getText(),phone_h.getText(),phone_w.getText(),sex.getText()));
       Stage stage = (Stage) FIO.getScene().getWindow();
       stage.close();
    }
}
