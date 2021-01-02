package com.lezenford.javafxdemo;

import com.lezenford.javafxdemo.controller.DemoController;
import com.lezenford.javafxdemo.controller.FxController;
import com.lezenford.javafxdemo.controller.MessageController;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        DemoController demoController = FxController.init(primaryStage, "fxml/demo.fxml");

        //get message controller
        MessageController messageController = FxController.init(messageStage, "fxml/message.fxml");

        //set event to button
        demoController.getButton().setOnMouseClicked(event -> messageController.getStage().show());

        demoController.getStage().show();
    }
}
