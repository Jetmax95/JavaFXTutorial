package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        window.setTitle("Bucky's Meat Subs");



        CheckBox box1 = new CheckBox("Bacon");
        box1.setSelected(true); // Have it checked as default
        CheckBox box2 = new CheckBox("Tuna");
        CheckBox box3 = new CheckBox("Chicken");

        button = new Button("Order");
        button.setOnAction(e -> handleOptions(box1, box2, box3));



        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1,box2,box3,button);


        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2, CheckBox box3){
        String message = "";

        if(box1.isSelected())
            message += " " + box1.getText();

        if(box2.isSelected())
            message += " " + box2.getText();

        if(box3.isSelected())
            message += " " + box3.getText();

        System.out.println("User's order:");
        System.out.println(message);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
