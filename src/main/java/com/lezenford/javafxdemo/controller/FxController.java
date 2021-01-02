package com.lezenford.javafxdemo.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Getter
abstract public class FxController {
    private final Stage stage = new Stage();
    private Scene scene;

    protected abstract String getSource();

    //Init FX components
    {
        //Create FXML loader
        FXMLLoader fxmlLoader = new FXMLLoader();

        //create inputStream from resource fxml file
        try (InputStream inputStream = fxmlLoader.getClass().getClassLoader().getResourceAsStream(getSource())) {
            fxmlLoader.setControllerFactory(param -> this);

            //fill loader from fxml file and get root element for scene
            Parent root = fxmlLoader.load(inputStream);

            //create Scene
            scene = new Scene(root);

            //add link to stylesheet
            scene.getStylesheets().add("style.css");

            //set scene to stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    /**
     * FXML loader invoke method "initialize" by reflection if it exists after read full context
     * Not recommended for use
     */
    public void initialize() {
    }

    /**
     * Invoke after all initializations.
     * Recommended used for configuration components
     */
    @PostConstruct
    public void init(){}
}
