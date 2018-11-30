package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Tutorial");

        Button button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

        window.setOnCloseRequest(e -> {
            e.consume(); //Consume the close button event
            closeProgram();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit the program?");
        if(answer) window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
