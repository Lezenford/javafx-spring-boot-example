package com.lezenford.javafxdemo;

import com.lezenford.javafxdemo.controller.DemoController;
import com.lezenford.javafxdemo.controller.MessageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class JavafxDemoApplication extends Application {

    public static void main(String[] args) {
        JavafxDemoApplication.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create new stage for message window
        Stage messageStage = new Stage();

        //set parent stage for massage window. It's optional step
        messageStage.initOwner(primaryStage);

        //set parent stage behavior when child stage is showing
        messageStage.initModality(Modality.APPLICATION_MODAL);

        //get demo controller
        DemoController demoController = (DemoController) init(primaryStage, "fxml/demo.fxml");

        //get message controller. In this case only as an example
        MessageController messageController = (MessageController) init(messageStage, "fxml/message.fxml");

        demoController.getButton().setOnMouseClicked(event -> messageStage.show());

        primaryStage.show();
    }

    private Object init(Stage stage, String source) throws IOException {
        //Create FXML loader
        FXMLLoader fxmlLoader = new FXMLLoader();

        //create inputStream from resource fxml file
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source)) {
            //fill loader from fxml file and get root element for scene
            Parent root = fxmlLoader.load(inputStream);

            //create Scene
            Scene scene = new Scene(root);

            //add link to stylesheet
            scene.getStylesheets().add("style.css");

            //set scene to stage
            stage.setScene(scene);

            //return controller
            return fxmlLoader.getController();
        }
    }
}
