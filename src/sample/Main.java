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
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Properties");

        Person bucky = new Person();
        bucky.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
            System.out.println("getFirstName(): " + bucky.getFirstName());

        });

        button = new Button("Submit");
        button.setOnAction(e -> bucky.setFirstName("Porky"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add("sample/Viper.css");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}
