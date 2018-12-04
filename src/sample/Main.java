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
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("TableView tutorial");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Qt.");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price Input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Quantity Input
        quantityInput= new TextField();
        quantityInput.setPromptText("Quantity");

        //Buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);



        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void addButtonClicked(){
        Product p = new Product();
        p.setName(nameInput.getText());
        p.setPrice(Double.parseDouble(priceInput.getText()));
        p.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(p);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Product> productsSelected, allProducts; //The item they have highlighted, All the products
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems();

        productsSelected.forEach(allProducts::remove);
    }
    // Get all of the products
    public ObservableList<Product> getProduct(){

        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Washing Maching", 6000, 10));
        products.add(new Product("Dryer Maching", 5000, 10));
        products.add(new Product("Pizza oven", 500.23, 50));
        products.add(new Product("Boiler", 200.90, 20));
        products.add(new Product("Pony", 20000, 1));
        return products;
    }
}
