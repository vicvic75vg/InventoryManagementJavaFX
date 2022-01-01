package com.example.inventoryapp.controllers;

import com.example.inventoryapp.Inventory;
import com.example.inventoryapp.Main;
import com.example.inventoryapp.Part;
import com.example.inventoryapp.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part,Integer> partId;
    @FXML
    private TableColumn<Part,String> partName;
    @FXML
    private TableColumn<Part,Integer> partInvLevel;
    @FXML
    private TableColumn<Part,Double> partPrice;
    @FXML
    private TextField partSearchField;
    @FXML
    private Button partAddButton;
    @FXML
    private Button partModifyButton;
    @FXML
    private Button partDeleteButton;

    @FXML
    private TableView<Product> productsTable;
    @FXML
    private Button productAddButton;
    @FXML
    private Button productModifyButton;
    @FXML
    private Button productDeleteButton;

    @FXML
    private TextField productSearchField;
    @FXML
    private Button exitButton;

    private Inventory inv;




    public MainController(Inventory inv) {
        this.inv = inv;
    }



    @FXML
    private void addPart(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeSceneToAddPart();
    }
    public void exitButtonClick(ActionEvent event) {
        Main m = new Main();
        m.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        partId.setCellValueFactory(new PropertyValueFactory<Part,Integer>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<Part,String>("name"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part,Double>("price"));
        partInvLevel.setCellValueFactory(new PropertyValueFactory<Part,Integer>("stock"));

        partsTable.setItems(inv.getAllParts());
        partsTable.refresh();

    }
}
