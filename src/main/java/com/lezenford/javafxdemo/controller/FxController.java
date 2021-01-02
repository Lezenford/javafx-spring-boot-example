package com.lezenford.javafxdemo.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;

@Getter
@Setter
abstract public class FxController {
    private Stage stage;
    private Scene scene;

    public static  <T extends FxController> T init(Stage stage, String source) throws IOException {
        //Create FXML loader
        FXMLLoader fxmlLoader = new FXMLLoader();

        //create inputStream from resource fxml file
        try (InputStream inputStream = fxmlLoader.getClass().getClassLoader().getResourceAsStream(source)) {
            //fill loader from fxml file and get root element for scene
            Parent root = fxmlLoader.load(inputStream);

            //create Scene
            Scene scene = new Scene(root);

            //add link to stylesheet
            scene.getStylesheets().add("style.css");

            //set scene to stage
            stage.setScene(scene);

            //return controller
            T controller = fxmlLoader.getController();

            //inject stage and scene
            controller.setStage(stage);
            controller.setScene(scene);

            return controller;
        }
    }
}
