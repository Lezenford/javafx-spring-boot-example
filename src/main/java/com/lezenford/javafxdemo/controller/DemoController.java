package com.lezenford.javafxdemo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;

@Getter
public class DemoController extends FxController implements CommandLineRunner {

    @Autowired
    private MessageController messageController;

    @FXML
    private Button button;

    /**
     * FXML load is first and Spring init is second.
     * After spring init you can configure that controller
     */
    @PostConstruct
    private void init() {
        button.setOnMouseClicked(event -> messageController.getStage().show());
        messageController.getStage().initOwner(getStage());
        messageController.getStage().initModality(Modality.APPLICATION_MODAL);
    }

    @Override
    public void run(String... args) {
        getStage().show();
    }
}
