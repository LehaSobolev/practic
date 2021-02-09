package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {
    @FXML
    public void openListDeputies(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("\\window_list_deputies.fxml"));
        Scene scene = new Scene(root,600,400);
Main.stage.setScene(scene);
Main.stage.show();
    }

    public void btnOpenListCommssions(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("\\window_list_commissions.fxml"));
        Scene scene = new Scene(root,600,400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    public void openListMeetings(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("\\window_list_meetings.fxml"));
        Scene scene = new Scene(root,600,400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }
}
    