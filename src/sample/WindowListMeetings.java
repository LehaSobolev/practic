package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WindowListMeetings {
    @FXML
    private ListView<String> lvListMeetings;
    BaseData baseData = BaseData.getBaseData();

    public void initialize() throws SQLException {
        ObservableList<String> list = FXCollections.observableList(listText());
        lvListMeetings.setItems(list);
    }
    private ArrayList<String> listText() throws SQLException {
        ArrayList<Meetings> meetings = baseData.selectMeetings();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <meetings.size(); i++) {
            String string = "Организатор: "+meetings.get(i).Organizer + " дата: "+meetings.get(i).DateM;
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
