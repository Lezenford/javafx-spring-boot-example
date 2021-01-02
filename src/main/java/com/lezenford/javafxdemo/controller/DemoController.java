package com.lezenford.javafxdemo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class DemoController extends FxController implements CommandLineRunner {
    private final MessageController messageController;
    private final String source = "fxml/demo.fxml";

    @FXML
    private Button button;

    @Override
    public void init() {
        button.setOnMouseClicked(event -> messageController.getStage().show());
        messageController.getStage().initOwner(getStage());
        messageController.getStage().initModality(Modality.APPLICATION_MODAL);
    }

    @Override
    public void run(String... args) {
        getStage().show();
    }
}
