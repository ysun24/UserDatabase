package sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = new User(2,"a","b","c","d");
        DatabaseConnection.getInstance().addUser(user);
    }



}
