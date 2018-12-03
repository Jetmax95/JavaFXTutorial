package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.Tree;
import org.w3c.dom.Text;

public class Main extends Application {


    Stage window;
    TreeView<String> tree;

    Scene scene;

    //Every tree has one single root.
    //To the root we can add branches
    //We can add branches to the branches
    //Then we can have leaf notes

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("TreeView tutorial");


        TreeItem<String> root, bucky, megan;


        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Bucky
        bucky = makeBranch("Bucky", root); //Name and parent
        makeBranch("thenewboston", bucky);
        makeBranch("Youtube", bucky);
        makeBranch("Chicken", bucky);


        //Megan

        megan = makeBranch("Megan", root); //Name and parent
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);

        // Create tree
        tree = new TreeView<>(root); // All trees need a root passed in
        tree.setShowRoot(false); // An auto einai true fainetai ena epipleon root apo panw to opoio einai adeio
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null) System.out.println(newValue);
        });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    private TreeItem<String> makeBranch(String name, TreeItem<String> root){
        TreeItem<String> branch = new TreeItem<>(name);
        branch.setExpanded(true);
        root.getChildren().add(branch);
        return branch;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
