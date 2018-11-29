package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Button button1 = new Button("Click me");
        button1.setOnAction(e -> AlertBox.display("Title","HELLO"));


        StackPane layout = new StackPane();
        layout.getChildren().add(button1);

        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.setTitle("Title here");
        window.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
