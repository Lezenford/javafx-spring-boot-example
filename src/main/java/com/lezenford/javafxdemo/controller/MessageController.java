package com.lezenford.javafxdemo.controller;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MessageController extends FxController{
    private final String source = "fxml/message.fxml";
}
