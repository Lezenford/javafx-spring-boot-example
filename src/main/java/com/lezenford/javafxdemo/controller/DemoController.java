package com.lezenford.javafxdemo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class DemoController {

    @FXML
    private Button button;

    /**
     * FXML loader invoke method "initialize" by reflection if it exists after read full context
     */
    public void initialize() {

    }
}
