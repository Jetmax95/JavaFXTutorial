package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Main extends Application {


    Stage window;
    Button button;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Choice Box Tutorial");
        button = new Button("Click me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();


        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().addAll("Apples","Banana","Kiwi","Melon");
        choiceBox.setValue(choiceBox.getItems().get(0));

        //Listen for selection changes Different types of lists have different types of selection models
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue) );
        // v is the property of the item, oldValue would be the previous selected item, newValue is the new item
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox, button);


        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
