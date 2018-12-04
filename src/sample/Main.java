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
    BorderPane layout;


    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Making Menus tutorial");

        //File menu
        Menu fileMenu = new Menu("_File");

        //Menu items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings"));
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting some crap"));
        editMenu.getItems().add(paste);

        //Help menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line numbers");

        showLines.setOnAction(e -> {
            if(showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line numbers");
        });

        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);

        helpMenu.getItems().addAll(showLines, autoSave);


        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup(); //User can only select one item at the time

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup((difficultyToggle));
        medium.setToggleGroup((difficultyToggle));
        hard.setToggleGroup((difficultyToggle));

        difficultyMenu.getItems().addAll(easy,medium,hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}
