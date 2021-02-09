package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WindowListDeputies {
    public  ListView<String> lvListDeputies;
     BaseData baseData = BaseData.getBaseData();
     String selectedDeputy;

    public  void initialize() throws SQLException {
        ObservableList<String> list = FXCollections.observableList(listText());
lvListDeputies.setItems(list);

        MultipleSelectionModel<String> langsSelectionModel = lvListDeputies.getSelectionModel();

        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

                selectedDeputy = newValue;
            }
        });
    }
    private  ArrayList<String> listText() throws SQLException {
        ArrayList<Deputy> deputies = baseData.selectDeputies();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <deputies.size(); i++) {
            String string = "ФИО: "+deputies.get(i).FIO + " пол: "+deputies.get(i).Sex + " адрес: "+deputies.get(i).Addres;
            strings.add(string);
        }
        return  strings;
    }


    public void addDeputy(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addDeputy.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public void deleteDeputy(ActionEvent actionEvent) throws SQLException {
        String pattern = "(?!Ф)[^ИО:](.+?)(?= пол:)";
        // Создаем объект Pattern
        Pattern r = Pattern.compile(pattern);
        // Теперь создаем объект соответствия.
        Matcher m = r.matcher(selectedDeputy);
        while (m.find()) {
            baseData.delete(m.group());
            initialize();
        }
    }
    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Main.stage.setScene(new Scene(root, 600, 400));
        Main.stage.show();
    }
}
