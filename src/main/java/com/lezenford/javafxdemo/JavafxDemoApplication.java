package com.lezenford.javafxdemo;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxDemoApplication extends Application {

	public static void main(String[] args) {
		JavafxDemoApplication.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
	}
}
