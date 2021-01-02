package com.lezenford.javafxdemo.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DemoController {

    @FXML
    private Button button;

    /**
     * FXML loader invoke method "initialize" by reflection if it exists after read full context
     */
    public void initialize() {
        button.setOnMouseClicked(event -> Platform.exit());
    }
}
