package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    public void loginButtonClicked(){
        System.out.println("User Logged in...");
    }

    // This method is called as soon as the view loads
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data");
    }
}
