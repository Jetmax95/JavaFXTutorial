package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class AlertBox {

    public static void display(String title, String msg){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);// block user interaction with other windows until user has taken care of this window.
        window.setTitle(title);
        window.setMinWidth(250);

        Label lbl = new Label();
        lbl.setText(msg);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layoyt = new VBox(10);
        layoyt.getChildren().addAll(lbl, closeButton);
        layoyt.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layoyt);
        window.setScene(scene);
        window.showAndWait();

    }

}
