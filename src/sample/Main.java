package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.Tree;
import org.w3c.dom.Text;

public class Main extends Application {


    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("CSS Themes and Styles");



        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label - constrains use (child,column,row)
        Label nameLabel = new Label("Username: ");
        nameLabel.setId("bold-label"); //Selection by ID
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput, 1, 0 );

        //Password label
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel,0,1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Login button
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton,1,2);

        loginButton.setOnAction(e -> {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });

        //Sign up
        Button signUpButton = new Button("Sign up");
        signUpButton.getStyleClass().add("button-blue"); // Selection by class
        GridPane.setConstraints(signUpButton, 1 , 3);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,signUpButton);

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add("sample/Viper.css");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}
