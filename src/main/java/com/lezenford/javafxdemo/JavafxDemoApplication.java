package com.lezenford.javafxdemo;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxDemoApplication extends Application {
    private static String[] args;

    public static void main(String[] args) {
        JavafxDemoApplication.args = args;
        JavafxDemoApplication.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SpringApplication.run(JavafxDemoApplication.class, args);
    }
}
