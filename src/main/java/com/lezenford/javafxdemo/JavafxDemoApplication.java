package com.lezenford.javafxdemo;

import com.lezenford.javafxdemo.controller.DemoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class JavafxDemoApplication extends Application {

    public static void main(String[] args) {
        JavafxDemoApplication.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create FXML loader
        FXMLLoader fxmlLoader = new FXMLLoader();

        //create inputStream from resource fxml file
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fxml/demo.fxml")) {
            //fill loader from fxml file and get root element for scene
            Parent root = fxmlLoader.load(inputStream);

            //create Scene
            Scene scene = new Scene(root);

            //add link to stylesheet
            scene.getStylesheets().add("style.css");

            //set scene to stage
            primaryStage.setScene(scene);

            primaryStage.show();

            //get controller class from loader. In this case it call only as an example
            DemoController demoController = fxmlLoader.getController();
        }
    }
}
