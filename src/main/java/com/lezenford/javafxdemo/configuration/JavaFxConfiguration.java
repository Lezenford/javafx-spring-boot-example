package com.lezenford.javafxdemo.configuration;

import com.lezenford.javafxdemo.controller.DemoController;
import com.lezenford.javafxdemo.controller.FxController;
import com.lezenford.javafxdemo.controller.MessageController;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaFxConfiguration {

    @Bean
    public DemoController demoController() {
        return FxController.init(new Stage(), "fxml/demo.fxml");
    }

    @Bean
    public MessageController messageController() {
        return FxController.init(new Stage(), "fxml/message.fxml");
    }
}
