package com.example.inventoryapp;

import com.example.inventoryapp.controllers.AddPartController;
import com.example.inventoryapp.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    private static Inventory inv = new Inventory();


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        inv.addPart(new InHouse(1,"Something", 9.99, 9, 1,10,0221));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        MainController controller = new MainController(inv);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1020, 440);
        stage.setScene(scene);
        stage.setTitle("Inventory Management System");
        stage.show();
        stg = stage;
    }
    public void changeSceneToAddPart() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        AddPartController controller = new AddPartController(inv);

        loader.setController(controller);
        Parent root = loader.load();
        stg.getScene().setRoot(root);
    }

    public void changeSceneToMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        MainController controller = new MainController(inv);
        loader.setController(controller);
        Parent root = loader.load();
        stg.getScene().setRoot(root);
    }
    public void exit() {
        stg.close();
    }


}