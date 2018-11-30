package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String msg){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);// block user interaction with other windows until user has taken care of this window.
        window.setTitle(title);
        window.setMinWidth(250);

        Label lbl = new Label();
        lbl.setText(msg);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layoyt = new VBox(10);
        layoyt.getChildren().addAll(lbl, yesButton, noButton);
        layoyt.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layoyt);
        window.setScene(scene);
        window.showAndWait();
        return answer;

    }

}
