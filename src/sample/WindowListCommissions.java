package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WindowListCommissions {
    public ListView<String> lvListCommissions;
    BaseData baseData = BaseData.getBaseData();

    public void initialize() throws SQLException {
        ObservableList<String> list = FXCollections.observableList(listText());
        lvListCommissions.setItems(list);
    }
    private ArrayList<String> listText() throws SQLException {
        ArrayList<Commission> commissions = baseData.selectCommissions();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <commissions.size(); i++) {
            String string = "Наименование: "+commissions.get(i).name + " председатель: "+commissions.get(i).chairman + " дата: "+commissions.get(i).date;
            strings.add(string);
        }
        return  strings;
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Main.stage.setScene(new Scene(root, 600, 400));
        Main.stage.show();
    }
}
